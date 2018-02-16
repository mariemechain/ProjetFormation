package fr.formation.projets.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.ressources.model.Formateur;
import fr.formation.ressources.model.Matiere;

@Controller
@RequestMapping("/planification")
public class PlanificationController {

	// @GetMapping("")
	// public String getPlannification(Model model) {
	//
	// model.addAttribute("message", "Allô le monde! by Mounzer");
	//
	// return "planification";
	// }

	@GetMapping("")
	public String getMatieres(HttpServletRequest req, Model model) {

//		List MAtiere
		List<Matiere> matieres = (List<Matiere>) req.getServletContext().getAttribute("myMatieresListener");
		for (Matiere matiere : matieres) {
			System.out.println(matiere);
		}
		model.addAttribute("matieres", matieres);

		
//		List formateurs
		List<Formateur> formateurs = (List<Formateur>) req.getServletContext().getAttribute("myFormateursListener");

		for (Formateur formateur : formateurs) {
			System.out.println(formateur);
		}

		model.addAttribute("formateurs", formateurs);
		return "planification/planification";
	}

}
