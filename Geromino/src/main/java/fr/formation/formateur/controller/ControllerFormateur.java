package fr.formation.formateur.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.formateur.dao.IExpertiseDAO;
import fr.formation.formateur.dao.IFormateurDAO;
import fr.formation.formateur.dao.IMatiereDAOPourTest;
import fr.formation.formateur.model.Expertise;
import fr.formation.formateur.model.Formateur;
import fr.formation.formateur.model.Niveau;
import fr.formation.formateur.model.Matiere;


@Controller
@RequestMapping("/formateur")
public class ControllerFormateur {

	
//====================================INJECTION=====================================================
@Autowired(required=false)
IFormateurDAO daoFormateur;

@Autowired(required=false)
IMatiereDAOPourTest daoMatiere;

@Autowired(required=false)
IExpertiseDAO daoExpertise;


//====================================INITIALISATION=====================================================

@ModelAttribute("formateur")
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
@GetMapping ( value = {"/liste"})
public String getListeExpertise (Model model,@RequestParam("idf") int idFormateur){

	model.addAttribute("formateur",daoFormateur.findById(idFormateur).get());
	model.addAttribute("listeExpertises",daoFormateur.findById(idFormateur).get().getExpertises());
	return "listeexpertise";
}

//====================================SUPPRESSION=====================================================
@GetMapping(value={ "/supprimer" })
public String getSuppExpertise(@RequestParam("idf") int idFormateur, @RequestParam("ide") int idExpertise, Model model) {
	
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
	daoExpertise.delete(daoExpertise.findById(idExpertise).get());
	
	
	
return "redirect:./liste?idf="+ idFormateur;
}


//====================================AJOUT=====================================================

@GetMapping(value={ "/ajouter" })
public String getAjouterExpertise(@RequestParam("idf") int idFormateur, Model model) {
	model.addAttribute("formateur",daoFormateur.findById(idFormateur).get());
	
	//Statut: Ajout ==> afin d'afficher le bon contenu sur le formulaire
	model.addAttribute("statut","ajout");
	//Allocation de la liste des matières à la liste d'attribut
	model.addAttribute("listeMatiere",daoMatiere.findAll());
		
	return "modifexpertise";
}


@PostMapping(value={ "/ajouter" })
public String postAjouterExpertise(@RequestParam("idf") int idFormateur,@RequestParam("niveau") String niveau,@RequestParam("idM") int idMatiere, Model model) {
	
	//Initialisation
	Formateur formateur = new Formateur();
	formateur = daoFormateur.findById(idFormateur).get();
	List<Expertise> listeExpertise = new ArrayList<Expertise>();
	List<Matiere> listeMatiere = new ArrayList<Matiere>();
	//listeExpertise = formateur.getExpertises();
	Expertise expertise = new Expertise();
	
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
	
	if (formateur.getExpertises() == null) {
		
		formateur.setExpertises(listeExpertise);
		//Ajout de l'expertise au formateur
		formateur.getExpertises().add(expertise);
	}else {
		//Ajout de l'expertise au formateur
		formateur.getExpertises().add(expertise);
	}
	
	//Sauvegarde de l'expertise
	daoExpertise.save(expertise);
	//Sauvegarde du formateur modifié
	daoFormateur.save(formateur);
	
	
return "redirect:./liste?idf="+ idFormateur;
}



//====================================MODIFIER=====================================================

@GetMapping(value={ "/modifier" })
public String getModifierExpertise(@RequestParam("idf") int idFormateur,@RequestParam("ide") int idExpertise, Model model) {
	
	//Statut: Ajout ==> afin d'afficher le bon contenu sur le formulaire
    model.addAttribute("statut","edition");
	model.addAttribute("formateur",daoFormateur.findById(idFormateur).get());
	model.addAttribute("expertise",daoExpertise.findById(idExpertise).get());
	model.addAttribute("nivexpertise",daoExpertise.findById(idExpertise).get().getNiveau());
	
return "modifexpertise";
}


@PostMapping(value={ "/modifier" })
public String postModifierExpertise(@RequestParam("idf") int idFormateur,@RequestParam("ide") int idExpertise,@RequestParam("niveau") String niveau, Model model) {
	
	
	//Initialisation
		Formateur formateur = new Formateur();
		Expertise expertise = daoExpertise.findById(idExpertise).get();
		formateur = expertise.getFormateur();
		List<Expertise> listeExpertise = new ArrayList<Expertise>();
		listeExpertise = formateur.getExpertises();
		
	//Statut: Edition ==> afin d'afficher le bon contenu sur le formulaire
		model.addAttribute("statut","edition");
		
	
	//Test Niveau Saisie
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
	
	//Sauvegarde de l'expertise modifiée	
		daoExpertise.save(expertise);
		
	//Sauvegarde de la liste
		formateur.setExpertises(listeExpertise);
	
	//Sauvegarde du formateur modifié
		daoFormateur.save(formateur);
	
return "redirect:./liste?idf="+ idFormateur;
}

}
