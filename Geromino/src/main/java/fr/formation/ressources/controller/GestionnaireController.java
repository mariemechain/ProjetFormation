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
import fr.formation.ressources.dao.ISalleDAO;
import fr.formation.ressources.dao.IVideoProjecteurDAO;
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

	@GetMapping("")
	public String gestionnaire() {
		return "gestionnaire";
	}
	
	@GetMapping("/gestionnaireSalle")
	public String listeSalle(Model model) {
		model.addAttribute("salles", daoSalle.findAll());
		return "gestionnaireSalle";
	}
	
	//************************************************** Ajouter une salle***************************
	@GetMapping("/gestionnaireAjouterSalle")
	public String ajouterSalle(Model model) {
		model.addAttribute("salles", new Salle());
		model.addAttribute("contacts", daoContact.findAll());
		model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
		return "gestionnaireAjouterSalle";
	}
	
	@PostMapping("/gestionnaireAjouterSalle")
	public String ajouter(@ModelAttribute("salles") Salle salle, Model model, @RequestParam(value="idContact") int idContact, @RequestParam(value="idVideoProjecteur") int idVideoProjecteur) {
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
		model.addAttribute("salles", daoSalle.findById(id).get());
		model.addAttribute("contacts", daoContact.findAll());
		model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
		return "gestionnaireAjouterSalle";
	}
	
	@PostMapping("/gestionnaireEditerSalle")
	public String editerSalle( @ModelAttribute("salles") Salle salle,  @RequestParam("id") String id, Model model) {
//		if(result.hasErrors()) {
//			System.out.println(result.getAllErrors());
//			model.addAttribute("fournisseurs", daoFournisseur.findAll());
//			return "gestionnaireAjouterSalle";
//		}
		daoSalle.save(salle);		
		//return "gestionnaireSalle";
		return "redirect:./gestionnaireSalle";	
	}
	
	
	//************************************************** Supprimer une salle***************************	
	
	@GetMapping("/gestionnaireSupprimerSalle")
	public String supprimer(@RequestParam("id") String id) {
		daoSalle.deleteById(id);	
		return "redirect:./gestionnaireSalle";
	}
}
