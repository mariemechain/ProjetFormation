package fr.formation.projets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plannification")
public class PlannificationController {

	
	

	@GetMapping("")
	public String home(Model model){
		
		model.addAttribute("message","Allô le monde! by Mounzer");
		
		return "plannification";
	}
}
