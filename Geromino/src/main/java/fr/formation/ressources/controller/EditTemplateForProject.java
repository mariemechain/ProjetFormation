package fr.formation.ressources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.ressources.dao.ITemplateDAO;

@Controller
@RequestMapping("/projet/detailProjet/{idProjet}/templates")
public class EditTemplateForProject {

	@Autowired
	private ITemplateDAO daoTemplate;

	@GetMapping("")
	public String choixTemplateForEdition(@PathVariable int idProjet, Model model) {

		model.addAttribute("Templates", daoTemplate.findAll());
		return "templates/liste";
	}

	
}
