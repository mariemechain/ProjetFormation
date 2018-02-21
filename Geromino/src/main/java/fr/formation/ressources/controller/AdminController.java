package fr.formation.ressources.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.ressources.dao.IAdminDAO;
import fr.formation.ressources.dao.IGestionnaireDAO;
import fr.formation.ressources.dao.IPersonneDAO;
import fr.formation.ressources.dao.IPersonnelDAO;
import fr.formation.ressources.dao.ITechnicienDAO;
import fr.formation.ressources.metier.Admin;
import fr.formation.ressources.metier.Gestionnaire;
import fr.formation.ressources.metier.Personnel;
import fr.formation.ressources.metier.Salle;
import fr.formation.ressources.metier.Technicien;

@Controller
public class AdminController {
	
	
	@Autowired
	private IPersonneDAO daoPersonne;
	@Autowired
	private IGestionnaireDAO daoGestionnaire;
	
	@Autowired
	private ITechnicienDAO daoTechnicien;
	

	@Autowired
	private IAdminDAO daoAdmin;
	
	@Autowired
	private IPersonnelDAO daoPersonnel;
	
	@GetMapping("/admin")
	public String listeContact(Model model) {
		model.addAttribute("personnels", daoPersonnel.findAll());
		return "personnels";
	}
	
	
	@ModelAttribute("page")
    public String page() {
        return "admin";
    }
	
	
	@GetMapping("/adminAjouterPersonnel")
	public String formulaireAjout(Model model) {
		model.addAttribute("personnel", new Personnel());
		return "ajouterPersonnel";
	}
	
	//************************************************** Ajouter un personnel***************************
	
	@PostMapping("/adminAjouterPersonnel")
	public String ajouterPersonnel(@Valid @ModelAttribute("personnel") Personnel personnel, BindingResult result, @RequestParam("personnels") String type) {
		
		if (result.hasErrors()) {
			return "ajouterPersonnel";
		}	
		
		
		if(type.equals("Gestionnaire")){
			Gestionnaire gestionnaire =new Gestionnaire();
			gestionnaire.setNom(personnel.getNom());
			gestionnaire.setPrenom(personnel.getPrenom());
			gestionnaire.setAdresse(personnel.getAdresse());
			gestionnaire.setDate(personnel.getDate());
			gestionnaire.setEmail(personnel.getEmail());
			gestionnaire.setLogin(personnel.getLogin());
			gestionnaire.setMotDePasse(personnel.getMotDePasse());
			gestionnaire.setTelephone(personnel.getTelephone());
			daoGestionnaire.save(gestionnaire);
		}
		if(type.equals("Technicien")){
			Technicien technicien = new Technicien();
			technicien.setNom(personnel.getNom());
			technicien.setPrenom(personnel.getPrenom());
			technicien.setAdresse(personnel.getAdresse());
			technicien.setDate(personnel.getDate());
			technicien.setEmail(personnel.getEmail());
			technicien.setLogin(personnel.getLogin());
			technicien.setMotDePasse(personnel.getMotDePasse());
			technicien.setTelephone(personnel.getTelephone());
			daoTechnicien.save(technicien);
//			
//			technicien.setNom(personne.getNom());
//			daoTechnicien.save(technicien);
		}
		if(type.equals("Formateur")){
//			Formateur formateur = new Formateur();
//			formateur.setNom(personnel.getNom());
//			formateur.setPrenom(personnel.getPrenom());
//			formateur.setAdresse(personnel.getAdresse());
//			formateur.setDate(personnel.getDate());
//			formateur.setEmail(personnel.getEmail());
//			formateur.setLogin(personnel.getLogin());
//			formateur.setMotDePasse(personnel.getMotDePasse());
//			formateur.setTelephone(personnel.getTelephone());
//			daoFormateur.save(formateur);
			

		}
		if(type.equals("Admin")){
			Admin admin = new Admin();
			admin.setNom(personnel.getNom());
			admin.setPrenom(personnel.getPrenom());
			admin.setAdresse(personnel.getAdresse());
			admin.setDate(personnel.getDate());
			admin.setEmail(personnel.getEmail());
			admin.setLogin(personnel.getLogin());
			admin.setMotDePasse(personnel.getMotDePasse());
			admin.setTelephone(personnel.getTelephone());
			daoAdmin.save(admin);
//			
//			technicien.setNom(personne.getNom());
//			daoTechnicien.save(technicien);
		}

		
		
		return "redirect:./admin";
	}
	
	//************************************************** Editer un Personnel***************************
	@GetMapping("/adminEditerPersonnel")
	public String editerPersonnel( @RequestParam("id") int id, Model model) {
		model.addAttribute("personnel", daoPersonnel.findById(id).get());
		
		return "ajouterPersonnel";
	}
	
	@PostMapping("/adminEditerPersonnel")
	public String editerPersonnel(@Valid @ModelAttribute("personnel") Personnel personnel, BindingResult result,  @RequestParam("id") int id, Model model) {
		
		if (result.hasErrors()) {
			return "ajouterPersonnel";
		}
		
		Personnel pnl= daoPersonnel.findById(id).get();
		pnl.setNom(personnel.getNom());
		pnl.setPrenom(personnel.getPrenom());
		pnl.setAdresse(personnel.getAdresse());
		pnl.setDate(personnel.getDate());
		pnl.setEmail(personnel.getEmail());
		pnl.setLogin(personnel.getLogin());
		pnl.setMotDePasse(personnel.getMotDePasse());
		pnl.setTelephone(personnel.getTelephone());
//		if(daoPersonnel.findById(id).get().getType().equals("Formateur")) {
//			pnl.setTitre(personnel.getTitre());
//		}
		
		daoPersonnel.save(pnl);
		
		return "redirect:./admin";	
	}
	
	
	//************************************************** Supprimer un personnel***************************
	@GetMapping("/adminSupprimerPersonnel")
	public String supprimerPersonnel(@RequestParam("id") int id) {
		
		daoPersonnel.delete(daoPersonnel.findById(id).get());	
		return "redirect:./admin";
	}
}
