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

import fr.formation.ressources.dao.IOrdinateurDAO;
import fr.formation.ressources.dao.ITechnicienDAO;
import fr.formation.ressources.dao.IVideoProjecteurDAO;
import fr.formation.ressources.metier.Ordinateur;

@Controller
@RequestMapping("/technicien")
public class TechnicienController {

	@Autowired
	private ITechnicienDAO techDAO;
	@Autowired
	private IOrdinateurDAO ordiDAO;
	@Autowired
	private IVideoProjecteurDAO videoDAO;
	
	@GetMapping("")
	public String tech(Model model) {
		
		return "technicien";
	}
	
	@GetMapping("/ordi")
	public String listeOrdi(Model model) {
		model.addAttribute("ordinateurs", ordiDAO.findAll());
		return "techOrdi";
	}
	
	@GetMapping("/video")
	public String listeVideo(Model model) {
		model.addAttribute("ordinateurs", ordiDAO.findAll());
		return "techVideo";
	}
	
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
		return "/ordi";
	}
	
	
}
