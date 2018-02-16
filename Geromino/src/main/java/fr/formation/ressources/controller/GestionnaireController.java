package fr.formation.ressources.controller;

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
		model.addAttribute("salles", daoSalle.findAll());
		return "gestionnaireAjouterSalle";
	}
	
	@PostMapping("/gestionnaireAjouterSalle")
	public String ajouter(@ModelAttribute("salles") Salle salle, Model model) {
//		if(result.hasErrors()) {
//			model.addAttribute("fournisseurs", daoFournisseur.findAll());
//			return "edition";
//		}
		daoSalle.save(salle);	
		return "redirect:./gestionnaireSalle";
	}
	
	//************************************************** Editer une salle***************************
	@GetMapping("/gestionnaireEditerSalle")
	public String editer( @RequestParam("id") int id, Model model) {
		model.addAttribute("salles", daoSalle.findById(id).get());
		return "gestionnaireAjouterSalle";
	}
	
	@PostMapping("/gestionnaireEditerSalle")
	public String editer( @ModelAttribute("produit") Salle salle,  @RequestParam("id") int id, Model model) {
//		if(result.hasErrors()) {
//			System.out.println(result.getAllErrors());
//			model.addAttribute("fournisseurs", daoFournisseur.findAll());
//			return "gestionnaireAjouterSalle";
//		}
		daoSalle.save(salle);		
		return "redirect:./gestionnaireSalle";	}	
}
