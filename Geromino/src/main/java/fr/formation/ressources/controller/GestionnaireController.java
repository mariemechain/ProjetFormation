package fr.formation.ressources.controller;

import java.util.ArrayList;
import java.util.List;

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

import fr.formation.projets.dao.ITemplateDAO;
import fr.formation.ressources.dao.IContactDAO;
import fr.formation.ressources.dao.IGestionnaireDAO;
import fr.formation.ressources.dao.IPlanificationDAO;
import fr.formation.ressources.dao.IProjetDAO;
import fr.formation.ressources.dao.ISalleDAO;
import fr.formation.ressources.dao.IStagiaireDAO;
import fr.formation.ressources.dao.IVideoProjecteurDAO;
import fr.formation.ressources.metier.Contact;
import fr.formation.ressources.metier.OrdreMatiere;
import fr.formation.ressources.metier.Planification;
import fr.formation.ressources.metier.Projet;
import fr.formation.ressources.metier.Salle;
import fr.formation.ressources.metier.Stagiaire;
import fr.formation.ressources.metier.Template;

@Controller
@RequestMapping("/gestionnaire")
public class GestionnaireController {
	
	@ModelAttribute("page")
    public String page() {
        return "gestionnaire";
    }
	
	
	@Autowired
	private ISalleDAO daoSalle;
	
	@Autowired
	private IContactDAO daoContact;
	
	@Autowired
	private IVideoProjecteurDAO daoVideoProjecteur;
	
	@Autowired
	private IProjetDAO daoProjet;
	
	@Autowired
	private IStagiaireDAO daoStagiaire;
	
	@Autowired
	private IGestionnaireDAO daoGestionnaire;

	@Autowired
	private ITemplateDAO daoTemplate;

	@Autowired
	private IPlanificationDAO daoPLanification;
	
	
	
	

	@GetMapping("")
	public String gestionnaire() {
		return "gestionnaire";
	}
	
	
	//***********************************************************************************************
	//****************************SALLE**************************************************************
	//***********************************************************************************************
	
	@GetMapping("/gestionnaireSalle")
	public String listeSalle(Model model) {
		model.addAttribute("salle", daoSalle.findAll());
		return "gestionnaireSalle";
	}
	
	//************************************************** Ajouter une salle***************************
	@GetMapping("/gestionnaireAjouterSalle")
	public String ajouterSalle(Model model) {
		model.addAttribute("salle", new Salle());
		model.addAttribute("contacts", daoContact.findAll());
		model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
		return "gestionnaireAjouterSalle";
	}

	@PostMapping("/gestionnaireAjouterSalle")
	public String ajouter(@Valid @ModelAttribute("salle") Salle salle,BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("contacts", daoContact.findAll());
			model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
			return "gestionnaireAjouterSalle";		
		}

