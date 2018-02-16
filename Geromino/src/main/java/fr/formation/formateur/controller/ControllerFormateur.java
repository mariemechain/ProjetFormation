package fr.formation.formateur.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.formateur.dao.IExpertiseDAO;
import fr.formation.formateur.dao.IFormateurDAO;
import fr.formation.formateur.dao.IMatiereDAOPourTest;
import fr.formation.formateur.model.Expertise;
import fr.formation.formateur.model.Formateur;
import fr.formation.formateur.model.Niveau;
import fr.formation.test.Matiere;

@ResponseBody
@RestController
@RequestMapping("/formateur")
public class ControllerFormateur {

	
//====================================INJECTION=====================================================
@Autowired
IFormateurDAO daoFormateur;

@Autowired
IMatiereDAOPourTest daoMatiere;

@Autowired
IExpertiseDAO daoExpertise;


//====================================INITIALISATION=====================================================
@ModelAttribute("modifexpertise")
public Formateur initFormateur() {
	Formateur formateur = new Formateur();
return formateur;
}

@ModelAttribute("expertise")
public Expertise initExpertise() {
	Expertise expertise = new Expertise();
return expertise;
}

@ModelAttribute("listeMatiere")
public List<Matiere> initMatiere() {
	List<Matiere> listeMatiere = new ArrayList<Matiere>();
return listeMatiere;
}

@ModelAttribute("listeExpertises")
public List<Expertise> initListeExpertise() {
	List<Expertise> listeExpertises = new ArrayList<Expertise>();
return listeExpertises;
}

//====================================MATIERES FORMATEUR=====================================================
@GetMapping ( value = {""})
public String getModifExpertise (Model model,@RequestParam("idf") int idFormateur){
	model.addAttribute("formateur",daoFormateur.findById(idFormateur).get());
	model.addAttribute("listeExpertises",daoFormateur.findById(idFormateur).get().getExpertises());
	return "listeexpertise";
}

//====================================SUPPRESSION=====================================================
@GetMapping(value={ "/supprimer" })
public String getSuppExpertise(@RequestParam("ide") int idExpertise, Model model) {
	
	Formateur formateur = new Formateur();
	Expertise expertise = new Expertise();
	List<Expertise> listeExpertise = new ArrayList<Expertise>();
	expertise = daoExpertise.findById(idExpertise).get();
	formateur = expertise.getFormateur();
	listeExpertise = formateur.getExpertises();
	for (int i=0;i< listeExpertise.size();i++){	
		if (listeExpertise.get(i).getId() == idExpertise){
		formateur.getExpertises().remove(i);
		}
	}
	daoFormateur.save(formateur);
return "redirect:./";
}


//====================================AJOUT=====================================================

@GetMapping(value={ "/ajouter" })
public String getAjouterExpertise(@RequestParam("idf") int idFormateur, Model model) {
	model.addAttribute("formateur",daoFormateur.findById(idFormateur).get());
	

	return "modifexpertise";
}


@PostMapping(value={ "/ajouter" })
public String postAjouterExpertise(@RequestParam("idf") int idFormateur,@RequestParam("string") String niveau,@RequestParam("idM") int idMatiere, Model model) {
	
	//Initialisation
	Formateur formateur = new Formateur();
	formateur = daoFormateur.findById(idFormateur).get();
	List<Expertise> listeExpertise = new ArrayList<Expertise>();
	List<Matiere> listeMatiere = new ArrayList<Matiere>();
	listeExpertise = formateur.getExpertises();
	Expertise expertise = new Expertise();
	
	
	//Statut: Edition ==> afin d'afficher le bon contenu sur le formulaire
		model.addAttribute("statut","ajout");
	
	//Test Niveau Saisi
	if (niveau != "")
	{
	switch (niveau){
	
	case "Debutant":
		expertise.setNiveau(Niveau.Debutant);
	break;
	
	case "Intermediaire":
		expertise.setNiveau(Niveau.Intermediaire);
		break;
		
	case "Avance":
		expertise.setNiveau(Niveau.Avance);
		break;
		
	case "Expert":
		expertise.setNiveau(Niveau.Expert);
		break;
	
	default:
		
	}
	}
	
	//Allocation de la matière de l'expertise
	Matiere matiere = new Matiere();
	matiere = daoMatiere.findById(idMatiere).get();
	
	expertise.setMatiere(matiere);
	expertise.setFormateur(formateur);
	
	
	//Ajout de l'expertise au formateur
	formateur.getExpertises().add(expertise);
	
	//Sauvegarde du formateur modifié
	daoFormateur.save(formateur);
	
	
	
return "redirect:./";
}



//====================================MODIFIER=====================================================

@GetMapping(value={ "/modifier" })
public String getModifierExpertise(@RequestParam("idf") int idFormateur,@RequestParam("ide") int idExpertise, Model model) {
	
	model.addAttribute("formateur",daoFormateur.findById(idFormateur).get());
	model.addAttribute("expertise",daoExpertise.findById(idExpertise).get());
	
return "modifexpertise";
}


@PostMapping(value={ "/modifier" })
public String postModifierExpertise(@RequestParam("ide") int idExpertise,@RequestParam("string") String niveau, Model model) {
	
	
	//Initialisation
		Formateur formateur = new Formateur();
		Expertise expertise = daoExpertise.findById(idExpertise).get();
		formateur = expertise.getFormateur();
		List<Expertise> listeExpertise = new ArrayList<Expertise>();
		listeExpertise = formateur.getExpertises();
		
	//Statut: Edition ==> afin d'afficher le bon contenu sur le formulaire
		model.addAttribute("statut","edition");
	//Test Niveau Saisi
		if (niveau != "")
		{
		switch (niveau){
		
		case "Debutant":
			expertise.setNiveau(Niveau.Debutant);
		break;
		
		case "Intermediaire":
			expertise.setNiveau(Niveau.Intermediaire);
			break;
			
		case "Avance":
			expertise.setNiveau(Niveau.Avance);
			break;
			
		case "Expert":
			expertise.setNiveau(Niveau.Expert);
			break;
		
		default:
			
		}
		}
	//Modification de l'expertise dans la liste du formateur	
		for (int i=0;i<listeExpertise.size();i++){
			if (listeExpertise.get(i).getId()== idExpertise){
				listeExpertise.set(i, expertise);
			}
		}
		
	//Sauvegarde du formateur modifié
		formateur.setExpertises(listeExpertise);
	
	//Sauvegarde du formateur modifié
		daoFormateur.save(formateur);
	
return "redirect:./";
}










}
