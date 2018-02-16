package fr.formation.projets.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.ressources.model.Formateur;

@Controller
@RequestMapping("/selectFormateur")
public class SelectFormateurController {

	

	 @GetMapping("")
		 public String getPlannification(HttpServletRequest req, Model model) {
		
//			List formateurs
			List<Formateur> formateurs = (List<Formateur>) req.getServletContext().getAttribute("myFormateursListener");

			for (Formateur formateur : formateurs) {
				System.out.println(formateur);
			}

			model.addAttribute("formateurs", formateurs);
		
		 return "planification/selectFormateur";
		 }
}
