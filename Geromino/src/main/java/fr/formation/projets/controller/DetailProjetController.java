package fr.formation.projets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.projets.dao.IProjetDAO;
import fr.formation.projets.model.Planification;
import fr.formation.projets.model.Projet;
import fr.formation.ressources.metier.Stagiaire;

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
