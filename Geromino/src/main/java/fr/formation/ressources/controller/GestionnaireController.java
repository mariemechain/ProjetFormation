package fr.formation.ressources.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import fr.formation.ressources.metier.Contact;
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
	public String ajouter(@Valid @ModelAttribute("salle") Salle salle,BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("contacts", daoContact.findAll());
			model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
			return "gestionnaireAjouterSalle";		
		}

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
	public String editerSalle(@Valid @ModelAttribute("salle") Salle salle, BindingResult result,  @RequestParam("id") String id, Model model) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("contacts", daoContact.findAll());
			model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
			return "gestionnaireAjouterSalle";
		}

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
		
		//***********************************************************************************************
		//****************************CONTACT*************************************************************
		//***********************************************************************************************
		
		@GetMapping("/gestionnaireContact")
		public String listeContact(Model model) {
			model.addAttribute("contacts", daoContact.findAll());
			return "gestionnaireContact";
		}
		
		//************************************************** Ajouter un contact***************************
				@GetMapping("/gestionnaireAjouterContact")
				public String ajouterContact(Model model) {
					model.addAttribute("contact", new Contact());
					model.addAttribute("contacts", daoContact.findAll());
					
					return "gestionnaireAjouterContact";
				}

				@PostMapping("/gestionnaireAjouterContact")
				public String ajouterContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {
					if(result.hasErrors()) {
						model.addAttribute("contacts", daoContact.findAll());
						return "gestionnaireAjouterContact";	
					}
//					model.addAttribute("contacts", daoContact.findAll());		
					daoContact.save(contact);	
					return "redirect:./gestionnaireContact";
				}
				
				//************************************************** Editer un contact***************************
				@GetMapping("/gestionnaireEditerContact")
				public String editerContact( @RequestParam("id") int id, Model model) {
					model.addAttribute("contact", daoContact.findById(id).get());
					System.out.println(id);
					
					
					return "gestionnaireAjouterContact";
				}
				
				@PostMapping("/gestionnaireEditerContact")
				public String editerContact(@Valid @ModelAttribute("contact") Contact contact,  @RequestParam("id") int id, BindingResult result, Model model) {
					if(result.hasErrors()) {
						model.addAttribute("contact", daoContact.findById(id).get());
						return "gestionnaireAjouterContact";
					}
					model.addAttribute("contacts", daoContact.findAll());
					
					contact.setId(id);
					daoContact.save(contact);		
					//return "gestionnaireSalle";
					return "redirect:./gestionnaireContact";	
				}
				
				
				
				//************************************************** Supprimer un contact***************************	
				
				@GetMapping("/gestionnaireSupprimerContact")
				public String supprimerContact(@RequestParam("id") int id) {
					daoContact.deleteById(id);	
					return "redirect:./gestionnaireContact";
				}
}
