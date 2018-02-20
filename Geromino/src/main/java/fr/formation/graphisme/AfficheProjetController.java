package fr.formation.graphisme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.formateur.dao.IFormateurDAO;
import fr.formation.matieres.dao.IMatiereDAO;
import fr.formation.projets.dao.IPlanificationDAO;
import fr.formation.projets.dao.IProjetDAO;
import fr.formation.projets.model.Projet;

@Controller
@RequestMapping(value = "/afficheProjet")
public class AfficheProjetController {

	@Autowired
	private IMatiereDAO daoMat;
	
	@Autowired
	private IProjetDAO daoPro;
	
	@Autowired
	private IFormateurDAO daoFor;
	
	@Autowired
	private IPlanificationDAO daoPla;
	
	@GetMapping("")
	public String afficher(@RequestParam("id") int id, Model model) {
		model.addAttribute("projet", daoPro.findById(id).get());
		System.out.println(daoPro.findById(id).get());
		return "afficheProjet";
	}
}
