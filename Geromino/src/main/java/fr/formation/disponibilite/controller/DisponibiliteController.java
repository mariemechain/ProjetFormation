package fr.formation.disponibilite.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.disponibilite.annexe.Ordinateur;
import fr.formation.disponibilite.annexe.Projet;
import fr.formation.disponibilite.annexe.Salle;
import fr.formation.disponibilite.annexe.VideoProjecteur;
import fr.formation.disponibilite.model.Disponibilite;

@Controller
@RequestMapping("/disponibilite")
public class DisponibiliteController {
	
	@Autowired
	IOrdinateurDao ordiDao;
	@Autowired
	IVideoProjecteurDao videoProjDao;
	@Autowired
	ISalleDao salleDao;

	@GetMapping("")
	public String afficheSemaine(Model model) {
		List<Disponibilite> dispo = new ArrayList<Disponibilite>();
		
		LocalDate debut = LocalDate.now(); //date du jour
		LocalDate fin = debut.plusMonths(1); //date dans 6 mois
		Period duree = Period.between(debut, fin);
		
		for(int i=0;i<duree.getDays();i++) {
			Disponibilite infoDate = new Disponibilite();
			LocalDate date = debut.plusDays(i);
			infoDate.setDate(date);
			infoDate.setEtatOrdi(getPourcentageOrdi(date));
			infoDate.setEtatSalle(getPourcentageSalle(date));
			infoDate.setEtatVideoProj(getPourcentageProjecteur(date));
		}
				
		model.addAttribute("liste", dispo);
		return "disponibilite";
	}
	
	

	
	//Pour les ordinateurs
	private double getPourcentageOrdi(LocalDate d1) {
		List<Ordinateur> ordinateurs = this.ordiDao.findAll();
		int compteurOrdiDispo = ordinateurs.size(); //Le nombre maxi d'ordinateur dispo
		
		for(Ordinateur o : ordinateurs) {
			List<Projet> projets = o.getDispo(); //La liste des projets de chaque ordinateur [nom de méthode à verifier]
			for(Projet p : projets) {
				Date dateDebut = p. getDebut();
				int duree = p.getDuree();
				List<LocalDate> listeIndisponibilite = obtenirListeIndisponibilite(dateDebut,duree);
				
				for(LocalDate d2 : listeIndisponibilite) {
					if(d2==d1) {
						compteurOrdiDispo--; //enlever un ordinateur disponible	
					}
				}
			}
		}
		
		return 100*(ordinateurs.size()- compteurOrdiDispo)/ordinateurs.size();
	}
	
	
	
	//Pour les salles
	private double getPourcentageSalle(LocalDate d1) {
		List<Salle> salles = salleDao.findAll();
		int compteurSalleDispo = salles.size(); //Le nombre maxi de salles dispo
		
		for(Salle s : salles) {
			List<Projet> projets = s.getDispo(); //La liste des projets de chaque ordinateur [nom de méthode à verifier]
			for(Projet p : projets) {
				Date dateDebut = p. getDebut();
				int duree = p.getDuree();
				List<LocalDate> listeIndisponibilite = obtenirListeIndisponibilite(dateDebut,duree);
				
				for(LocalDate d2 : listeIndisponibilite) {
					if(d2==d1) {
						compteurSalleDispo--; //enlever une salle disponible	
					}
				}
			}
		}
		
		return 100*(salles.size()- compteurSalleDispo)/salles.size();
	}
	
	
	
	//Pour les videos projecteurs
	private double getPourcentageProjecteur(LocalDate d1) {
		List<VideoProjecteur> videoProjecteurs = videoProjDao.findAll();
		int compteurProjoDispo = videoProjecteurs.size(); //Le nombre maxi d'ordinateur dispo
		
		for(VideoProjecteur v : videoProjecteurs) {
			List<Projet> projets = v.getDispo(); //La liste des projets de chaque ordinateur [nom de méthode à verifier]
			for(Projet p : projets) {
				Date dateDebut = p. getDebut();
				int duree = p.getDuree();
				List<LocalDate> listeIndisponibilite = obtenirListeIndisponibilite(dateDebut,duree);
				
				for(LocalDate d2 : listeIndisponibilite) {
					if(d2==d1) {
						compteurProjoDispo--; //enlever un ordinateur disponible	
					}
				}
			}
		}
		
		return 100*(videoProjecteurs.size()- compteurProjoDispo)/videoProjecteurs.size();
	}
	
	private List<LocalDate> obtenirListeIndisponibilite(Date dateDebut, int duree) {
		List<LocalDate> listeDate = new ArrayList<LocalDate>();
		LocalDate debut = dateDebut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		for(int i=0;i<duree;i++) {
			LocalDate d = debut.plusDays(i);
			listeDate.add(d);
		}
		return listeDate;
	}
}
