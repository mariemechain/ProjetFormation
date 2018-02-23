package fr.formation.ressources.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.dao.IFormateurDAO;
import fr.formation.ressources.dao.IPlanificationDAO;
import fr.formation.ressources.metier.Formateur;
import fr.formation.ressources.metier.Planification;

@Controller
@RequestMapping("/planification/selectFormateur")
public class SelectFormateurController {

	@Autowired
	private IFormateurDAO daoForm;
	@Autowired
	IPlanificationDAO daoPlan;

	@GetMapping("")
	public String getPlannification(HttpServletRequest req, @RequestParam("id") int idPlanification, Model model) {

		model.addAttribute("formateurs", daoForm.findAll());

		return "planification/selectFormateur";
	}

	@PostMapping("")
	public String addFormateur(HttpServletRequest req, @RequestParam("id") int idPlanification,
			@RequestParam("selectForm") int idFormateur) {
		Formateur formateur = daoForm.findById(idFormateur).get();
		Planification planification = daoPlan.findById(idPlanification).get();

		planification.setFormateur(formateur);

		
		System.out.println("VERIFION SIIIIIIIII CA MARCHEEEE £££££££££££££££££");
		
		daoPlan.save(planification);
		System.out.println(formateur.getNom() + " " + formateur.getId());
		System.out.println(planification.getFormateur());
		return "redirect:./planification";
	}

}
