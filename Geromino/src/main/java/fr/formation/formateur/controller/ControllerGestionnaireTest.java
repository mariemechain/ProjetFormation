package fr.formation.formateur.controller;

import java.util.ArrayList;

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
import fr.formation.formateur.model.Formateur;
import fr.formation.formateur.model.Niveau;
import fr.formation.matieres.dao.IMatiereDAO;
import fr.formation.matieres.model.Matiere;


@Controller
@RequestMapping("/projet/detailProjet/{idProjet}/planification/{matiere}/{idPlanif}/formateurs")
public class ControllerGestionnaireTest {

	
//====================================INJECTION=====================================================
@Autowired(required=false)
IFormateurDAO daoFormateur;

@Autowired
IMatiereDAO daoMatiere;

//====================================INITIALISATION=====================================================

@ModelAttribute("formateur")
public Formateur initFormateur() {
	Formateur formateur = new Formateur();
return formateur;
}


@ModelAttribute("listeFormateurs")
public List<Formateur> initFormateurs() {
	List<Formateur> listeFormateurs = new ArrayList<Formateur>();
return listeFormateurs;
}


@ModelAttribute("listeMatiere")
public List<Matiere> initMatiere() {
	List<Matiere> listeMatiere = new ArrayList<Matiere>();
return listeMatiere;
}

//====================================LISTE FORMATEURS=====================================================
@GetMapping ( value = {""})
public String getListeFormateur (@PathVariable String matiere
		,@PathVariable int idProjet,
		@PathVariable int idPlanif, 
		Model model){
	model.addAttribute("listeMatiere",daoMatiere.findAll());
	model.addAttribute("listeformateurs",daoFormateur.findAll());
	return "listeformateurtest";
}

@PostMapping(value={ "" })
public String setListeFormateurFilter (Model model,@RequestParam("niveau") String niveaufilter,@RequestParam("matiere") int matierefilter){
	model.addAttribute("listeMatiere",daoMatiere.findAll());
	
	switch (niveaufilter){
	
	case "Debutant":
		model.addAttribute("listeformateurs",daoFormateur.findByFilter(matierefilter,Niveau.Debutant));
	break;
	
	case "Intermediaire":
		model.addAttribute("listeformateurs",daoFormateur.findByFilter(matierefilter,Niveau.Intermediaire));
		break;
		
	case "Avance":
		model.addAttribute("listeformateurs",daoFormateur.findByFilter(matierefilter,Niveau.Avance));
		break;
		
	case "Expert":
		model.addAttribute("listeformateurs",daoFormateur.findByFilter(matierefilter,Niveau.Expert));
		break;
	
	default:
		
	}
	
	return "listeformateurtest";
}


//====================================SUPPRESSION=====================================================
@GetMapping(value={ "/supprimer" })
public String getSuppFormateur(@RequestParam("idf") int idFormateur, Model model) {
	
	Formateur formateur = new Formateur();
	formateur = daoFormateur.findById(idFormateur).get();
	daoFormateur.delete(formateur);
return "redirect:../formateurs";
}


//====================================AJOUT=====================================================

@GetMapping(value={ "/ajouter" })
public String getAjouterFormateur( Model model) {
	
	//Statut: Ajout ==> afin d'afficher le bon contenu sur le formulaire
	model.addAttribute("statut","ajout");
		
	return "modifformateurstest";
}


@PostMapping(value={ "/ajouter" })
public String postAjouterFormateur(@RequestParam("titre") String titre,@RequestParam("nom") String nom,@RequestParam("prenom") String prenom, Model model) {
	
	//Initialisation
	Formateur formateur = new Formateur();

	//Allocation des attributs du formateur
	formateur.setTitre(titre);
	formateur.setNom(prenom);
	formateur.setPrenom(nom);
	
	//Sauvegarde du formateur modifié
	daoFormateur.save(formateur);
	
	
return "redirect:../formateurs";
}



//====================================MODIFIER=====================================================

@GetMapping(value={ "/modifier" })
public String getModifierFormateur(@RequestParam("idf") int idFormateur, Model model) {
	
	//Statut: Ajout ==> afin d'afficher le bon contenu sur le formulaire
    model.addAttribute("statut","edition");
    
	model.addAttribute("formateur",daoFormateur.findById(idFormateur).get());

	
return "modifformateurstest";
}


@PostMapping(value={ "/modifier" })
public String postModifierFormateur(@RequestParam("idf") int idFormateur,@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("titre") String titre, Model model) {
	
	
	//Initialisation
		Formateur formateur = new Formateur();
		formateur = daoFormateur.findById(idFormateur).get();
		formateur.setTitre(titre);
		formateur.setTitre(prenom);
		formateur.setTitre(nom);
	
	//Sauvegarde du formateur modifié
		daoFormateur.save(formateur);
	
return "redirect:../formateurs";
}

}
