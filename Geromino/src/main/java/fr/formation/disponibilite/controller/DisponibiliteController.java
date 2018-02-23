package fr.formation.disponibilite.controller;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.disponibilite.model.Disponibilite;
import fr.formation.ressources.dao.IOrdinateurDAO;
import fr.formation.ressources.dao.ISalleDAO;
import fr.formation.ressources.dao.IVideoProjecteurDAO;
import fr.formation.ressources.metier.Ordinateur;
import fr.formation.ressources.metier.Projet;
import fr.formation.ressources.metier.Salle;
import fr.formation.ressources.metier.VideoProjecteur;

@Controller
@RequestMapping("/technicien/disponibilite")
public class DisponibiliteController {
	
	@Autowired
	IOrdinateurDAO ordiDao;
	@Autowired
	IVideoProjecteurDAO videoProjDao;
	@Autowired
	ISalleDAO salleDao;
	
	@ModelAttribute("page")
	public String page() {
		return "technicien";
	}

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
			
			if(o.getDate() != null){
				Date retourMaintenanceAConvertir = o.getDate();			
				Instant instant = Instant.ofEpochMilli(retourMaintenanceAConvertir.getTime());
				LocalDate retourMaintenance = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
				
				if(retourMaintenance.isAfter(d1))
					compteurOrdiIndispo++;
			}
			
			for(Projet p : projets) {
				Date dateD = p. getDateDebut();				
				java.sql.Date dateDebut = (java.sql.Date) dateD;
				LocalDate dateDebut2 = dateDebut.toLocalDate();
				int duree = p.getDuree();
				
				duree = add(dateDebut2, duree);
								
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
			
			for(Projet p : projets) {
				Date dateD = p. getDateDebut();
				java.sql.Date dateDebut = (java.sql.Date) dateD;
				int duree = p.getDuree();
				List<LocalDate> listeIndisponibilite = obtenirListeIndisponibilite(dateDebut,duree);
				
				for(LocalDate d2 : listeIndisponibilite) {
					if(d2.equals(d1)) {
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
			
			for(Projet p : projets) {
				Date dateD = p. getDateDebut();
				java.sql.Date dateDebut = (java.sql.Date) dateD;
				int duree = p.getDuree();
				List<LocalDate> listeIndisponibilite = obtenirListeIndisponibilite(dateDebut,duree);
				
				for(LocalDate d2 : listeIndisponibilite) {
					if(d2.equals(d1)) {
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
				mois = "Février";
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
				mois = "Août";
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
	
	public int add(LocalDate date, int duree){

	    int dureePlusWeekend=duree;
	    int addedDays = 0;
	    
	    List<LocalDate> listeDate = new ArrayList<LocalDate>();
	    LocalDate dateFin = date.plusDays(duree);
		for(int i=0;i<duree;i++) {
			LocalDate d = date.plusDays(i);
			listeDate.add(d);
		}
	    
	    for(LocalDate d : listeDate) {
		    if (d.getDayOfWeek() == DayOfWeek.SATURDAY || d.getDayOfWeek() == DayOfWeek.SUNDAY) {
		      ++addedDays;
		    }
	    }
	    
	    dureePlusWeekend = duree + addedDays;
	    
	    return dureePlusWeekend;
	}
	
}
