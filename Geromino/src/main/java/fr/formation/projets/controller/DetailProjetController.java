package fr.formation.projets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.ressources.dao.IProjetDAO;

@RequestMapping("/projet")
public class DetailProjetController {
	@Autowired private IProjetDAO daoProjet; 
	
//	@GetMapping("/detailProjet/{id}")
//	public String detail(@RequestParam("id") int id, Model model) {
//		
//		Projet detailProjet = daoProjet.findById(id).get();
//		model.addAttribute("detailProjet", detailProjet);
//		
//		List<Planification> planifications = detailProjet.getPlanifications();
//		model.addAttribute("projetPlanifications", planifications);
//		
//		List<Stagiaire> stagiaires = detailProjet.getStagiaires();
//		model.addAttribute("projetStagiaires", stagiaires);
//
//		return "redirect:./detailProjet";
//	}
	
}
