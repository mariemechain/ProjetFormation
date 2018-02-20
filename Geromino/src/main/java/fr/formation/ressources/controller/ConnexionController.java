package fr.formation.ressources.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.dao.IPersonnelDAO;
import fr.formation.ressources.metier.Personnel;
import fr.formation.ressources.metier.Technicien;


@Controller
public class ConnexionController {
	
	@Autowired
	private IPersonnelDAO daoAuthentification;
	
	@GetMapping(value = { "/connexion" })
	public String connexion(Model model) {
		
		return "connexion";
	}

	
	@ModelAttribute("page")
    public String page() {
        return "connexion";
    }
	
	@PostMapping("/connexion")
	public String connect(HttpSession ses, @RequestParam("login") String login, @RequestParam("motDePasse") String motDePasse, Model model) {

		Personnel p = daoAuthentification.auth(login, motDePasse);
		

		if (p != null) {
			model.addAttribute("utilisateur", daoAuthentification.auth(login, motDePasse));
			//System.out.println(a);
			model.addAttribute("login", login);
			ses.setAttribute("utilisateur", p);
			ses.setAttribute("login", login);
			return "redirect:./home/{login}";
		} else {
			model.addAttribute("isErreur", true);
			
			return "connexion";
		}
	}
	
	@GetMapping("/deconnexion")
	public String deconnect(HttpSession ses) {
		
		ses.invalidate();
		return "redirect:./connexion";
	}
}
