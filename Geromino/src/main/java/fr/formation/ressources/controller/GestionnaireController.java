package fr.formation.ressources.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.dao.IContactDAO;
import fr.formation.ressources.dao.IGestionnaireDAO;
import fr.formation.ressources.dao.IProjetDAO;
import fr.formation.ressources.dao.ISalleDAO;
import fr.formation.ressources.dao.IStagiaireDAO;
import fr.formation.ressources.dao.IVideoProjecteurDAO;
import fr.formation.ressources.metier.Projet;
import fr.formation.ressources.metier.Salle;

@Controller
@RequestMapping("/gestionnaire")
public class GestionnaireController {
	
	@ModelAttribute("page")
    public String page() {
        return "gestionnaire";
    }
	
	
	@Autowired
	private ISalleDAO daoSalle;
	
	@Autowired
	private IContactDAO daoContact;
	
	@Autowired
	private IVideoProjecteurDAO daoVideoProjecteur;
	
	@Autowired
	private IProjetDAO daoProjet;
	
	@Autowired
	private IStagiaireDAO daoStagiaire;
	
	@Autowired
	private IGestionnaireDAO daoGestionnaire;

	@GetMapping("")
	public String gestionnaire() {
		return "gestionnaire";
	}
	
	
	//***********************************************************************************************
	//****************************SALLE**************************************************************
	//***********************************************************************************************
	
	@GetMapping("/gestionnaireSalle")
	public String listeSalle(Model model) {
		model.addAttribute("salle", daoSalle.findAll());
		return "gestionnaireSalle";
	}
	
	//************************************************** Ajouter une salle***************************
	@GetMapping("/gestionnaireAjouterSalle")
	public String ajouterSalle(Model model) {
		model.addAttribute("salle", new Salle());
		model.addAttribute("contacts", daoContact.findAll());
		model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
		return "gestionnaireAjouterSalle";
	}

	@PostMapping("/gestionnaireAjouterSalle")
	public String ajouter(@ModelAttribute("salle") Salle salle, Model model) {
//		if(result.hasErrors()) {
//			model.addAttribute("fournisseurs", daoFournisseur.findAll());
//		
//		}
		model.addAttribute("contacts", daoContact.findAll());
		model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
		daoSalle.save(salle);	
		return "redirect:./gestionnaireSalle";
	}
	
	//************************************************** Editer une salle***************************
	@GetMapping("/gestionnaireEditerSalle")
	public String editerSalle( @RequestParam("id") String id, Model model) {
		model.addAttribute("salle", daoSalle.findById(id).get());
		model.addAttribute("contacts", daoContact.findAll());
		model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
		return "gestionnaireAjouterSalle";
	}
	
	@PostMapping("/gestionnaireEditerSalle")
	public String editerSalle( @ModelAttribute("salle") Salle salle,  @RequestParam("id") String id, Model model) {
//		if(result.hasErrors()) {
//			System.out.println(result.getAllErrors());
//			model.addAttribute("fournisseurs", daoFournisseur.findAll());
//			return "gestionnaireAjouterSalle";
//		}
//		model.addAttribute("contacts", daoContact.findAll());
//		model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
		daoSalle.save(salle);		
		//return "gestionnaireSalle";
		return "redirect:./gestionnaireSalle";	
	}
	
	
	//************************************************** Supprimer une salle***************************	
	
	@GetMapping("/gestionnaireSupprimerSalle")
	public String supprimerSalle(@RequestParam("id") String id) {
		daoSalle.deleteById(id);	
		return "redirect:./gestionnaireSalle";
	}
	
	
	
	//***********************************************************************************************
	//****************************PROJET*************************************************************
	//***********************************************************************************************
	
	@GetMapping("/gestionnaireProjet")
	public String listeProjet(Model model) {
		model.addAttribute("projet", daoProjet.findAll());
		return "gestionnaireProjet";
	}
	
	//************************************************** Ajouter un projet***************************
		@GetMapping("/gestionnaireAjouterProjet")
		public String ajouterProjet(Model model) {
			model.addAttribute("projet", new Projet());
			model.addAttribute("stagiaires", daoStagiaire.findAll());
			model.addAttribute("gestionnaires", daoGestionnaire.findAll());
			return "gestionnaireAjouterProjet";
		}

		@PostMapping("/gestionnaireAjouterProjet")
		public String ajouter(@ModelAttribute("projet") Projet projet, Model model) {
//			if(result.hasErrors()) {
//				model.addAttribute("fournisseurs", daoFournisseur.findAll());
//			
//			}
			model.addAttribute("stagiaires", daoStagiaire.findAll());
			model.addAttribute("gestionnaires", daoGestionnaire.findAll());
			daoProjet.save(projet);	
			return "redirect:./gestionnaireProjet";
		}
		
		//************************************************** Editer un projet***************************
		@GetMapping("/gestionnaireEditerProjet")
		public String editerProjet( @RequestParam("id") int id, Model model) {
			model.addAttribute("projet", new Projet());
			model.addAttribute("stagiaires", daoStagiaire.findAll());
			model.addAttribute("gestionnaires", daoGestionnaire.findAll());
			return "gestionnaireAjouterProjet";
		}
		
		@PostMapping("/gestionnaireEditerProjet")
		public String editerProjet( @ModelAttribute("projet") Projet projet,  @RequestParam("id") int id, Model model) {
//			if(result.hasErrors()) {
//				System.out.println(result.getAllErrors());
//				model.addAttribute("fournisseurs", daoFournisseur.findAll());
//				return "gestionnaireAjouterSalle";
//			}
//			model.addAttribute("contacts", daoContact.findAll());
//			model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
			daoProjet.save(projet);		
			//return "gestionnaireSalle";
			return "redirect:./gestionnaireProjet";	
		}
		
		
		//************************************************** Supprimer un projet***************************	
		
		@GetMapping("/gestionnaireSupprimerProjet")
		public String supprimerProjet(@RequestParam("id") int id) {
			daoProjet.deleteById(id);	
			return "redirect:./gestionnaireProjet";
		}
}
