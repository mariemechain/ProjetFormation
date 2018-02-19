package fr.formation.projets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.projets.dao.ITemplateDAO;

@Controller
@RequestMapping("/templates")
public class TemplateController {
	
	@Autowired
	private ITemplateDAO daoTemplate;
	
	@GetMapping("/liste")
	public String AfficherListe(Model model) {
		model.addAttribute("Templates",daoTemplate.findAll());
		System.out.println("toto");
		
		return "templates/liste";
	}
	
	@GetMapping("/visualiser/{id}")
	public String visualiser(@PathVariable(value="id", required=true) int myId, Model model) {
		model.addAttribute("Template",daoTemplate.findById(myId).get());
		
		return "templates/visualiser";
	}

}
