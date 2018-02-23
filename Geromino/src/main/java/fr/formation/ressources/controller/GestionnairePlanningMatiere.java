package fr.formation.ressources.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.matieres.dao.IMatiereDAO;
import fr.formation.matieres.model.Matiere;
import fr.formation.ressources.dao.IFormateurDAO;
import fr.formation.ressources.dao.IPlanificationDAO;
import fr.formation.ressources.metier.Planification;

@Controller
@RequestMapping("/gestionnaire/gestionnaireProjetStagiaires/{idProjet}/planification/idPlanif{idPlanif}/idMatiere{idMatiere}")
public class GestionnairePlanningMatiere {

	// ====================================INJECTION=====================================================
	@Autowired(required = false)
	IFormateurDAO daoFormateur;

	@Autowired
	IMatiereDAO daoMatiere;
	
	@Autowired
	IPlanificationDAO daoPlan;
	
	@ModelAttribute("page")
    public String page() {
        return "home";
    }
	// ====================================INITIALISATION=====================================================



	@ModelAttribute("listeMatiere")
	public List<Matiere> initMatiere() {
		List<Matiere> listeMatiere = new ArrayList<Matiere>();
		return listeMatiere;
	}

	// ====================================LISTE
	// FORMATEURS=====================================================
	@GetMapping(value = { "" })
	public String getListeMatiere(@PathVariable int idMatiere, @PathVariable int idProjet, @PathVariable int idPlanif,
			Model model) {
		// recuperer la matiere en fonctiond de son id
		Matiere matiere = daoMatiere.findById(idMatiere);
		model.addAttribute("matiere", matiere);
		model.addAttribute("idProjet", idProjet);

		List<Matiere> matieres = daoMatiere.findAll();
		model.addAttribute("matieres", matieres);

		return "matiere/choixMatiereforPlanification";
	}


	// ====================================SUPPRESSION De la matiere dans la planification à finir=====================================================
	@GetMapping(value = { "/supprimer" })
	public String getSuppMatiere(@RequestParam("idm") int idMatiere, Model model) {

		Planification planification = new Planification();
		Matiere matiere = new Matiere();
		matiere = daoMatiere.findById(idMatiere);
		daoMatiere.delete(matiere);
		return "redirect:../formateurs";
	}

	// ====================================AJOUT=====================================================


	// ====================================MODIFIER=====================================================

	@GetMapping(value = { "/modif" })
<<<<<<< HEAD:Geromino/src/main/java/fr/formation/ressources/controller/GestionnairePlanningMatiere.java
	public String getModifierFormateur(@RequestParam("idm") int idMatiere,@PathVariable int idPlanif, Model model) {
=======
	public String getModifierMAtiere(@RequestParam("idm") int idMatiere,@PathVariable int idPlanif) {
>>>>>>> Module_projets:Geromino/src/main/java/fr/formation/formateur/controller/GestionnairePlanningMatiere.java

		Planification planif = daoPlan.findById(idPlanif).get();
		Matiere matiere = daoMatiere.findById(idMatiere);
		planif.setMatiere(matiere);
		model.addAttribute(idPlanif);
		
		daoPlan.save(planif);
		System.out.println("===========================================Formateur=========================");
		System.out.println(matiere.getTitre());

		return "redirect:../../../planification";
	}

}
