package fr.formation.disponibilite.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.disponibilite.model.Disponibilite;

@Controller
public class TestKlerviDispoController {

<<<<<<< HEAD
//	@GetMapping("/disponibilite" )
//	public String produit(Model model) {
//		ArrayList liste = new ArrayList<Disponibilite>();
//		model.addAttribute("liste", liste);
//		return "/disponibilite";
//	}
//	
=======
	@GetMapping("/disponibilite" )
	public String produit(Model model) {
		ArrayList<Disponibilite> liste = new ArrayList<Disponibilite>();
		Disponibilite dispo = new Disponibilite();
		dispo.setDate(LocalDate.now());
		dispo.setId(1);
		dispo.setEtatOrdi(80.5);
		dispo.setEtatSalle(15.0);
		dispo.setEtatVideoProj(2.35);
		liste.add(dispo);
		model.addAttribute("liste", liste);
		return "/disponibilite";
	}
	
>>>>>>> Module_disponibilite
}
