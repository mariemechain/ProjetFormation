
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
		model.addAttribute("Template", myTemplate);
		
		
		List<OrdreMatiere> detailOrdreMatieres = daoOrdreMatiere.findAllByTemplateId(myId);
		model.addAttribute("ordreMatieres", detailOrdreMatieres);
		
//		for(OrdreMatiere o : detailOrdreMatieres ){
//			List prerequis = new ArrayList();
//			for(Matiere m : o.getMatiere().getPrerequis()) {
//					prerequis.add(m.getTitre());
//			}
//			model.addAttribute("Prerequis", prerequis);
//		}
		
		return "templates/visualiser";
	}
		
	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable(value="id", required=true) int myId, Model model) {
		
		Template myTemplate = daoTemplate.findById(myId).get();
		System.err.println(myTemplate);
		daoTemplate.delete(myTemplate);
		
		return "redirect:/templates";
	}

	@GetMapping("/modifier/{id}")
	public String modifier(@PathVariable(value="id", required=true) int myId, Model model, HttpSession session) {
		
		Template myTemplate = daoTemplate.findById(myId).get();
		List<OrdreMatiere> ordreMatieres = daoOrdreMatiere.findAllByTemplateId(myId);
		myTemplate.setOrdreMatieres(ordreMatieres);
		session.setAttribute("template", myTemplate);

		session.setAttribute("ordreMatieres", ordreMatieres);
		afficheMatiere(model, ordreMatieres);
		
		boolean erreurTemplateEmpty=false;
		session.setAttribute("erreurTemplateEmpty", erreurTemplateEmpty);
		
		session.setAttribute("erreurPrerequisManquant", verifPrerequis(ordreMatieres));
		
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
		
		boolean erreurTemplateEmpty=false;
		session.setAttribute("erreurTemplateEmpty", erreurTemplateEmpty);
		
		session.setAttribute("erreurPrerequisManquant", false);
		
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
		
		session.setAttribute("erreurPrerequisManquant", verifPrerequis(myOrdreMatieres));

		return "templates/ajouter";
	}
	

	@GetMapping("/editer/supprimer/{id}")
	public String supprimerLigne(@PathVariable(value="id", required=true) int myOrdre, Model model, HttpSession session) {
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");		
		myOrdreMatieres.remove(myOrdre);		
		myOrdreMatieres = refreshOrdre(myOrdreMatieres);
		
		session.setAttribute("ordreMatieres", myOrdreMatieres);
		
		afficheMatiere(model, myOrdreMatieres);
		
		session.setAttribute("erreurPrerequisManquant", verifPrerequis(myOrdreMatieres));
	
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
	public String decalerBas(@PathVariable(value="id", required=true) int myOrdre, Model model, HttpSession session) {
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
		
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
		
		boolean erreurTemplateEmpty=false;
		session.setAttribute("erreurTemplateEmpty", erreurTemplateEmpty);
		
		model.addAttribute("erreurMatiereDoublon", false);
		
		List<OrdreMatiere> myOrdreMatieres = (List<OrdreMatiere>) session.getAttribute("ordreMatieres");
					
		myTemplate.setOrdreMatieres(myOrdreMatieres);
		
		if (result.hasErrors()) {
			afficheMatiere(model, myOrdreMatieres);
			
			model.addAttribute("Matieres", myTemplate.getOrdreMatieres());
			
			if(verifDoublon(myOrdreMatieres)) {
				model.addAttribute("erreurMatiereDoublon", true);
			}
			
			if (myOrdreMatieres.isEmpty()) {
				erreurTemplateEmpty=true;
				session.setAttribute("erreurTemplateEmpty", erreurTemplateEmpty);
				
				afficheMatiere(model, myOrdreMatieres);
				model.addAttribute("Matieres", myTemplate.getOrdreMatieres());
				
				
			}
			
			return "templates/ajouter";
			
		}
		
		if (myOrdreMatieres.isEmpty()) {
			erreurTemplateEmpty=true;
			session.setAttribute("erreurTemplateEmpty", erreurTemplateEmpty);
			
			afficheMatiere(model, myOrdreMatieres);
			model.addAttribute("Matieres", myTemplate.getOrdreMatieres());
			
			return "templates/ajouter";
		}
		
		if(verifDoublon(myOrdreMatieres)) {
			model.addAttribute("erreurMatiereDoublon", true);
			return "templates/ajouter";
		}

		daoTemplate.save(myTemplate);

		daoOrdreMatiere.deleteByTemplateId(myTemplate.getId());
		
		for (OrdreMatiere o : myTemplate.getOrdreMatieres()) {
			o.setTemplate(myTemplate);
			daoOrdreMatiere.save(o);
		}
		
		session.setAttribute("ordreMatieres",myTemplate.getOrdreMatieres());
		
		return "redirect:/templates";
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
	
	private boolean verifPrerequis(List<OrdreMatiere> ordreMatieres) {
		
		for(OrdreMatiere o : ordreMatieres) {
			for( Matiere m : o.getMatiere().getPrerequis()) {
				int count=0;
				for( OrdreMatiere o2 : ordreMatieres ) {
					if(o2.getMatiere().getTitre().equals(m.getTitre()))
						count++;
				}
				
				if(count==0)
					return true;
			}
		}
		
		return false;
	}
	
	private boolean verifDoublon(List<OrdreMatiere> ordreMatieres) {
		
		for(OrdreMatiere o : ordreMatieres) {
			int count=0;
			
			for(OrdreMatiere o2 : ordreMatieres) {
				if(o.getMatiere().getTitre().equals(o2.getMatiere().getTitre()))
					count++;
			}
			
			if(count>1)
				return true;
		}
		
		return false;
	}
}

