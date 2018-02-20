package fr.formation.ressources.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import fr.formation.ressources.metier.Personne;
import fr.formation.ressources.metier.Personnel;


@Controller
public class HomeController {
	
	@ModelAttribute("page")
    public String page() {
        return "home";
    }
	
	@GetMapping(value = { "/home", "/home/{login}" })
	public String home(@PathVariable(value="login", required=false) String login, Model model, HttpSession ses) {
		return "home";
	}
}

