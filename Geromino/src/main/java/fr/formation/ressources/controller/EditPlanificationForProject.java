package fr.formation.ressources.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.SynthesizedAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

<<<<<<< HEAD:Geromino/src/main/java/fr/formation/ressources/controller/EditPlanificationForProject.java
import fr.formation.ressources.dao.IFormateurDAO;
import fr.formation.ressources.dao.IPlanificationDAO;
import fr.formation.ressources.dao.IProjetDAO;
import fr.formation.ressources.metier.Planification;
import fr.formation.ressources.metier.Projet;
=======
import fr.formation.formateur.dao.IFormateurDAO;
import fr.formation.matieres.dao.IMatiereDAO;
import fr.formation.matieres.model.Matiere;
import fr.formation.projets.dao.IPlanificationDAO;
import fr.formation.projets.dao.IProjetDAO;
import fr.formation.projets.model.Planification;
import fr.formation.projets.model.Projet;
>>>>>>> Module_projets:Geromino/src/main/java/fr/formation/projets/controller/EditPlanificationForProject.java

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
	
<<<<<<< HEAD:Geromino/src/main/java/fr/formation/ressources/controller/EditPlanificationForProject.java
	@ModelAttribute("page")
    public String page() {
        return "home";
    }

	@GetMapping("")
	public String getMatieres(@PathVariable int idProjet, HttpServletRequest req, Model model) {
		Projet projet = daoPro.findById(idProjet);
=======
	@Autowired
	private IMatiereDAO daoMat;

	@GetMapping("")
	public String getMatieres(@PathVariable  int idProjet, HttpServletRequest req, Model model) {
		Projet projet = daoPro.findById(idProjet).get();
>>>>>>> Module_projets:Geromino/src/main/java/fr/formation/projets/controller/EditPlanificationForProject.java
		
		for (Planification p : projet.getPlanifications()) {
			System.out.println(p.getId());
		}
		model.addAttribute("planifications", projet.getPlanifications());

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
	
	@GetMapping("/deleteMatiere")
	public String deleteMatiere(@RequestParam("id") int idPlanification) {
		
		Planification planification = daoPlan.findById(idPlanification).get();
		
		daoPlan.delete(planification);
		
		return "redirect:../planification";
	}
	
	@GetMapping("/addMat")
	public String AddMatiereForPlanification(Model model ){
		List<Matiere> matieres2 = daoMat.findAll();
		
		for(Matiere mat : matieres2){
			System.out.println(mat.getTitre());
		}
		model.addAttribute("matieres2",matieres2);
		return  "matiere/addMatiereForPlanification";
	}
	
	@GetMapping("/choixMat")
	public String ChoiceMatToAdd(@RequestParam("idm") int idMatiere,@PathVariable int idProjet, Model model){
		
		
		Matiere matiere = daoMat.findById(idMatiere);
		Planification planification = new Planification();
		Projet projet = daoPro.findById(idProjet).get(); 
		planification.setProjet(projet);
		planification.setMatiere(matiere);
		
		daoPlan.save(planification);
		
		
		System.out.println("AAAAAAAAAAAAAALLLLLLLLLLLOOOOOOOOOOOOOOOOOOOOOOOOOOOO AAAAAAAKHHHHHHHHHHHHHHHHHHHH");
		System.out.println(planification.getId() + " matiere " + planification.getMatiere());
		
		return "redirect:../planification";
	}

}