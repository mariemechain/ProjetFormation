package fr.formation.projets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.formateur.dao.IFormateurDAO;
import fr.formation.matieres.dao.IMatiereDAO;
import fr.formation.projets.dao.IPlanificationDAO;
import fr.formation.projets.dao.IProjetDAO;
import fr.formation.projets.dao.ISalleDAO;
import fr.formation.projets.dao.ITemplateDAO;
import fr.formation.projets.model.OrdreMatiere;
import fr.formation.projets.model.Planification;
import fr.formation.projets.model.Projet;
import fr.formation.projets.model.Template;
import fr.formation.ressources.metier.Salle;
import fr.formation.ressources.metier.Stagiaire;

@Controller
@RequestMapping("/projet")
public class ProjetController {

	@Autowired
	private IProjetDAO daoProjet;

	@Autowired
	private ISalleDAO daoSalle;

	@Autowired
	private ITemplateDAO daoTemplate;

	@Autowired
	private IFormateurDAO daoFormateur;

	@Autowired
	private IMatiereDAO daoMatiere;

	@Autowired
	private IPlanificationDAO daoPLanification;

	/** ==============================================
	 * CRUD : SELECT - SAVE (ADD / EDIT) - DELETE
	 * ============================================== */

	/* ==============================================
	 * SELECT
	 * ============================================== */

	/**
	 * Recupere la liste des projets
	 */
	@GetMapping("")
	public String liste(Model model) {
		model.addAttribute("Projet", daoProjet.findAll());
		return "projet/listeprojet";
	}
	
	
	/* ==============================================
	 * AJOUTER 
	 * ============================================== */
	 

	// Ajout de projet en choissisant les matiï¿½res et formateurs
	@GetMapping("/ajouter")
	public String ajouter(Model model) {
		model.addAttribute("projet", new Projet());
	    
		model.addAttribute("salles", daoSalle.findAll());
	    model.addAttribute("templates", daoTemplate.findAll());
	    
		return "projet/addprojet";
	}

	@PostMapping("/ajouter")
	public String ajouter(@ModelAttribute("projet") Projet projet, @RequestParam String idSalle, @RequestParam int idTemplate) {

		Salle s = daoSalle.findById(idSalle).get();
		Template t = daoTemplate.findById(idTemplate).get();
	    List<OrdreMatiere> oms = t.getOrdreMatieres();
	    List<Planification> ps = new ArrayList<Planification>();
	    int njours = 0;
	    daoProjet.save(projet);
	    
	 
	    for (OrdreMatiere om : oms) {
	      Planification p = new Planification();
	      p.setMatiere(om.getMatiere());
	      p.setProjet(projet);
	      daoPLanification.save(p); 
	      ps.add(p);
	 
	      njours += om.getMatiere().getDuree(); 
	 
	    }
	    projet.setPlanifications(ps);
		projet.setSalle(s);
	    projet.setDuree(njours);
	    projet.setNomTemplate(t.getNom());
	    
	    
		System.out.println(projet);
		daoProjet.save(projet);

		return "redirect:../projet";
	}



	/* ==============================================
	 * EDITER
	 * ============================================== */
	 
	// EDITION
	@GetMapping("/editer/{id}")
	public String editer(@PathVariable int id, Model model) {
		Projet p1 = daoProjet.findById(id).get();
		model.addAttribute("projet", p1);
		model.addAttribute("salles", daoSalle.findAll());
		model.addAttribute("templates", daoTemplate.findAll());

		return "projet/editprojet";
	}

	@PostMapping("/editer/{id}")
	public String editerPost(@ModelAttribute("projet") Projet projet, @PathVariable int id, @RequestParam String idSal,
			@RequestParam int idTemplate, Model model) {

		// TODO : ajouter un requestParam pour le cursus

		Salle s = daoSalle.findById(idSal).get();
		Template t = daoTemplate.findById(idTemplate).get();

		projet.setId(id);
		projet.setSalle(s);
		projet.setNomTemplate(t.getNom());

		daoProjet.save(projet);

		return "redirect:../../projet";
	}

	
	/* ==============================================
	 * SUPPRIMER
	 * ============================================== */
	 
	// SUPRESSION
	@GetMapping("/supprimer")
	public String supprimer(@RequestParam("id") int idProjet) {
		List<Planification> ps = daoPLanification.findAll();
		 
	    for(Planification p : ps) {
	      if(p.getProjet() != null && p.getProjet().getId() == idProjet) {
	        daoPLanification.delete(p);
	      }
	    }
	 
	    
		daoProjet.deleteById(idProjet);

		return "redirect:../projet";
	}
	
	
	 /** ==============================================
	  * DETAILS DU PROJET
	  *  ============================================== */

	@GetMapping("/detailProjet/{id}")
	public String detail(@PathVariable("id") int id, Model model) {

		Projet detailProjet = daoProjet.findById(id).get();
		model.addAttribute("detailProjet", detailProjet);

		List<Planification> planifications = detailProjet.getPlanifications();
		model.addAttribute("projetPlanifications", planifications);

		List<Stagiaire> stagiaires = detailProjet.getStagiaires();
		model.addAttribute("projetStagiaires", stagiaires);

		return "projet/detailProjet";
	}

	/**
	 * Choisir une des templates et l'assigner à un projet selon son id Pour
	 * l'edition
	 */
	@GetMapping("/templates/choisir")
	public String choisirTemplate(@RequestParam("idTemplate") int id, Model model) {
		Template template = daoTemplate.findById(id).get();
		System.out.println("================Recuperation de la template=============================");
		System.out.println(template.getId() + " " + template.getNom());
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAALLLLLLLLLLLLLLLLLLLLLLLOOOOOOOOOOOOOOOOOOOOOOOO");
		return "redirect:../";
	}

}
