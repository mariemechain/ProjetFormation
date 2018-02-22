package fr.formation.disponibilite.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	

	private String premierMois;
	private Map<Integer, String> mois = new HashMap<Integer, String>();

	@GetMapping("")
	public String afficheSemaine(Model model) {
		
		List<Disponibilite> dispo = new ArrayList<Disponibilite>();
		
		LocalDate debut = LocalDate.now(); //date du jour
		LocalDate fin = debut.plusMonths(6); //date dans 1 mois
		double duree = ChronoUnit.DAYS.between(debut, fin);
		
		premierMois = moisFrancais(debut.getMonth());
		model.addAttribute("premierMois", premierMois);
		for (int i=0; i<6; i++)
			mois.put(i+1, moisFrancais(debut.getMonth().plus(i+1)));
		model.addAttribute("premierMois", premierMois);
		model.addAttribute("listeMois", mois);
		
		//Ne prend pas le dernier jour du mois par exemple du 20/02/2018 au 19/03/2018
		for (int i=0; i<duree; i++) {
			Disponibilite infoDate = new Disponibilite();
			LocalDate date = debut.plusDays(i);
			Period p = Period.between(debut, date);
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
			Date date2 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
			infoDate.setDate(formatter.format(date2));
			
			if(debut.getMonthValue()==date.getMonthValue())
				infoDate.setId(1);
			else
				infoDate.setId((12 + date.getMonthValue()- debut.getMonthValue())%12 + 1);	
			
			infoDate.setEtatOrdi(getPourcentageOrdi(date));
			infoDate.setEtatSalle(getPourcentageSalle(date));
			infoDate.setEtatVideoProj(getPourcentageProjecteur(date));
			dispo.add(infoDate);
		}
		
		model.addAttribute("liste", dispo);
		
		return "disponibilite";
	}

	
	//Pour les ordinateurs
	private double getPourcentageOrdi(LocalDate d1) {
		List<Ordinateur> ordinateurs = this.ordiDao.findAll();
		int compteurOrdiIndispo = 0 ; //Le nombre maxi d'ordinateur pas dispo
		for(Ordinateur o : ordinateurs) {
			List<Projet> projets = o.getDispo(); //La liste des projets de chaque ordinateur
			
			if(o.getDate() != null) {
				Date retourMaintenanceAConvertir = o.getDate();			
				Instant instant = Instant.ofEpochMilli(retourMaintenanceAConvertir.getTime());			
				LocalDate retourMaintenance = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
				
				if(retourMaintenance.isAfter(d1))
					compteurOrdiIndispo++;
			}
			
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
		if(ordinateurs.size()!=0) {
			return 100*(ordinateurs.size()-compteurOrdiIndispo)/ordinateurs.size();
		}
		else
			return 0;
		
	}
	
	//Pour les salles
	private double getPourcentageSalle(LocalDate d1) {
		List<Salle> salles = salleDao.findAll();
		int compteurSalleIndispo = 0; //Le nombre maxi de salles indisponibles
		
		for(Salle s : salles) {
			List<Projet> projets = s.getDispo(); //La liste des projets de chaque ordinateur
			
			if(s.getDate() != null) {
				Date retourMaintenanceAConvertir = s.getDate();			
				Instant instant = Instant.ofEpochMilli(retourMaintenanceAConvertir.getTime());			
				LocalDate retourMaintenance = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
				
				if(retourMaintenance.isAfter(d1))
					compteurSalleIndispo++;
			}
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
		
		if(salles.size() != 0)
			return 100*(salles.size()- compteurSalleIndispo)/salles.size();
		else
			return 0;
	}
	
	//Pour les videos projecteurs
	private double getPourcentageProjecteur(LocalDate d1) {
		List<VideoProjecteur> videoProjecteurs = videoProjDao.findAll();
		int compteurProjoIndispo = 0; //Le nombre maxi d'ordinateur dispo
		
		for(VideoProjecteur v : videoProjecteurs) {
			List<Projet> projets = v.getDispo(); //La liste des projets de chaque ordinateur
			if(v.getDate() != null) {
				Date retourMaintenanceAConvertir = v.getDate();			
				Instant instant = Instant.ofEpochMilli(retourMaintenanceAConvertir.getTime());			
				LocalDate retourMaintenance = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
				
				if(retourMaintenance.isAfter(d1))
					compteurProjoIndispo++;
			}
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
		if(videoProjecteurs.size() != 0)
			return 100*(videoProjecteurs.size()- compteurProjoIndispo)/videoProjecteurs.size();
		else
			return 0;
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
	
	private String moisFrancais(Month moisAnglais) {
		String mois = "";
		switch ( moisAnglais ) {
			case JANUARY :
				mois = "Janvier";
				break;
			case FEBRUARY :
				mois = "F�vrier";
				break;
			case MARCH :
				mois = "Mars";
				break;
			case APRIL :
				mois = "Avril";
				break;
			case MAY :
				mois = "Mai";
				break;
			case JUNE :
				mois = "Juin";
				break;
			case JULY :
				mois = "Juillet";
				break;
			case AUGUST :
				mois = "Ao�t";
				break;
			case SEPTEMBER :
				mois = "Septembre";
				break;
			case OCTOBER :
				mois = "Octobre";
				break;
			case NOVEMBER :
				mois = "Novembre";
				break;
			case DECEMBER :
				mois = "Decembre";
				break;
		}
		return mois;
	}
	
}
