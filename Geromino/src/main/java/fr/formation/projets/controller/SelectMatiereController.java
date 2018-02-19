package fr.formation.projets.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.projets.dao.IMatiereDAO;
import fr.formation.ressources.model.Matiere;

@Controller
@RequestMapping("/selectMatiere")
public class SelectMatiereController {

	@Autowired
	private IMatiereDAO daoMAt;

	@GetMapping("")
	public String getPlannification(HttpServletRequest req, Model model) {

		// J'envoie ma liste de matieres pour la recupérer en jsp
		model.addAttribute("matieres", daoMAt.findAll());

		return "planification/selectMatiere";
	}

	@PostMapping("")
	public String selectMatiere(@RequestParam("selectMat") String nom) {
		Matiere matiere = new Matiere();
		matiere.setNom(nom);
		System.out.println(matiere.getNom() + " " + matiere.getId());
		return "redirect:./selectMatiere";
	}
}
