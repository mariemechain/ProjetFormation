package fr.formation.graphisme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

	@SuppressWarnings("deprecation")
	@GetMapping("")
	public String afficher(@RequestParam("id") int id, Model model) {
		Projet projet = daoPro.findById(id).get();

		Date date = projet.getDebut();
		List<Date> dates = new ArrayList<Date>();
		LocalDate local_date = ((java.sql.Date) date).toLocalDate();
		List<String> jours = new ArrayList<String>();
		List<Integer> duree_mois = new ArrayList<Integer>();
		List<String> mois = new ArrayList<String>();
		duree_mois.add(0);
		for (int i = 0; i < projet.getDuree(); i++) {
			String res = "";
			int res2 = 0;
			dates.add((Date) java.sql.Date.valueOf(local_date.plusDays(i)));
			switch (dates.get(i).getDay()) {
			case 0:
				res = "Dimanche";
				break;
			case 1:
				res = "Lundi";
				
				break;
			case 2:
				res = "Mardi";
				break;
			case 3:
				res = "Mercredi";
				break;
			case 4:
				res = "Jeudi";
				break;
			case 5:
				res = "Vendredi";
				break;
			case 6:
				res = "Samedi";
				break;
			}
			jours.add(res);
			switch (dates.get(i).getMonth()) {
			case 0:
				res = "Janvier";
				res2 = 31;
				break;
			case 1:
				res = "F�vrier";
				if ((date.getYear() + 1900) % 400 == 0) {
					res2 = 29;
				} else if ((date.getYear() + 1900) % 100 == 0) {
					res2 = 28;
				} else if ((date.getYear() + 1900) % 4 == 0) {
					res2 = 29;
				} else {
					res2 = 28;
				}
				break;
			case 2:
				res = "Mars";
				res2 = 31;
				break;
			case 3:
				res = "Avril";
				res2 = 30;
				break;
			case 4:
				res = "Mai";
				res2 = 31;
				break;
			case 5:
				res = "Juin";
				res2 = 30;
				break;
			case 6:
				res = "Juillet";
				res2 = 31;
				break;
			case 7:
				res = "Aout";
				res2 = 31;
				break;
			case 8:
				res = "Septembre";
				res2 = 30;
				break;
			case 9:
				res = "Octobre";
				res2 = 31;
				break;
			case 10:
				res = "Novembre";
				res2 = 30;
				break;
			case 11:
				res = "Decembre";
				res2 = 31;
				break;
			}
			mois.add(res);
			duree_mois.add(res2+duree_mois.get(i));
		}
		
		Date date_fin = dates.get(projet.getDuree() - 1);
		int moi = date.getMonth();
		if (date_fin.getMonth() == moi) {
			duree_mois.set(1, date_fin.getDate()-date.getDate());
		} else {
			duree_mois.set(1, duree_mois.get(1)-date.getDate());
			duree_mois.set(date_fin.getMonth()-date.getMonth()+1, date_fin.getDate()+duree_mois.get(date_fin.getMonth()-date.getMonth()));
		}
		
		
		List<String> matieres = new ArrayList<String>();
		List<Integer> matieres_duree = new ArrayList<Integer>();
		for(int i=0; i<projet.getPlanifications().size();i++){
			matieres.add(projet.getPlanifications().get(i).getMatiere().getTitre());
			matieres_duree.add(projet.getPlanifications().get(i).getMatiere().getDuree());
		}
		
		List<Integer> long_rawspawn = new ArrayList<Integer>();
		for (int i = 0; i<projet.getDuree();i++){
			
		}
		model.addAttribute("dates", dates);
		
		model.addAttribute("jours", jours);
		
		model.addAttribute("mois", mois);
		model.addAttribute("duree_mois", duree_mois);
		
		model.addAttribute("matieres", matieres);
		model.addAttribute("matieres_duree", matieres_duree);

		model.addAttribute("projet", projet);
		model.addAttribute("duree", projet.getDuree());
		model.addAttribute("date", projet.getDebut().getDate());

		return "afficheProjet";
	}
}
