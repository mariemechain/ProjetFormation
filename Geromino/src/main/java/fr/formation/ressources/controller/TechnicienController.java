package fr.formation.ressources.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.dao.IOrdinateurDAO;
import fr.formation.ressources.dao.IStagiaireDAO;
import fr.formation.ressources.dao.ITechnicienDAO;
import fr.formation.ressources.dao.IVideoProjecteurDAO;
import fr.formation.ressources.metier.Ordinateur;
import fr.formation.ressources.metier.Projet;
import fr.formation.ressources.metier.Stagiaire;
import fr.formation.ressources.metier.VideoProjecteur;

@Controller
@RequestMapping("/technicien")
public class TechnicienController {

	@ModelAttribute("page")
	public String page() {
		return "technicien";
	}

	@Autowired
	private ITechnicienDAO techDAO;
	@Autowired
	private IOrdinateurDAO ordiDAO;
	@Autowired
	private IVideoProjecteurDAO videoDAO;
	@Autowired
	private IStagiaireDAO stagDAO;

	@GetMapping("")
	public String tech(Model model) {

		return "technicien";
	}

	// ***********************************************************************************************
	// ****************************ORDI**************************************************************
	// ***********************************************************************************************

	@GetMapping("/ordi")
	public String listeOrdi(Model model) {
		model.addAttribute("ordinateurs", ordiDAO.findAll());
		return "techOrdi";
	}

	// *********************** Ajouter un ordi*********************
	@GetMapping("/ordi/ajouter")
	public String ajouterOrdi(Model model) {
		model.addAttribute("ordinateur", new Ordinateur());
		return "ajouterOrdi";
	}

