package fr.formation.projets.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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

import fr.formation.matieres.dao.IMatiereDAO;
import fr.formation.matieres.model.Matiere;
import fr.formation.projets.dao.ITemplateDAO;
import fr.formation.projets.model.Template;

@Controller
@RequestMapping("/templates")
public class TemplateController {
	
	@Autowired
	private ITemplateDAO daoTemplate;
	
	@Autowired
	private IMatiereDAO daoMatiere;
	
	@GetMapping("")
	public String AfficherListe(Model model) {
		model.addAttribute("Templates",daoTemplate.findAll());
		
		return "templates/liste";
	}
	
	@GetMapping("/visualiser/{id}")
	public String visualiser(@PathVariable(value="id", required=true) int myId, Model model) {
		Template myTemplate = daoTemplate.findById(myId).get();
		model.addAttribute("Template", myTemplate);
		model.addAttribute("Matieres", myTemplate.getMatieres());
		
		return "templates/visualiser";
	}
	
	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable(value="id", required=true) int myId, Model model) {
		
		Template myTemplate = daoTemplate.findById(myId).get();
		daoTemplate.delete(myTemplate);
		
		return "redirect:/templates";
	}
	
	@GetMapping("/ajouter")
	public String ajouter(Model model, HttpSession session) {
		Template myTemplate = new Template();
		List<Matiere> matieresSession = new ArrayList<Matiere>();
		session.setAttribute("matieresSession", matieresSession);
		
		List<Matiere> listeMatiere = daoMatiere.findAll();
		model.addAttribute("listeMatiere", listeMatiere);	
		
		model.addAttribute("Matieres", myTemplate.getMatieres());
		
		
		return "templates/ajouter";
	}
	
	@PostMapping("/ajouterligne")
	public String ajouterLigne(@RequestParam("matiereId") int matiereId, Model model, HttpSession session) {
		
		System.out.println("test----------------------" + matiereId);
		
		Matiere myMatiere = daoMatiere.findById(matiereId);
		
		List<Matiere> myMatieres = (List<Matiere>) session.getAttribute("matieresSession");
		myMatieres.add(myMatiere);
		
		session.setAttribute("sessionTemplate", myMatieres);
		
		List<Matiere> listeMatiere = daoMatiere.findAll();
		model.addAttribute("listeMatiere", listeMatiere);
		
		model.addAttribute("Matieres", myMatieres);
		
		return "templates/ajouter";
	}
	
	@PostMapping("/ajouter")
	public String ajouter(@Valid @ModelAttribute("template") Template myTemplate, BindingResult result, Model model, HttpSession session) {
		
		if (result.hasErrors()) {
			return "templates/ajouter";
		}
		
		List<Matiere> myMatieres = (List<Matiere>) session.getAttribute("matieresSession");
		
		myTemplate.setMatieres(myMatieres);
		
		daoTemplate.save(myTemplate);
		
		return "redirect:/templates";
	}

}
