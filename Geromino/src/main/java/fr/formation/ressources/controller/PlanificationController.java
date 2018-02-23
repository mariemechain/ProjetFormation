package fr.formation.ressources.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.dao.IFormateurDAO;
import fr.formation.ressources.dao.IPlanificationDAO;
import fr.formation.ressources.metier.Planification;

@Controller
@RequestMapping("/planification")
public class PlanificationController {

	// @Autowired
	// private IMatiereDAO daoMat;
	@Autowired
	private IFormateurDAO daoFor;

	@Autowired
	private IPlanificationDAO daoPlan;

	@GetMapping("")
	public String getMatieres(HttpServletRequest req, Model model) {
		
		for (Planification p : daoPlan.findAll()) {
			System.out.println(p.getId());
		}
		model.addAttribute("planifications", daoPlan.findAll());

		return "planification/planification";
	}

	/**
	 * R�cup�rer l'id de la planif 
	 * R�cup�rer la planif 
	 * Supprimer le formateur
	 * associ� setFormateur(null) 
	 * Save de la planif
	 */
	@GetMapping("/delete")
	public String deleteFormateur(@RequestParam("id") int idPlanification) {
		
		Planification planification = daoPlan.findById(idPlanification).get();
		planification.setFormateur(null);
		daoPlan.save(planification);
		
		return "redirect:../planification";
	}

}
