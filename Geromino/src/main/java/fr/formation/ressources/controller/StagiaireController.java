package fr.formation.ressources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.ressources.dao.IStagiaireDAO;

@Controller
@RequestMapping("/stagiaire")
public class StagiaireController {

	@Autowired
	private IStagiaireDAO daoStagiaire;
	
	@GetMapping(value = {"/liste"})
	public String liste(Model model) {
		model.addAttribute("stagiaires", daoStagiaire.findAll());
		return "liste";
	}
	
}