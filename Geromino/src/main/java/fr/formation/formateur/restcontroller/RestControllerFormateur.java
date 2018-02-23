package fr.formation.formateur.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.ressources.dao.IFormateurDAO;
import fr.formation.ressources.metier.Formateur;



@ResponseBody
@RestController
@RequestMapping("/formateur")
@CrossOrigin("*")
public class RestControllerFormateur {

	
	//====================================INJECTION=====================================================
	@Autowired
	IFormateurDAO daoFormateur;

	//====================================FIND FORMATEUR==========================================================
	@GetMapping("/{id}")
	public Formateur findById(@PathVariable int id) {
		return this.daoFormateur.findById(id).get();
	}
	
	
	//====================================CONNEXION==========================================================
	@PostMapping("/connexion/{login}/{motDePasse}")
	public Formateur findByAuthentification(@PathVariable String login,@PathVariable String motDePasse) {
		return this.daoFormateur.findByAuthentification(login,motDePasse);
	}
	

	
}
