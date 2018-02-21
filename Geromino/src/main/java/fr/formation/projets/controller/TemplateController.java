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
import fr.formation.projets.dao.IOrdreMatiereDAO;
import fr.formation.projets.dao.ITemplateDAO;
import fr.formation.projets.model.OrdreMatiere;
import fr.formation.projets.model.Template;

@Controller
@RequestMapping("/templates")
public class TemplateController {
	
	@Autowired
	private ITemplateDAO daoTemplate;
	
	@Autowired
	private IOrdreMatiereDAO daoOrdreMatiere;
	
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

		
		System.out.println(myTemplate);
		
		model.addAttribute("Template", myTemplate);
		model.addAttribute("ordreMatieres", myTemplate.getOrdreMatieres());
		
		return "templates/visualiser";
	}
	
	
	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable(value="id", required=true) int myId, Model model) {
		
		Template myTemplate = daoTemplate.findById(myId).get();
		
		List<OrdreMatiere> myOrdreMatieres = daoOrdreMatiere.findByTemplateId(myId);
		
		
		daoTemplate.delete(myTemplate);
		
		return "redirect:/templates";
	}
	

	@GetMapping("/ajouter")
	public String ajouter(Model model, HttpSession session) {
		
		Template myTemplate = new Template();
		List<OrdreMatiere> ordreMatieres = new ArrayList<OrdreMatiere>();
		session.setAttribute("ordreMatieres", ordreMatieres);
		
		List<Matiere> listeMatiere = daoMatiere.findAll();
		model.addAttribute("listeMatiere", listeMatiere);	
		
		session.setAttribute("template", myTemplate);
		
		return "templates/ajouter";
	}
	

	@GetMapping("/modifier/{id}")
	public String modifier(@PathVariable(value="id", required=true) int myId, Model model, HttpSession session) {
		
		Template myTemplate = daoTemplate.findById(myId).get();
		
		System.out.println(myTemplate);
		
		List<OrdreMatiere> ordreMatieres = myTemplate.getOrdreMatieres();
		
		System.out.println("liste = " + ordreMatieres);
		
		session.setAttribute("ordreMatieres", ordreMatieres);
		
		List<Matiere> listeMatiere = daoMatiere.findAll();
		model.addAttribute("listeMatiere", listeMatiere);	
		
		int tailleMax = ordreMatieres.size();
		model.addAttribute("tailleMax", tailleMax);
		
		session.setAttribute("template", myTemplate);
		
		return "templates/ajouter";
		
	
	}


	@PostMapping("/editer/ajouterligne")
	public String ajouterLigne(@RequestParam("matiereId") int matiereId, Model model, HttpSession session) {
		
		Matiere myMatiere = daoMatiere.findById(matiereId);
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
		
		OrdreMatiere ordreMatiere = new OrdreMatiere();
		ordreMatiere.setMatiere(myMatiere);
		ordreMatiere.setOrdre(myOrdreMatieres.size());
		myOrdreMatieres.add(ordreMatiere);
		
		
		session.setAttribute("ordreMatieresSession", myOrdreMatieres);
		
		List<Matiere> listeMatiere = daoMatiere.findAll();
		model.addAttribute("listeMatiere", listeMatiere);
		
		int tailleMax = myOrdreMatieres.size();
		model.addAttribute("tailleMax", tailleMax);

		return "templates/ajouter";
	}
	

	@GetMapping("/editer/supprimer/{id}")
	public String supprimerLigne(@PathVariable(value="id", required=true) int myId, Model model, HttpSession session) {
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
		
		myOrdreMatieres.remove(myId);
		
		OrdreMatiere myOrdreMatiere = daoOrdreMatiere.findById(myId).get();
		daoOrdreMatiere.delete(myOrdreMatiere);
		
		myOrdreMatieres = refreshOrdre(myOrdreMatieres);
		
		session.setAttribute("ordreMatieres", myOrdreMatieres);
		
		List<Matiere> listeMatiere = daoMatiere.findAll();
		model.addAttribute("listeMatiere", listeMatiere);
		
		int tailleMax = myOrdreMatieres.size();
		model.addAttribute("tailleMax", tailleMax);
	
		return "templates/ajouter";
	}
	
	
	@GetMapping("/editer/haut/{id}")
	public String decalerHaut(@PathVariable(value="id", required=true) int myId, Model model, HttpSession session) {
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
		
		OrdreMatiere ordreMatiereTemp = myOrdreMatieres.get(myId);
		myOrdreMatieres.set(myId, myOrdreMatieres.get(myId-1));
		myOrdreMatieres.set(myId-1, ordreMatiereTemp);
		
		myOrdreMatieres = refreshOrdre(myOrdreMatieres);
		
		session.setAttribute("ordreMatieres", myOrdreMatieres);
		
		
		List<Matiere> listeMatiere = daoMatiere.findAll();
		model.addAttribute("listeMatiere", listeMatiere);
		
		int tailleMax = myOrdreMatieres.size();
		model.addAttribute("tailleMax", tailleMax);
		
		
		return "templates/ajouter";
	}
	

	@GetMapping("/editer/bas/{id}")
	public String decalerBas(@PathVariable(value="id", required=true) int myId, Model model, HttpSession session) {
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
		
		OrdreMatiere ordreMatiereTemp = myOrdreMatieres.get(myId);
		myOrdreMatieres.set(myId, myOrdreMatieres.get(myId+1));
		myOrdreMatieres.set(myId+1, ordreMatiereTemp);
		
		myOrdreMatieres = refreshOrdre(myOrdreMatieres);
		
		session.setAttribute("ordreMatieres", myOrdreMatieres);
		
		
		List<Matiere> listeMatiere = daoMatiere.findAll();
		model.addAttribute("listeMatiere", listeMatiere);
		
		int tailleMax = myOrdreMatieres.size();
		model.addAttribute("tailleMax", tailleMax);
		
		
		return "templates/ajouter";
	}
	
	
	@PostMapping("/valider")
	public String ajouter(@Valid @ModelAttribute("template") Template myTemplate, BindingResult result, Model model, HttpSession session) {
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
		
		System.out.println("liste sauvegarde = " + myOrdreMatieres);
		
		myTemplate.setOrdreMatieres(myOrdreMatieres);
		
		if (result.hasErrors()) {
			
			List<Matiere> listeMatiere = daoMatiere.findAll();
			model.addAttribute("listeMatiere", listeMatiere);
			
			int tailleMax = myOrdreMatieres.size();
			model.addAttribute("tailleMax", tailleMax);
			
			model.addAttribute("Matieres", myTemplate.getOrdreMatieres());
			
			return "templates/ajouter";
		}
		
		System.out.println("Template sauvegarde = " + myTemplate);

		daoTemplate.save(myTemplate);
		
		for (OrdreMatiere o : myOrdreMatieres) {
			o.setTemplate(myTemplate);
			daoOrdreMatiere.save(o);
		}
		
		return "redirect:/templates";
	}

	
	private List<OrdreMatiere> refreshOrdre(List<OrdreMatiere> myOrdreMatieres) {
		
		for (int i=0; i<myOrdreMatieres.size(); i++) {
			myOrdreMatieres.get(i).setOrdre(i);
		}
		
		return myOrdreMatieres;
	}

}
