package fr.formation.projets.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.projets.dao.ITemplateDAO;
import fr.formation.projets.model.Template;

@Controller
@RequestMapping("/templates")
public class TemplateController {
	
	@Autowired
	private ITemplateDAO daoTemplate;
	
	@GetMapping("")
	public String AfficherListe(Model model) {
		model.addAttribute("Templates",daoTemplate.findAll());
		System.out.println("toto");
		
		return "templates/liste";
	}
	
	@GetMapping("/visualiser/{id}")
	public String visualiser(@PathVariable(value="id", required=true) int myId, Model model) {
		Template myTemplate = daoTemplate.findById(myId).get();
		model.addAttribute("Template", myTemplate);
		model.addAttribute("Matieres", myTemplate.getMatieres());
		
		return "templates/visualiser";
	}
	
	@GetMapping("/ajouter")
	public String ajouter(Model model) {
		
		return "templates/ajouter";
	}
	
	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable(value="id", required=true) int myId, Model model) {
		
		Template myTemplate = daoTemplate.findById(myId).get();
		daoTemplate.delete(myTemplate);
		
		return "redirect:/templates";
	}
	
	@PostMapping("/ajouter")
	public String ajoutPost(@Valid @ModelAttribute("template") Template myTemplate,  BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "templates/ajouter";
		}
		
		daoTemplate.save(myTemplate);
		
		return "redirect:/templates";
	}

}
