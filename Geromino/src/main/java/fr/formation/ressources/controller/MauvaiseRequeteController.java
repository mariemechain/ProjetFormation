
package fr.formation.ressources.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class MauvaiseRequeteController {
	
	@ModelAttribute("page")
    public String page() {
        return "mauvaiseRequete";
    }
	
	@GetMapping(value = { "/mauvaiseRequete"})
	public String mauvaiseRequete() {
		return "mauvaiseRequete";
	}
}


