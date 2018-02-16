package fr.formation.matieres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public List<Matiere> findAll() {
		return this.daoMatiere.findAll();
	}

	@GetMapping("/ajouter")
	public String ajouter(Model model) {
		model.addAttribute("matiere", new Matiere());

		return "ajoutmatiere";
	}

	@PostMapping("/ajouter")
	public String ajouter(@ModelAttribute("matiere") Matiere matiere, BindingResult result, Model model) {
		if (result.hasErrors()) {

			return "ajoutmatiere";
		}
		daoMatiere.save(matiere);
		return "redirect:./";
	}
	
	@GetMapping("/editer")
	public String editer(Model model, @RequestParam("titre") String titre) {
		model.addAttribute("matiere", daoMatiere.findByTitre(titre));
		
		return "ajoutproduit";
	}
	
	@GetMapping("/supprimerproduit")
	public String supprimer(@RequestParam("titre") String titre) {
		daoMatiere.deleteByTitre(titre);
		return "redirect:./";
	}

}