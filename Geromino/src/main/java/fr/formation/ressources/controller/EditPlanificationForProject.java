package fr.formation.ressources.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.dao.IFormateurDAO;
import fr.formation.ressources.dao.IPlanificationDAO;
import fr.formation.ressources.dao.IProjetDAO;
import fr.formation.ressources.metier.Planification;
import fr.formation.ressources.metier.Projet;

@Controller
@RequestMapping("/gestionnaire/gestionnaireProjetStagiaires/{idProjet}/planification")
public class EditPlanificationForProject {
	
	// @Autowired
	// private IMatiereDAO daoMat;
	@Autowired
	private IFormateurDAO daoFor;

	@Autowired
	private IPlanificationDAO daoPlan;
	
	@Autowired
	private IProjetDAO daoPro;
	
	@ModelAttribute("page")
    public String page() {
        return "home";
    }

	@GetMapping("")
	public String getMatieres(@PathVariable int idProjet, HttpServletRequest req, Model model) {
		Projet projet = daoPro.findById(idProjet);
		
		for (Planification p : projet.getPlanifications()) {
			System.out.println(p.getId());
		}
		model.addAttribute("planifications", projet.getPlanifications());

		return "planification/planification";
	}

	/**
	 * Récupérer l'id de la planif 
	 * Récupérer la planif 
	 * Supprimer le formateur
	 * associé setFormateur(null) 
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