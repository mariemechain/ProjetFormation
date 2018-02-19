package fr.formation.ressources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.dao.IGestionnaireDAO;
import fr.formation.ressources.dao.IPersonneDAO;
import fr.formation.ressources.dao.ITechnicienDAO;
import fr.formation.ressources.metier.Gestionnaire;
import fr.formation.ressources.metier.Personne;
import fr.formation.ressources.metier.Technicien;

@Controller
public class AdminController {
	
	
	@Autowired
	private IPersonneDAO daoPersonne;
	@Autowired
	private IGestionnaireDAO daoGestionnaire;
	@Autowired
	private ITechnicienDAO daoTechnicien;
	
//	@GetMapping("/adminPersonnel")
//	public String listeContact(Model model) {
//		model.addAttribute("contacts", daoContact.findAll());
//		return "Personnels";
//	}
	
	@GetMapping("/adminAjouterPersonnel")
	public String ajouterContact(Model model) {
		model.addAttribute("personnel", new Personne());
		model.addAttribute("personnels", daoPersonne.findAll());
		
		return "ajouterPersonnel";
	}
	
	@PostMapping("/adminAjouterPersonnel")
	public String ajouterContact2(@ModelAttribute("personnel") Personne personne, @RequestParam("personnels") String type,Model model) {
		if(type.equals("Gestionnaire")){
			Gestionnaire gestionnaire = (Gestionnaire)personne;
			daoGestionnaire.save(gestionnaire);
		}
		if(type.equals("Technicien")){
			Technicien technicien = (Technicien)personne;
			daoTechnicien.save(technicien);
		}
		
		
		return "ajouterPersonnel";
	}
	
}
