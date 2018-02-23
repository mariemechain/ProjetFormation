
package fr.formation.ressources.controller;

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
import fr.formation.ressources.dao.IOrdreMatiereDAO;
import fr.formation.ressources.dao.ITemplateDAO;
import fr.formation.ressources.metier.OrdreMatiere;
import fr.formation.ressources.metier.Template;

//Test Modification
@Controller
@RequestMapping("/gestionnaire/gestionnaireTemplates")
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
		model.addAttribute("Template", myTemplate);
		model.addAttribute("ordreMatieres", myTemplate.getOrdreMatieres());
		
		return "templates/visualiser";
	}
		
	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable(value="id", required=true) int myId, Model model) {
		
		Template myTemplate = daoTemplate.findById(myId).get();
		System.err.println(myTemplate);
		daoTemplate.delete(myTemplate);
		
		return "redirect:/gestionnaire/gestionnaireTemplates";
	}

	@GetMapping("/modifier/{id}")
	public String modifier(@PathVariable(value="id", required=true) int myId, Model model, HttpSession session) {
		
		Template myTemplate = daoTemplate.findById(myId).get();
		session.setAttribute("template", myTemplate);
		model.addAttribute("template", myTemplate);
		List<OrdreMatiere> ordreMatieres = myTemplate.getOrdreMatieres();
		session.setAttribute("ordreMatieres", ordreMatieres);
		//model.addAttribute("ordreMatieres", ordreMatieres);
		
		afficheMatiere(model, ordreMatieres);
		
		return "templates/ajouter";
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

	@PostMapping("/editer/ajouterligne")
	public String ajouterLigne(@RequestParam("matiereId") int matiereId, Model model, HttpSession session) {
		
		Matiere myMatiere = daoMatiere.findById(matiereId);
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
		
		OrdreMatiere ordreMatiere = new OrdreMatiere();
		ordreMatiere.setMatiere(myMatiere);
		ordreMatiere.setOrdre(myOrdreMatieres.size());
		myOrdreMatieres.add(ordreMatiere);
		
		
		session.setAttribute("ordreMatieresSession", myOrdreMatieres);
		
		afficheMatiere(model, myOrdreMatieres);

		return "templates/ajouter";
	}
	

	@GetMapping("/editer/supprimer/{id}")
	public String supprimerLigne(@PathVariable(value="id", required=true) int myOrdre, Model model, HttpSession session) {
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");		
		myOrdreMatieres.remove(myOrdre);		
		myOrdreMatieres = refreshOrdre(myOrdreMatieres);
		
		session.setAttribute("ordreMatieres", myOrdreMatieres);
		
		afficheMatiere(model, myOrdreMatieres);
	
		return "templates/ajouter";
	}
	
	
	@GetMapping("/editer/haut/{id}")
	public String decalerHaut(@PathVariable(value="id", required=true) int myOrdre, Model model, HttpSession session) {
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
		
		OrdreMatiere ordreMatiereTemp = myOrdreMatieres.get(myOrdre);
		myOrdreMatieres.set(myOrdre, myOrdreMatieres.get(myOrdre-1));
		myOrdreMatieres.set(myOrdre-1, ordreMatiereTemp);
		
		myOrdreMatieres = refreshOrdre(myOrdreMatieres);
		
		session.setAttribute("ordreMatieres", myOrdreMatieres);
		
		afficheMatiere(model, myOrdreMatieres);
		
		
		return "templates/ajouter";
	}
	

	@GetMapping("/editer/bas/{id}")
	public String decalerBas(@Valid @ModelAttribute("ordreMatieres") List<OrdreMatiere> myOrdreMatieres, @PathVariable(value="id", required=true) int myOrdre, Model model, HttpSession session) {
		
		//List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
		
		OrdreMatiere ordreMatiereTemp = myOrdreMatieres.get(myOrdre);
		myOrdreMatieres.set(myOrdre, myOrdreMatieres.get(myOrdre+1));
		myOrdreMatieres.set(myOrdre+1, ordreMatiereTemp);
		
		myOrdreMatieres = refreshOrdre(myOrdreMatieres);
		
		session.setAttribute("ordreMatieres", myOrdreMatieres);
		
		afficheMatiere(model, myOrdreMatieres);
		
		
		return "templates/ajouter";
	}
	
	
	@PostMapping("/valider")
	public String ajouter(@Valid @ModelAttribute("template") Template myTemplate, BindingResult result, Model model, HttpSession session) {
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
					
		myTemplate.setOrdreMatieres(myOrdreMatieres);
		
		if (result.hasErrors()) {
			afficheMatiere(model, myOrdreMatieres);
			
			model.addAttribute("Matieres", myTemplate.getOrdreMatieres());
			
			return "templates/ajouter";
		}

		daoTemplate.save(myTemplate);

		daoOrdreMatiere.deleteByTemplateId(myTemplate.getId());
		
		for (OrdreMatiere o : myTemplate.getOrdreMatieres()) {
			o.setTemplate(myTemplate);
			daoOrdreMatiere.save(o);
		}
		
		session.setAttribute("ordreMatieres",myTemplate.getOrdreMatieres());
		
		return "redirect:/gestionnaire/gestionnaireTemplates";
	}

	
	private List<OrdreMatiere> refreshOrdre(List<OrdreMatiere> myOrdreMatieres) {
		
		for (int i=0; i<myOrdreMatieres.size(); i++) {
			myOrdreMatieres.get(i).setOrdre(i);
		}
		
		return myOrdreMatieres;
	}
	
	private void afficheMatiere(Model model, List<OrdreMatiere> ordreMatieres ) {
		
		List<Matiere> listeMatiere = daoMatiere.findAll();
		model.addAttribute("listeMatiere", listeMatiere);	
		
		int tailleMax = ordreMatieres.size();
		model.addAttribute("tailleMax", tailleMax);
		
	}

}

