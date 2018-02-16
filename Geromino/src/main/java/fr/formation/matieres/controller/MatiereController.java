package fr.formation.matieres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.matieres.dao.IMatiereDAO;
import fr.formation.matieres.model.Matiere;

@Controller
@RequestMapping(value = "/matiere")
public class MatiereController {

	@Autowired
	private IMatiereDAO daoMatiere;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("matieres", daoMatiere.findAll());
		return "matiere";
	}

	@GetMapping("/ajouter")
	public String ajouter(Model model) {
		model.addAttribute("matiere", new Matiere());

		return "ajouterMatiere";
	}

	@PostMapping("/ajouter")
	public String ajouter(@ModelAttribute("matiere") Matiere matiere, Model model) {
		daoMatiere.save(matiere);
		return "redirect:./";
	}

	@GetMapping("/editer")
	public String editer(Model model, @RequestParam("id") int id) {
		model.addAttribute("matiere", daoMatiere.findById(id));
		return "ajouterMatiere";
	}

	@PostMapping("/editer")
	public String editer(@ModelAttribute("matiere") Matiere matiere, Model model) {

		daoMatiere.save(matiere);
		return "redirect:./";
	}

	@GetMapping("/supprimer")
	public String supprimer(@RequestParam("id") int id) {
		daoMatiere.deleteById(id);
		return "redirect:./";
	}
	
	@GetMapping("/information")
	public String information(@RequestParam("id") int id, Model model) {
		model.addAttribute("detailMatiere", daoMatiere.findById(id));
		model.addAttribute("matieres", daoMatiere.findAll());
		return "matiere";
	}

}