		daoSalle.save(salle);	
		return "redirect:./gestionnaireSalle";
	}
	
	//************************************************** Editer une salle***************************
	@GetMapping("/gestionnaireEditerSalle")
	public String editerSalle( @RequestParam("id") String id, Model model) {
		model.addAttribute("salle", daoSalle.findById(id).get());
		model.addAttribute("contacts", daoContact.findAll());
		model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
		return "gestionnaireAjouterSalle";
	}
	
	@PostMapping("/gestionnaireEditerSalle")
	public String editerSalle(@Valid @ModelAttribute("salle") Salle salle, BindingResult result,  @RequestParam("id") String id, Model model) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("contacts", daoContact.findAll());
			model.addAttribute("videoprojecteurs", daoVideoProjecteur.findAll());
			return "gestionnaireAjouterSalle";
		}

		daoSalle.save(salle);		
		//return "gestionnaireSalle";
		return "redirect:./gestionnaireSalle";	
	}
	
	
	//************************************************** Supprimer une salle***************************	
	
	@GetMapping("/gestionnaireSupprimerSalle")
	public String supprimerSalle(@RequestParam("id") String id) {
		daoSalle.deleteById(id);	
		return "redirect:./gestionnaireSalle";
	}
	
	
	
	//***********************************************************************************************
	//****************************PROJET*************************************************************
	//***********************************************************************************************
	
	@GetMapping("/gestionnaireProjet")
	public String listeProjet(Model model) {
		model.addAttribute("projet", daoProjet.findAll());
		return "gestionnaireProjet";
	}
	
	//************************************************** Ajouter un projet***************************
		@GetMapping("/gestionnaireAjouterProjet")
		public String ajouterProjet(Model model) {
			model.addAttribute("projet", new Projet());
			model.addAttribute("stagiaires", daoStagiaire.findAll());
			model.addAttribute("gestionnaires", daoGestionnaire.findAll());
			model.addAttribute("salles", daoSalle.findAll());
			model.addAttribute("templates", daoTemplate.findAll());
			
			return "gestionnaireAjouterProjet";
		}

		@PostMapping("/gestionnaireAjouterProjet")
		public String ajouter(@Valid@ModelAttribute("projet") Projet projet, BindingResult result, Model model, @RequestParam("idTemplate") int idTemplate) {
			if(result.hasErrors()) {
				return "gestionnaireAjouterProjet";
			
			}
			model.addAttribute("stagiaires", daoStagiaire.findAll());
			model.addAttribute("gestionnaires", daoGestionnaire.findAll());
			Template t = daoTemplate.findById(idTemplate).get();
		    List<OrdreMatiere> oms = t.getOrdreMatieres();
		    List<Planification> ps = new ArrayList<Planification>();
		    int njours = 0;
		    daoProjet.save(projet);
		    
		 
		    for (OrdreMatiere om : oms) {
		      Planification p = new Planification();
		      p.setMatiere(om.getMatiere());
		      p.setProjet(projet);
		      daoPLanification.save(p); 
		      ps.add(p);
		 
		      njours += om.getMatiere().getDuree(); 
		 
		    }
		    projet.setDuree(njours);
		    projet.setPlanifications(ps);
		    projet.setNomTemplate(t.getNom());
//			projet.setSalle(daoSalle.findById(id).get());
//			projet.setGestionnaire(daoGestionnaire.findById(idGestionnaire).get());
			daoProjet.save(projet);	
			return "redirect:./gestionnaireProjet";
		}
		
		//*********************************** Ajouter  un stagiaire à projet***************************
		@GetMapping("/gestionnaireProjetStagiaires")
		public String ajouterStagiaires(@RequestParam("id") int id, Model model) {
			model.addAttribute("projet", daoProjet.findById(id).get());
			model.addAttribute("stagiaires", daoStagiaire.findAll());
			Projet detailProjet = daoProjet.findById(id).get();
			List<Planification> planifications = detailProjet.getPlanifications();
			model.addAttribute("projetPlanifications", planifications);
			return "gestionnaireProjetStagiaires";
				}
		
		@PostMapping("/gestionnaireProjetStagiaires")
		public String ajouterStagiaires(@RequestParam("id") int id,@RequestParam("idStagiaire") int idStagiaire) {
			Projet projet = daoProjet.findById(id).get();
			projet.setId(id);
			projet.getStagiaires().add(daoStagiaire.findById(idStagiaire).get());
			Stagiaire stagiaire = daoStagiaire.findById(idStagiaire).get();
			stagiaire.setFormation(projet);
			daoStagiaire.save(stagiaire);
			daoProjet.save(projet);
			return "redirect:./gestionnaireProjetStagiaires?id="+id;
				}
		
		//*********************************Supprimer un stagiaire à projet***************************
		@GetMapping("/gestionnaireProjetStagiairesSupprimer")
		public String supprimerStagiaire(@RequestParam("id") int id, @RequestParam("idstag") int idStagiaire) {
			Projet projet = daoProjet.findById(id).get();
			projet.setId(id);
			// FAIRE UNE BOUCLE POUR SUPPRIMER UN STAGIAIRE DANS LISTE SELON INDEX
			
			List<Stagiaire> stagiaires = projet.getStagiaires();
			Stagiaire s = daoStagiaire.findById(idStagiaire).get();
			//int test = stagiaires.indexOf(s);
			
			for(int i = 0 ; i<stagiaires.size() ; i++) {
				if(stagiaires.get(i).getId() == s.getId()) {
					stagiaires.remove(i);
				}
			}
			
			
			s.setFormation(null);
			daoStagiaire.save(s);
			
			projet.setStagiaires(stagiaires);			
			daoProjet.save(projet);
			return "redirect:./gestionnaireProjetStagiaires?id="+id;
	}
		
		//************************************************** Editer un projet***************************
		@GetMapping("/gestionnaireEditerProjet")
		public String editerProjet( @RequestParam("id") int id, Model model) {
			model.addAttribute("projet", daoProjet.findById(id).get());
			model.addAttribute("stagiaires", daoStagiaire.findAll());
			model.addAttribute("gestionnaires", daoGestionnaire.findAll());
			model.addAttribute("salles", daoSalle.findAll());
			model.addAttribute("templates", daoTemplate.findAll());
			return "gestionnaireAjouterProjet";
		}
		
		@PostMapping("/gestionnaireEditerProjet")
		public String editerProjet( @Valid@ModelAttribute("projet") Projet projet,BindingResult result,  @RequestParam("id") int id, Model model, @RequestParam int idTemplate) {
			if(result.hasErrors()) {
				System.out.println(result.getAllErrors());
				model.addAttribute("stagiaires", daoStagiaire.findAll());
				model.addAttribute("gestionnaires", daoGestionnaire.findAll());
				
				return "gestionnaireAjouterSalle";
			}
			
			List<Planification> plans = daoPLanification.findAll();
			Template t = daoTemplate.findById(idTemplate).get(); 
		    for(Planification p : plans) {
		      if(p.getProjet() != null && p.getProjet().getId() == projet.getId()) {
		        daoPLanification.delete(p);
		      }
		    }
			
			
		    List<OrdreMatiere> oms = t.getOrdreMatieres();
		    List<Planification> ps = new ArrayList<Planification>();
		    int njours = 0;	    
		 
		    for (OrdreMatiere om : oms) {
		      Planification p = new Planification();
		      p.setMatiere(om.getMatiere());
		      p.setProjet(projet);
		      daoPLanification.save(p); 
		      ps.add(p);
		 
		      njours += om.getMatiere().getDuree(); 
		 
		    }

		    projet.setPlanifications(ps);
		    projet.setDuree(njours);
			
			projet.setNomTemplate(t.getNom());
			projet.setId(id);
//			projet.setSalle(daoSalle.findById(idSalle).get());
//			projet.setGestionnaire(daoGestionnaire.findById(idGestionnaire).get());
			daoProjet.save(projet);		
			//return "gestionnaireSalle";
			return "redirect:./gestionnaireProjet";	
		}
		
		
		//************************************************** Supprimer un projet***************************	
		
		@GetMapping("/gestionnaireSupprimerProjet")
		public String supprimerProjet(@RequestParam("id") int idProjet) {
			List<Planification> ps = daoPLanification.findAll();
			 
		    for(Planification p : ps) {
		      if(p.getProjet() != null && p.getProjet().getId() == idProjet) {
		        daoPLanification.delete(p);
		      }
		    }
			daoProjet.deleteById(idProjet);	
			return "redirect:./gestionnaireProjet";
		}
		
		//***********************************************************************************************
		//****************************CONTACT*************************************************************
		//***********************************************************************************************
		
		@GetMapping("/gestionnaireContact")
		public String listeContact(Model model) {
			model.addAttribute("contacts", daoContact.findAll());
			return "gestionnaireContact";
		}
		
		//************************************************** Ajouter un contact***************************
				@GetMapping("/gestionnaireAjouterContact")
				public String ajouterContact(Model model) {
					model.addAttribute("contact", new Contact());
					model.addAttribute("contacts", daoContact.findAll());
					
					return "gestionnaireAjouterContact";
				}

				@PostMapping("/gestionnaireAjouterContact")
				public String ajouterContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {
					if(result.hasErrors()) {
						model.addAttribute("contacts", daoContact.findAll());
						return "gestionnaireAjouterContact";	
					}
//					model.addAttribute("contacts", daoContact.findAll());		
					daoContact.save(contact);	
					return "redirect:./gestionnaireContact";
				}
				
				//************************************************** Editer un contact***************************
				@GetMapping("/gestionnaireEditerContact")
				public String editerContact( @RequestParam("id") int id, Model model) {
					model.addAttribute("contact", daoContact.findById(id).get());
					System.out.println(id);
					
					
					return "gestionnaireAjouterContact";
				}
				
				@PostMapping("/gestionnaireEditerContact")
				public String editerContact(@Valid @ModelAttribute("contact") Contact contact,  @RequestParam("id") int id, BindingResult result, Model model) {
					if(result.hasErrors()) {
						model.addAttribute("contact", daoContact.findById(id).get());
						return "gestionnaireAjouterContact";
					}
					model.addAttribute("contacts", daoContact.findAll());
					
					contact.setId(id);
					daoContact.save(contact);		
					//return "gestionnaireSalle";
					return "redirect:./gestionnaireContact";	
				}
				
				
				
				//************************************************** Supprimer un contact***************************	
				
				@GetMapping("/gestionnaireSupprimerContact")
				public String supprimerContact(@RequestParam("id") int id) {
					daoContact.deleteById(id);	
					return "redirect:./gestionnaireContact";
				}
				
				//***********************************************************************************************
				//****************************STAGIAIRE*************************************************************
				//***********************************************************************************************
				
				@GetMapping("/gestionnaireStagiaires")
				public String listeStagiaire(Model model) {
					model.addAttribute("stagiaires", daoStagiaire.findAll());
					return "gestionnaireStagiaires";
				}
				
				//************************************************** Ajouter un stagiaire***************************
						@GetMapping("/gestionnaireAjouterStagiaire")
						public String ajouterStagiaire(Model model) {
							model.addAttribute("stagiaire", new Stagiaire());
							model.addAttribute("stagiaires", daoStagiaire.findAll());
							
							return "gestionnaireAjouterStagiaire";
						}

						@PostMapping("/gestionnaireAjouterStagiaire")
						public String ajouterStagiaire(@Valid @ModelAttribute("stagiaire") Stagiaire stagiaire, BindingResult result, Model model) {
							if(result.hasErrors()) {
								model.addAttribute("stagiaires", daoStagiaire.findAll());
								return "gestionnaireAjouterStagiaire";	
							}
//							model.addAttribute("contacts", daoContact.findAll());		
							daoStagiaire.save(stagiaire);	
							return "redirect:./gestionnaireStagiaires";
						}
						
						//************************************************** Editer un stagiaire***************************
						@GetMapping("/gestionnaireEditerStagiaire")
						public String editerStagiaire( @RequestParam("id") int id, Model model) {
							model.addAttribute("stagiaire", daoStagiaire.findById(id).get());
							System.out.println(id);
							
							
							return "gestionnaireAjouterStagiaire";
						}
						
						@PostMapping("/gestionnaireEditerStagiaire")
						public String editerStagiaire(@Valid @ModelAttribute("stagiaire") Stagiaire stagiaire, BindingResult result,  @RequestParam("id") int id, Model model) {
							if(result.hasErrors()) {
								return "gestionnaireAjouterStagiaire";
							}
							model.addAttribute("stagiaires", daoStagiaire.findAll());
							
							stagiaire.setId(id);
							stagiaire.setOrdinateur(daoStagiaire.findById(id).get().getOrdinateur());
							daoStagiaire.save(stagiaire);		
							//return "gestionnaireSalle";
							return "redirect:./gestionnaireStagiaires";	
						}
						
						
						
						//************************************************** Supprimer un stagiaire***************************	
						
						@GetMapping("/gestionnaireSupprimerStagiaire")
						public String supprimerStagiaire(@RequestParam("id") int id) {
							daoStagiaire.deleteById(id);	
							return "redirect:./gestionnaireStagiaires";
						}
}
