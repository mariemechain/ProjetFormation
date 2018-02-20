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
		Date date = projet.getDateDebut();

		List<Date> dates = new ArrayList<Date>();
		LocalDate local_date = ((java.sql.Date) date).toLocalDate();
		for (int i = 0; i < projet.getDuree(); i++) {
			dates.add((Date) java.sql.Date.valueOf(local_date.plusDays(i)));
		}
		model.addAttribute("dates", dates);

		List<String> jours = new ArrayList<String>();
		for (int i = 0; i < projet.getDuree(); i++) {
			String res = "";
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
		}
		model.addAttribute("jours", jours);

		List<String> mois = new ArrayList<String>();
		for (int i = 0; i < projet.getDuree(); i++) {
			String res = "";
			switch (dates.get(i).getMonth()) {
			case 0:
				res = "Janvier";
				break;
			case 1:
				res = "Février";
				break;
			case 2:
				res = "Mars";
				break;
			case 3:
				res = "Avril";
				break;
			case 4:
				res = "Mai";
				break;
			case 5:
				res = "Juin";
				break;
			case 6:
				res = "Juillet";
				break;
			case 7:
				res = "Aout";
				break;
			case 8:
				res = "Septembre";
				break;
			case 9:
				res = "Octobre";
				break;
			case 10:
				res = "Novembre";
				break;
			case 11:
				res = "Decembre";
				break;

			}
			mois.add(res);
		}
		model.addAttribute("mois", mois);

		model.addAttribute("projet", projet);
		model.addAttribute("duree", projet.getDuree());
		model.addAttribute("date", projet.getDateDebut().getDate());

		return "afficheProjet";
	}
}
