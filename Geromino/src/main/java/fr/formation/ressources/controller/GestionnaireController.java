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

import fr.formation.ressources.dao.ISalleDAO;
import fr.formation.ressources.metier.Salle;

@Controller
@RequestMapping("/gestionnaire")
public class GestionnaireController {
	
	@ModelAttribute("page")
    public String page() {
        return "home";
    }
	
	
	@Autowired
	private ISalleDAO daoSalle;

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
		return "gestionnaireAjouterSalle";
	}
	
	@PostMapping("/gestionnaireAjouterSalle")
	public String ajouter(@ModelAttribute("salles") Salle salle) {
//		if(result.hasErrors()) {
//			model.addAttribute("fournisseurs", daoFournisseur.findAll());
//		
//		}
		daoSalle.save(salle);	
		return "redirect:./gestionnaireSalle";
	}
	
	//************************************************** Editer une salle***************************
	@GetMapping("/gestionnaireEditerSalle")
	public String editerSalle( @RequestParam("id") String id, Model model) {
		model.addAttribute("salles", daoSalle.findById(id).get());
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