	@PostMapping("/ordi/ajouter")
	public String sauvegardeOrdi(@Valid @ModelAttribute("ordinateur") Ordinateur ordinateur, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "ajouterOrdi";
		}
		ordiDAO.save(ordinateur);
		return "redirect:./";
	}

	// ******************** Modifier un ordi**************************
	@GetMapping("/ordi/modifier")
	public String modifOrdi(Model model, @RequestParam("id") String idOrdi) {
		model.addAttribute("ordinateur", ordiDAO.findById(idOrdi).get());
		return "ajouterOrdi";
	}

	@PostMapping("/ordi/modifier")

	public String modifierOrdi(@Valid @ModelAttribute("ordinateur") Ordinateur ordinateur, BindingResult result,
			Model model, @RequestParam("id") String idOrdi) {
		if (result.hasErrors()) {
			return "ajouterOrdi";
		}
		// ordinateur.setId(idOrdi);
		ordinateur.setDate(ordiDAO.findById(idOrdi).get().getDate());
		ordiDAO.save(ordinateur);
		return "redirect:./";
	}

	// ********************Modifier dispo ordinateur******************
	@GetMapping("/ordi/etat")
	public String dispoOrdi(Model model, @RequestParam("id") String idOrdi) {
		model.addAttribute("ordinateur", ordiDAO.findById(idOrdi).get());
		return "dispoOrdi";
	}

	@PostMapping("/ordi/etat")
	public String dispoOrdinateur(@RequestParam("id") String idOrdi,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		Ordinateur ordi = ordiDAO.findById(idOrdi).get();
		ordi.setDate(date);
		ordiDAO.save(ordi);
		return "redirect:./";
	}

	// ***********************Supprimer un ordi***************************
	@GetMapping("/ordi/supprimer")
	public String deleteOrdi(@RequestParam("id") String idOrdi) {
		ordiDAO.deleteById(idOrdi);
		return "redirect:./";
	}

	// **********************************************************************************
	// ****************************VIDEO*************************************************
	// **********************************************************************************

	@GetMapping("/video")
	public String listeVideo(Model model) {
		model.addAttribute("videoprojecteurs", videoDAO.findAll());
		return "techVideo";
	}

	// ************************* Ajouter un videoproj***************************
	@GetMapping("/video/ajouter")
	public String ajouterVideo(Model model) {
		model.addAttribute("videoprojecteur", new VideoProjecteur());
		return "ajouterVideo";
	}

	@PostMapping("/video/ajouter")
	public String sauvegardeVideo(@Valid @ModelAttribute("videoprojecteur") VideoProjecteur videoprojecteur,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "ajouterVideo";
		}
		videoDAO.save(videoprojecteur);
		return "redirect:./";
	}

	// ***************** Modifier un videoproj*********************************
	@GetMapping("/video/modifier")
	public String modifVideoprojecteur(Model model, @RequestParam("id") String idVideo) {
		model.addAttribute("videoprojecteur", videoDAO.findById(idVideo).get());
		return "ajouterVideo";
	}

	@PostMapping("/video/modifier")
	public String modifVideoprojecteur(@Valid @ModelAttribute("videoprojecteur") VideoProjecteur videoprojecteur,
			BindingResult result, @RequestParam("id") String idVideo, Model model) {
		if (result.hasErrors()) {
			// model.addAttribute("videoprojecteur",
			// videoDAO.findById(idVideo).get());
			return "ajouterVideo";
		}
		videoprojecteur.setId(idVideo);
		videoDAO.save(videoprojecteur);
		return "redirect:./";
	}

	// *************Modifier dispo videoproj*************
	@GetMapping("/video/etat")
	public String dispoVideo(Model model, @RequestParam("id") String idVideo) {
		model.addAttribute("videoprojecteur", videoDAO.findById(idVideo).get());
		return "dispoVideo";
	}

	@PostMapping("/video/etat")
	public String dispoVideoprojecteur(@RequestParam("id") String idVideo,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		// if (result.hasErrors()) {
		// return "dispoVideo";
		// }
		VideoProjecteur video = videoDAO.findById(idVideo).get();
		video.setDate(date);
		videoDAO.save(video);
		return "redirect:./";
	}

	// ************************Supprimer un videoproj***************************
	@GetMapping("/video/supprimer")
	public String deleteVideo(@RequestParam("id") String idVideo) {
		videoDAO.deleteById(idVideo);
		return "redirect:./";
	}

	// ***************************************************************************
	// ****************************Allouer ORDI*******************
	// ***************************************************************************

	@GetMapping("/ordi/allouer")
	public String allouerOrdi(Model model, @RequestParam("id") String idOrdi) {

		Ordinateur ordinateur = ordiDAO.findById(idOrdi).get();
		model.addAttribute(ordinateur);
		
		List<Stagiaire> stagiaires = stagDAO.findAll(); //Chargement de tous les stagiaires en base
		System.out.println(stagiaires.size() + " monique");
		
		
		for(int i=stagiaires.size()-1; i>=0; i--) {
			
			//seuls les stagiaires avec une formation sont pris en compte
			if(stagiaires.get(i).getFormation() == null) {
				stagiaires.remove(i); //sortie des stagiaires qui n'ont pas de projet
				System.out.println(stagiaires.size() + " Tamèrezbwdhfk");
			}
			
			else {
				System.out.println(stagiaires.size() + " Tamère");
				
				if(stagiaires.get(i).getOrdinateur() != null) {
					stagiaires.remove(i); //sortie des stagiaires qui ont dï¿½jï¿½ un ordinateur 
				}
			}
		}
				
		System.out.println(stagiaires.size() + " EZHJGFQKSGFJWDGV"); //normalement 1

		//verifier si l'ordi est dispo au moment du projet du stagiaire
		for (int i=0;i<stagiaires.size();i++) {
			boolean verif = true;
			
			Projet projet = stagiaires.get(i).getFormation(); //le stagiaire a forcement un projet donc jamais null
			
			List<LocalDate> dateProjetStagiaire = obtenirListeIndisponibilite((java.sql.Date) projet.getDateDebut(),projet.getDuree());

			for (LocalDate ld : dateProjetStagiaire) {
				
				verif = getDispoOrdi(ld, ordinateur);
				System.out.println(verif);
				if (verif == false) {
					
					for (int j = 0; j < stagiaires.size(); j++) {
						if (stagiaires.get(j).getId() == stagiaires.get(i).getId()) {
							stagiaires.remove(j); //On supprime le stagiaire s de la liste des stagiaires possible pour l'ordinateur
						}
					}
				}
			}
		}
		
		model.addAttribute("stagiaires", stagiaires);
		return "allouerOrdi";
	}
	
	
	

	private boolean getDispoOrdi(LocalDate d1, Ordinateur ordinateur) {
		
		List<Stagiaire> stagiairesOrdi = new ArrayList<Stagiaire>();
		if (ordinateur.getStagiaires()!= null) {
		stagiairesOrdi = ordinateur.getStagiaires();
		}
		

		for (Stagiaire s : stagiairesOrdi) {
			Projet p = s.getFormation(); //Projet du stagiaire s
			
			Date dateD = p.getDateDebut(); 
			java.sql.Date dateDebut = (java.sql.Date) dateD; //Date de debut du projet p en SQL
			
			int duree = p.getDuree();
			
			List<LocalDate> listeIndisponibilite = obtenirListeIndisponibilite(dateDebut, duree);

			for (LocalDate d2 : listeIndisponibilite) {
				if (d2.equals(d1)) {
					return false;
				}
			}
		}
		return true;
	}

	private List<LocalDate> obtenirListeIndisponibilite(java.sql.Date dateDebut, int duree) {
		List<LocalDate> listeDate = new ArrayList<LocalDate>();
		LocalDate debut = dateDebut.toLocalDate();
		for (int i = 0; i < duree; i++) {
			LocalDate d = debut.plusDays(i);
			listeDate.add(d);
		}
		return listeDate;
	}

	@PostMapping("/ordi/allouer")
	public String allouerOrdinateur(@RequestParam("id") String idOrdi, @RequestParam("stagiaires") int idStagiaire) {
		Ordinateur ordinateur = ordiDAO.findById(idOrdi).get();
		Stagiaire s = stagDAO.findById(idStagiaire).get();
		s.setOrdinateur(ordinateur);
		ordiDAO.save(ordinateur);
		stagDAO.save(s);
		return "redirect:./";
	}

}
