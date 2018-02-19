package fr.formation.projets.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.projets.dao.IFormateurDAO;
import fr.formation.ressources.model.Formateur;
import fr.formation.ressources.model.Matiere;

@Controller
@RequestMapping("/selectFormateur")
public class SelectFormateurController {

	@Autowired
	private IFormateurDAO daoForm;
	

	 @GetMapping("")
		 public String getPlannification(HttpServletRequest req, Model model) {
	
		model.addAttribute("formateurs", daoForm.findAll());
		
		 return "planification/selectFormateur";
		 }
	 
	 @PostMapping("")
		public String selectMatiere(HttpServletRequest req,@RequestParam("selectForm") int idFormateur){
			Formateur formateur = daoForm.findById(idFormateur).get();
			
			System.out.println(formateur.getNom() + " " + formateur.getId());
			
			
			
			return "redirect:./selectFormateur";
		}
}
