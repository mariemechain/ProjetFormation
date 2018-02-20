package fr.formation.disponibilite.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.disponibilite.annexe.IOrdinateurDAO;
import fr.formation.disponibilite.annexe.ISalleDAO;
import fr.formation.disponibilite.annexe.IVideoProjecteurDAO;
import fr.formation.disponibilite.annexe.Ordinateur;
import fr.formation.disponibilite.annexe.Projet;
import fr.formation.disponibilite.annexe.Salle;
import fr.formation.disponibilite.annexe.VideoProjecteur;
import fr.formation.disponibilite.model.Disponibilite;

@Controller
@RequestMapping("/disponibilite")
public class DisponibiliteController {
	
	@Autowired
	IOrdinateurDAO ordiDao;
	@Autowired
	IVideoProjecteurDAO videoProjDao;
	@Autowired
	ISalleDAO salleDao;

	@GetMapping("")
	public String afficheSemaine(Model model) {
		List<Disponibilite> dispo = new ArrayList<Disponibilite>();
		
		LocalDate debut = LocalDate.now(); //date du jour
		System.out.println(debut);
		LocalDate fin = debut.plusMonths(1); //date dans 1 mois
		double duree = ChronoUnit.DAYS.between(debut, fin);
		
		//Ne prend pas le dernier jour du mois par exemple du 20/02/2018 au 19/03/2018
		for(int i=0;i<duree;i++) {
			System.out.println("debut for");
			Disponibilite infoDate = new Disponibilite();
			
			LocalDate date = debut.plusDays(i);
			System.out.println(date);
			infoDate.setDate(date);
			
			infoDate.setEtatOrdi(getPourcentageOrdi(date));
			//infoDate.setEtatSalle(getPourcentageSalle(date));
			//infoDate.setEtatVideoProj(getPourcentageProjecteur(date));
			System.out.println("fin for");
		}
				
		model.addAttribute("liste", dispo);
		return "disponibilite";
	}
	
	

	
	//Pour les ordinateurs
	private double getPourcentageOrdi(LocalDate d1) {
		List<Ordinateur> ordinateurs = this.ordiDao.findAll();
		int compteurOrdiIndispo = 0 ; //Le nombre maxi d'ordinateur dispo
		for(Ordinateur o : ordinateurs) {
			List<Projet> projets = o.getDispo(); //La liste des projets de chaque ordinateur
			
			for(Projet p : projets) {
				Date dateD = p. getDebut();
				java.sql.Date dateDebut = (java.sql.Date) dateD;
				int duree = p.getDuree();
				List<LocalDate> listeIndisponibilite = obtenirListeIndisponibilite(dateDebut,duree);
				
				for(LocalDate d2 : listeIndisponibilite) {
					if(d2.equals(d1)) {
						compteurOrdiIndispo++; //enlever un ordinateur disponible	
					}
				}
			}
		}
		return 100*(ordinateurs.size()-compteurOrdiIndispo)/ordinateurs.size();
	}
	
	
	
	//Pour les salles
	private double getPourcentageSalle(LocalDate d1) {
		List<Salle> salles = salleDao.findAll();
		int compteurSalleIndispo = 0; //Le nombre maxi de salles dispo
		
		for(Salle s : salles) {
			List<Projet> projets = s.getDispo(); //La liste des projets de chaque ordinateur [nom de méthode à verifier]
			for(Projet p : projets) {
				Date dateD = p. getDebut();
	java.sql.Date dateDebut = (java.sql.Date) dateD;
				int duree = p.getDuree();
				List<LocalDate> listeIndisponibilite = obtenirListeIndisponibilite(dateDebut,duree);
				
				for(LocalDate d2 : listeIndisponibilite) {
					if(d2==d1) {
						compteurSalleIndispo++; //enlever une salle disponible	
					}
				}
			}
		}
		
		return 100*(salles.size()- compteurSalleIndispo)/salles.size();
	}
	
	
	
	//Pour les videos projecteurs
	private double getPourcentageProjecteur(LocalDate d1) {
		List<VideoProjecteur> videoProjecteurs = videoProjDao.findAll();
		int compteurProjoIndispo = 0; //Le nombre maxi d'ordinateur dispo
		
		for(VideoProjecteur v : videoProjecteurs) {
			List<Projet> projets = v.getDispo(); //La liste des projets de chaque ordinateur [nom de méthode à verifier]
			for(Projet p : projets) {
				Date dateD = p. getDebut();
				java.sql.Date dateDebut = (java.sql.Date) dateD;
				int duree = p.getDuree();
				List<LocalDate> listeIndisponibilite = obtenirListeIndisponibilite(dateDebut,duree);
				
				for(LocalDate d2 : listeIndisponibilite) {
					if(d2==d1) {
						compteurProjoIndispo++; //enlever un ordinateur disponible	
					}
				}
			}
		}
		
		return 100*(videoProjecteurs.size()- compteurProjoIndispo)/videoProjecteurs.size();
	}
	
	
	private List<LocalDate> obtenirListeIndisponibilite(java.sql.Date dateDebut, int duree) {
		List<LocalDate> listeDate = new ArrayList<LocalDate>();
		LocalDate debut = dateDebut.toLocalDate();
		for(int i=0;i<duree;i++) {
			LocalDate d = debut.plusDays(i);
			listeDate.add(d);
		}
		return listeDate;
	}
}
