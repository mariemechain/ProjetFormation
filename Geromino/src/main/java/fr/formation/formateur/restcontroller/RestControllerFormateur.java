package fr.formation.formateur.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.formateur.dao.IFormateurDAO;
import fr.formation.formateur.model.Formateur;


@ResponseBody
@RestController
@RequestMapping("/formateur")
@CrossOrigin("*")
public class RestControllerFormateur {

	
	//====================================INJECTION=====================================================
	@Autowired(required=false)
	IFormateurDAO daoFormateur;

	//====================================LISTE FORMATEUR=====================================================
	@GetMapping("/{id}")
	public Formateur findById(@PathVariable int id) {
		return this.daoFormateur.findById(id).get();
	}
	
	
	
	
	
}
