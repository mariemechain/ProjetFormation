package fr.formation.projets.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.formateur.dao.IFormateurDAO;
import fr.formation.matieres.dao.IMatiereDAO;
import fr.formation.projets.dao.IProjetDAO;
import fr.formation.projets.dao.ISalleDAO;
//import fr.formation.projets.dao.IStagiaireDAO;
import fr.formation.projets.dao.ITemplateDAO;
import fr.formation.projets.model.Projet;

@Controller
@RequestMapping("/projet")
public class ProjetController {

	@Autowired
	private IProjetDAO daoProjet;

	@Autowired
	private ISalleDAO daoSalle;

	@Autowired
	private ITemplateDAO daoTemplate;

	@Autowired
	private IFormateurDAO daoFormateur;

	@Autowired
	private IMatiereDAO daoMatiere;

	/**
	 * Recupere la liste des projets
	 */
	@GetMapping("")
	public String liste(Model model) {
		model.addAttribute("Projet", daoProjet.findAll());
		return "projet/listeprojet";
	}

	// Ajout de projet en choissisant les mati�res et formateurs
	@GetMapping("/ajouter")
	public String ajouter(Model model) {
		model.addAttribute("projet", new Projet());
		return "projet/addprojet";
	}

	@PostMapping("/ajouter")
	public String ajouter(@ModelAttribute("projet") Projet projet, Model model) {

		daoProjet.save(projet);
		return "redirect:../projet";
	}

	/**
	 * // EDITION @GetMapping("/editer/{id}") public String editer(@PathVariable
	 * int id, Model model) { model.addAttribute("projet",
	 * daoProjet.findById(id).get()); return "projet/editprojet"; }
	 * 
	 * @PostMapping("/editer/{id}") public String
	 * editer(@ModelAttribute("projet") Projet projet, @PathVariable int id,
	 * Model model) { { daoProjet.save(projet); return "redirect:../../projet";
	 * } }
	 * 
	 */
	// EDITION
	@GetMapping("/editer")
	public String editer(@RequestParam("id") int id, Model model) {
		model.addAttribute("projet", daoProjet.findById(id).get());
		return "projet/editprojet";
	}

	@PostMapping("/editer")
	public String editer(@RequestParam("id") int id,@ModelAttribute("projet") Projet projet,  Model model) {
		{
			daoProjet.save(projet);
			return "redirect:../projet";
		}
	}

	// SUPRESSION
	@GetMapping("/supprimer")
	public String supprimer(@RequestParam("id") int idProjet) {
		daoProjet.deleteById(idProjet);
		return "redirect:../projet";
	}

}
