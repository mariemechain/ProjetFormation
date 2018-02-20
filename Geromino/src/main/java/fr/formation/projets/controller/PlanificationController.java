package fr.formation.projets.controller;

import java.util.List;




import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.formateur.dao.IFormateurDAO;
import fr.formation.projets.dao.IPlanificationDAO;
import fr.formation.projets.model.Planification;

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
		System.out.println("LISTE");
		System.out.println(daoPlan.count());
		for (Planification p : daoPlan.findAll()) {
			System.out.println(p.getId());
		}
		model.addAttribute("planifications", daoPlan.findAll());

		return "planification/planification";
	}

	@GetMapping("/delete")
	public String deleteFormateur(@RequestParam("id") int idPlanification) {
		// Récupérer l'id de la planif
		// Récupérer la planif
		// Supprimer le formateur associé setFormateur(null)
		// Save de la planif

		Planification planification = daoPlan.findById(idPlanification).get();

		planification.setFormateur(null);
		System.out.println(planification.getId() + " " + planification.getFormateur());


		daoPlan.save(planification);
		return "redirect:../planification";
	}

}
