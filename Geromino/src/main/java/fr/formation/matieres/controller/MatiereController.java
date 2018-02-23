package fr.formation.matieres.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.dao.IMatiereDAO;
import fr.formation.ressources.metier.Matiere;

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

		
		model.addAttribute("matieres", daoMatiere.findAll());
		model.addAttribute("matiere", new Matiere());
		return "ajouterMatiere";
	}

	@PostMapping("/ajouter")
	public String ajouter(@Valid@ModelAttribute("matiere") Matiere matiere, BindingResult result, Model model, HttpServletRequest req) {
		
		if (result.hasErrors()) {
			model.addAttribute("matieres", daoMatiere.findAll());

			return "matiere";
		}
		
		List<Matiere> liste = daoMatiere.findAll();
		List<Matiere> prerequis = new ArrayList<Matiere>();
		
		for (Matiere m : liste) {
			if(req.getParameter("test_"+m.getId()) != null)
				prerequis.add(m);
		}
		
		matiere.setPrerequis(prerequis);
		
		daoMatiere.save(matiere);
		return "redirect:./";
	}

	@GetMapping("/editer")
	public String editer(Model model, @RequestParam("id") int id) {
		model.addAttribute("matieres", daoMatiere.findAll());
		model.addAttribute("matiere", daoMatiere.findById(id));
		return "ajouterMatiere";
	}

	@PostMapping("/editer")
	public String editer(@Valid@ModelAttribute("matiere") Matiere matiere, BindingResult result, Model model, @RequestParam("id") int id, HttpServletRequest req) {
		if (result.hasErrors()) {
			model.addAttribute("matieres", daoMatiere.findAll());

			return "ajouterMatiere";
		}
		
		List<Matiere> liste = daoMatiere.findAll();
		List<Matiere> prerequis = new ArrayList<Matiere>();
		
		for (Matiere m : liste) {
			if(req.getParameter("test_"+m.getId()) != null)
				prerequis.add(m);
		}
		
		matiere.setPrerequis(prerequis);
		
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
		
		Matiere detailMatiere = daoMatiere.findById(id);
		List prerequis = new ArrayList();
		for(Matiere m : detailMatiere.getPrerequis()) {
				prerequis.add(m.getTitre());
		}
		model.addAttribute("Prerequis", prerequis);
		model.addAttribute("detailMatiere", detailMatiere);
		model.addAttribute("matieres", daoMatiere.findAll());
		return "matiere";
	}

}
