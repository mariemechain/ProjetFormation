package fr.formation.ressources.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.dao.IOrdinateurDAO;
import fr.formation.ressources.dao.IStagiaireDAO;
import fr.formation.ressources.dao.ITechnicienDAO;
import fr.formation.ressources.dao.IVideoProjecteurDAO;
import fr.formation.ressources.metier.Ordinateur;
import fr.formation.ressources.metier.VideoProjecteur;

@Controller
@RequestMapping("/technicien")
public class TechnicienController {
	
	@ModelAttribute("page")
    public String page() {
        return "technicien";
    }
	
	@Autowired
	private ITechnicienDAO techDAO;
	@Autowired
	private IOrdinateurDAO ordiDAO;
	@Autowired
	private IVideoProjecteurDAO videoDAO;
	@Autowired
	private IStagiaireDAO stagDAO;
	
	@GetMapping("")
	public String tech(Model model) {
		
		return "technicien";
	}
	
	
	//***********************************************************************************************
	//****************************ORDI**************************************************************
	//***********************************************************************************************
	
	@GetMapping("/ordi")
	public String listeOrdi(Model model) {
		model.addAttribute("ordinateurs", ordiDAO.findAll());
		return "techOrdi";
	}
		
	//************************************************** Ajouter un ordi***************************
	@GetMapping("/ordi/ajouter")
	public String ajouterOrdi(Model model) {
		model.addAttribute("ordinateur", new Ordinateur());
		return "ajouterOrdi";
	}
	
	@PostMapping("/ordi/ajouter")
	public String sauvegardeOrdi(@Valid @ModelAttribute("ordinateur") Ordinateur ordinateur, 
			 Model model) {
		
		ordiDAO.save(ordinateur);
		return "redirect:./";
	}
	
	//************************************************** Modifier un ordi***************************
	@GetMapping("/ordi/modifier")
	public String modifOrdi(Model model, @RequestParam("id") String idOrdi) {
		model.addAttribute("ordinateur", new Ordinateur());
		model.addAttribute("ordinateur", ordiDAO.findById(idOrdi).get());
		return "ajouterOrdi";
	}
	
	@PostMapping("/ordi/modifier")
	public String modifierOrdi(@ModelAttribute("ordinateur") Ordinateur ordinateur, 
			 Model model, @RequestParam("id") String idOrdi) {
		ordinateur.setId(idOrdi);
		ordiDAO.save(ordinateur);
		return "redirect:./";
	}
	
	
	//**************************************************Supprimer un ordi***************************
	@GetMapping("/ordi/supprimer") 
	  public String deleteOrdi(@RequestParam("id") String idOrdi) { 
	    ordiDAO.deleteById(idOrdi); 
	    return "redirect:./"; 
	  } 
	
	//***********************************************************************************************
	//****************************VIDEO**************************************************************
	//***********************************************************************************************
		
	@GetMapping("/video")
	public String listeVideo(Model model) {
		model.addAttribute("videoprojecteurs", videoDAO.findAll());
		return "techVideo";
	}
	
	//************************************************** Ajouter un videoproj***************************
	 @GetMapping("/video/ajouter") 
	  public String ajouterVideo(Model model) { 
	    model.addAttribute("videoprojecteur", new VideoProjecteur()); 
	    return "ajouterVideo"; 
	  } 
	   
	  @PostMapping("/video/ajouter") 
	  public String sauvegardeVideo(@Valid @ModelAttribute("videoprojecteur") VideoProjecteur videoprojecteur, /*BindingResult result,*/ 
	       Model model) { 
	    videoDAO.save(videoprojecteur); 
	    return "redirect:./"; 
	  } 
	  
	//************************************************** Modifier un videoproj***************************
		@GetMapping("/video/modifier")
		public String modifVideoprojecteur(Model model, @RequestParam("id") String idVideo) {
			model.addAttribute("videoprojecteur", new VideoProjecteur());
			model.addAttribute("videoprojecteur", videoDAO.findById(idVideo).get());
			return "ajouterVideo";
		}
		
		@PostMapping("/video/modifier")
		public String modifierOrdi(@ModelAttribute("videoprojecteur") VideoProjecteur videoprojecteur,
				 Model model,  @RequestParam("id") String idVideo) {
			
				videoprojecteur.setId(idVideo);
			 videoDAO.save(videoprojecteur); 
			return "redirect:./";
		}   
	  
	//**************************************************Supprimer un videoproj*************************** 
	  @GetMapping("/video/supprimer") 
	  public String deleteVideo(@RequestParam("id") String idVideo) { 
	    videoDAO.deleteById(idVideo); 
	    return "redirect:./"; 
	  } 
	
}
