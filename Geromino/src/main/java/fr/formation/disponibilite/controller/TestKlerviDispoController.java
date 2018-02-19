package fr.formation.disponibilite.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.disponibilite.model.Disponibilite;

@Controller
public class TestKlerviDispoController {

	@GetMapping("/disponibilite" )
	public String produit(Model model) {
		ArrayList liste = new ArrayList<Disponibilite>();
		model.addAttribute("liste", liste);
		return "/disponibilite";
	}
	
}
