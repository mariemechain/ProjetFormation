package fr.formation.projets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import fr.formation.projets.dao.ITemplateDAO;
import fr.formation.projets.model.Planification;
import fr.formation.projets.model.Projet;
import fr.formation.ressources.metier.Salle;
import fr.formation.ressources.metier.Stagiaire;

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
		model.addAttribute("salles", daoSalle.findAll());
		return "projet/addprojet";
	}
	
	@PostMapping("/ajouter")
    public String ajouter(@ModelAttribute("projet") Projet projet, 
                          @RequestParam String idSalle) {
        
        Salle s = daoSalle.findById(idSalle).get(); 
        projet.setSalle(s);
        System.out.println(projet);
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
	@GetMapping("/editer/{id}")
	public String editer(@PathVariable int id, Model model) {
		Projet p1= daoProjet.findById(id).get();
		model.addAttribute("projet",p1);
		model.addAttribute("salles", daoSalle.findAll());

		
		return "projet/editprojet";
	}

	@PostMapping("/editer/{id}")
	public String editerPost(@ModelAttribute("projet") Projet projet,
						     @PathVariable int id, 
						     @RequestParam String idSal, 
						     Model model){
		
		// TODO : ajouter un requestParam pour le cursus 

		
		Salle s = daoSalle.findById(idSal).get(); 
		
		projet.setId(id);
		projet.setSalle(s);
		
		daoProjet.save(projet);
		
			return "redirect:../projet";
	}
	
	// SUPRESSION
	@GetMapping("/supprimer")
	public String supprimer(@RequestParam("id") int idProjet) {
		daoProjet.deleteById(idProjet);
		
		return "redirect:../projet";
	}
	
	
	@GetMapping("/detailProjet")
    public String detail(@RequestParam("id") int id, Model model) {
        
        Projet detailProjet = daoProjet.findById(id).get();
        model.addAttribute("detailProjet", detailProjet);
        
        List<Planification> planifications = detailProjet.getPlanifications();
        model.addAttribute("projetPlanifications", planifications);
        
        List<Stagiaire> stagiaires = detailProjet.getStagiaires();
        model.addAttribute("projetStagiaires", stagiaires);

        return "projet/detailProjet";
    }
}
