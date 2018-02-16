package fr.formation.projets.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.model.Matiere;

@Controller
@RequestMapping("/selectMatiere")
public class SelectMatiereController {

	@GetMapping("")
	public String getPlannification(HttpServletRequest req, Model model) {

		// List MAtiere recuperé à partir de mon listener
		List<Matiere> matieres = (List<Matiere>) req.getServletContext().getAttribute("myMatieresListener");

		// J'envoie ma liste de matieres pour la recupérer en jsp
		model.addAttribute("matieres", matieres);

		return "planification/selectMatiere";
	}
	
	
	@PostMapping("")
	public String selectMatiere(@RequestParam("nom") String nom){
		Matiere matiere = new Matiere();
		matiere.setNom(nom);
		System.out.println(matiere);
		return "redirect./planification/selectMatiere";
	}
}
