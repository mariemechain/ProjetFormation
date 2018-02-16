package fr.formation.ressources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.ressources.dao.IOrdinateurDAO;
import fr.formation.ressources.dao.ITechnicienDAO;
import fr.formation.ressources.dao.IVideoProjecteurDAO;

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
	public String liste(Model model) {
		model.addAttribute("ordinateurs", ordiDAO.findAll());
		return "technicien";
	}
	
}
