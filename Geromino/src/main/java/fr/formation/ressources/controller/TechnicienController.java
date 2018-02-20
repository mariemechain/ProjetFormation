package fr.formation.ressources.controller;

import java.util.Date;

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
import fr.formation.ressources.metier.Stagiaire;
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

	// ***********************************************************************************************
	// ****************************ORDI**************************************************************
	// ***********************************************************************************************

	@GetMapping("/ordi")
	public String listeOrdi(Model model) {
		model.addAttribute("ordinateurs", ordiDAO.findAll());
		return "techOrdi";
	}

	// *********************** Ajouter un ordi*********************
	@GetMapping("/ordi/ajouter")
	public String ajouterOrdi(Model model) {
		model.addAttribute("ordinateur", new Ordinateur());
		return "ajouterOrdi";
	}

	@PostMapping("/ordi/ajouter")
	public String sauvegardeOrdi(@Valid @ModelAttribute("ordinateur") Ordinateur ordinateur, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "ajouterOrdi";
		}
		ordiDAO.save(ordinateur);
		return "redirect:./";
	}

	// ******************** Modifier un ordi**************************
	@GetMapping("/ordi/modifier")
	public String modifOrdi(Model model, @RequestParam("id") String idOrdi) {
		model.addAttribute("ordinateur", ordiDAO.findById(idOrdi).get());
		return "ajouterOrdi";
	}

	@PostMapping("/ordi/modifier")
	public String modifierOrdi(@Valid @ModelAttribute("ordinateur") Ordinateur ordinateur, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "ajouterOrdi";
		}
		ordiDAO.save(ordinateur);
		return "redirect:./";
	}

	// ********************Modifier dispoordinateur******************
	@GetMapping("/ordi/etat")
	public String dispoOrdi(Model model, @RequestParam("id") String idOrdi) {

		model.addAttribute("ordinateur", ordiDAO.findById(idOrdi).get());
		return "dispoOrdi";
	}

	@PostMapping("/ordi/etat")
	public String dispoOrdinateur(@ModelAttribute("ordinateur") Ordinateur ordinateur,
			@RequestParam("id") String idOrdi, @RequestParam("date") Date date) {
		Ordinateur ordi = ordiDAO.findById(idOrdi).get();
		ordi.setDate(date);
		ordiDAO.save(ordi);
		return "redirect:./";
	}

	// ***********************Supprimer un ordi***************************
	@GetMapping("/ordi/supprimer")
	public String deleteOrdi(@RequestParam("id") String idOrdi) {
		ordiDAO.deleteById(idOrdi);
		return "redirect:./";
	}

	// **********************************************************************************
	// ****************************VIDEO*************************************************
	// **********************************************************************************

	@GetMapping("/video")
	public String listeVideo(Model model) {
		model.addAttribute("videoprojecteurs", videoDAO.findAll());
		return "techVideo";
	}

	// ************************* Ajouter un videoproj***************************
	@GetMapping("/video/ajouter")
	public String ajouterVideo(Model model) {
		model.addAttribute("videoprojecteur", new VideoProjecteur());
		return "ajouterVideo";
	}

	@PostMapping("/video/ajouter")
	public String sauvegardeVideo(@Valid @ModelAttribute("videoprojecteur") VideoProjecteur videoprojecteur,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "ajouterVideo";
		}
		videoDAO.save(videoprojecteur);
		return "redirect:./";
	}

	// ***************** Modifier un videoproj*****************
	@GetMapping("/video/modifier")
	public String modifVideoprojecteur(Model model, @RequestParam("id") String idVideo) {
		model.addAttribute("videoprojecteur", new VideoProjecteur());
		model.addAttribute("videoprojecteur", videoDAO.findById(idVideo).get());
		return "ajouterVideo";
	}

	@PostMapping("/video/modifier")
	public String modifierOrdi(@Valid @ModelAttribute("videoprojecteur") VideoProjecteur videoprojecteur,
			 @RequestParam("id") String idVideo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("videoprojecteur", videoDAO.findById(idVideo).get());
			return "ajouterVideo";
		}
		videoprojecteur.setId(idVideo);
		videoDAO.save(videoprojecteur);
		return "redirect:./";
	}

	// *************Modifier dispo videoproj*************
	@GetMapping("/video/etat")
	public String dispoVideo(Model model, @RequestParam("id") String idVideo) {

		model.addAttribute("videoprojecteur", videoDAO.findById(idVideo).get());
		return "dispoVideo";
	}

	@PostMapping("/video/etat")
	public String dispoVideoprojecteur(@ModelAttribute("videoprojecteur") VideoProjecteur videoprojecteur,
			@RequestParam("id") String idVideo, @RequestParam("date") Date date) {
		VideoProjecteur video = videoDAO.findById(idVideo).get();
		video.setDate(date);
		videoDAO.save(video);
		return "redirect:./";
	}

	// ************************Supprimer un videoproj***************************
	@GetMapping("/video/supprimer")
	public String deleteVideo(@RequestParam("id") String idVideo) {
		videoDAO.deleteById(idVideo);
		return "redirect:./";
	}

	// ***************************************************************************
	// ****************************Allouer ORDI*******************
	// ***************************************************************************

	@GetMapping("/ordi/allouer")
	public String allouerOrdi(Model model, @RequestParam("id") String idOrdi) {
		model.addAttribute("ordinateur", new Ordinateur());
		model.addAttribute("ordinateur", ordiDAO.findById(idOrdi).get());
		model.addAttribute("stagiaire", new Stagiaire());
		model.addAttribute("stagiaires", stagDAO.findAll());
		return "allouerOrdi";
	}

	@PostMapping("/ordi/allouer")
	public String allouerOrdinateur(@RequestParam("id") String idOrdi, @RequestParam("stagiaires") int idStagiaire) {
		Ordinateur ordinateur = ordiDAO.findById(idOrdi).get();
		Stagiaire s = stagDAO.findById(idStagiaire).get();
		s.setOrdinateur(ordinateur);
		stagDAO.save(s);
		return "redirect:./";
	}

}
