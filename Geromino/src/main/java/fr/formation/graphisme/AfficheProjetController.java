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
		int ii = 0;
		for (int i = 0; i < projet.getDuree(); i++) {
			String day=nom_day(ii, dates, date, local_date);
			jours.add(day);
			mois.add(nom_month(ii, dates, date));
			duree_mois.add(duree_month(ii, dates, date));
			switch (day) {
			case "Dimanche":
				i--;
				break;
			case "Samedi":
				i--;
				break;
			}
			ii++;
		}

		Date date_fin = dates.get(ii - 1);
		int moi = date.getMonth();

		if (date_fin.getMonth() == moi) {
			duree_mois.set(0, date_fin.getDate() - date.getDate() + 1);
		} else {
			duree_mois.set(0, duree_mois.get(1) - date.getDate() + 1);
			duree_mois.set(ii - 1, date_fin.getDate());
		}
		for (int i = 1; i < duree_mois.get(0); i++) {
			duree_mois.set(i, duree_mois.get(0));
		}
		for (int i = 1; i < duree_mois.get(ii - 1); i++) {
			duree_mois.set(ii - 1 - i, date_fin.getDate());
		}

		List<Integer> duree_mois_tot = new ArrayList<Integer>();
		int nb_mois = date_fin.getMonth() - date.getMonth() + 1;

		List<Integer> duree_mois_base = new ArrayList<Integer>();
		List<Integer> duree_mois_base_somme = new ArrayList<Integer>();
		duree_mois_base.add(duree_mois.get(0));
		duree_mois_base_somme.add(duree_mois.get(0));
		for (int i = 1; i < nb_mois; i++) {
			duree_mois_base.add(duree_month(
					((Date) java.sql.Date.valueOf(((java.sql.Date) projet.getDebut()).toLocalDate().plusMonths(i)))));
			duree_mois_base_somme.add(duree_mois_base_somme.get(i - 1) + duree_month(
					((Date) java.sql.Date.valueOf(((java.sql.Date) projet.getDebut()).toLocalDate().plusMonths(i)))));
			if (i == nb_mois - 1) {
				duree_mois_base.set(i, date_fin.getDate());
				duree_mois_base.set(i, date_fin.getDate() + duree_mois_base_somme.get(i - 1));
			}
		}

		for (int i = 0; i < duree_mois.get(0); i++) {
			duree_mois_tot.add(0);
		}

		for (int i = 1; i < nb_mois; i++) {
			for (int j = 0; j < duree_mois_base.get(i); j++) {
				duree_mois_tot
						.add(duree_mois_tot.get(duree_mois_base_somme.get(i - 1) - 1) + duree_mois_base.get(i - 1));
			}
		}

		List<String> matieres = new ArrayList<String>();
		List<Integer> matieres_duree = new ArrayList<Integer>();
		for (int i = 0; i < projet.getPlanifications().size(); i++) {
			matieres.add(projet.getPlanifications().get(i).getMatiere().getTitre());
			matieres_duree.add(projet.getPlanifications().get(i).getMatiere().getDuree());
		}

		List<Integer> long_rawspawn = new ArrayList<Integer>();
		for (int i = 0; i < projet.getDuree(); i++) {

		}

		// Ajouts de Klervi

		List<String> matierePlanning = new ArrayList<String>();
		List<Date> datesDebutMatiere = new ArrayList<Date>();
		List<Integer> matieresDureeMatiere = new ArrayList<Integer>();
		int j = 0; // indice pour nouvelle matiere (version long)
		int k = 0; // indice pour temps dans une matiere
		int m = 0; // indice pour nouvelle matiere (version court)

		matieresDureeMatiere.add(0);

		for (int i = 0; i < projet.getDuree(); i++) {
			// liste des jours de d�but des matieres, taille de la duree totale
			// du projet
			if (k == 0) {
				datesDebutMatiere.add(dates.get(i));
			} else if (jours.get(i) == "Lundi") {
				datesDebutMatiere.add(dates.get(i));
			} else {
				datesDebutMatiere.add(datesDebutMatiere.get(i - 1));
			}

			//
			if (jours.get(i) != "Samedi" && jours.get(i) != "Dimanche") {
				matieresDureeMatiere.set(m, matieresDureeMatiere.get(m) + 1);
				matierePlanning.add(matieres.get(j));
				k++;
				if (k == matieres_duree.get(j) - 1) {
					j++;
					k = 0;
					m++;
					matieresDureeMatiere.add(0);
				} else if (jours.get(i) == "Vendredi") {
					m++;
					matieresDureeMatiere.add(0);
				}
			} else {
				matierePlanning.add("");
				matieres_duree.set(j, matieres_duree.get(j) + 1);
			}
		}

		// liste des durees courtes des matieres, taille de la duree totale du
		// projet
		List<Integer> matieresDureeMatiere2 = new ArrayList<Integer>();
		j = 0;
		k = 0;
		int n = 0;
		for (int i = 0; i < projet.getDuree(); i++) {
			if (jours.get(i).equals("Samedi") || jours.get(i).equals("Dimanche")) {
				matieresDureeMatiere2.add(0);
			} else if (jours.get(i).equals("Lundi") || k == 0) {
				n++;
				matieresDureeMatiere2.add(matieresDureeMatiere.get(n - 1));
				k++;
			} else {
				matieresDureeMatiere2.add(matieresDureeMatiere.get(n - 1));
				k++;
			}
			if (k == matieres_duree.get(j) - 1) {
				j++;
				k = 0;
			}
		}

		model.addAttribute("matierePlanning", matierePlanning);
		model.addAttribute("datesDebutMatiere", datesDebutMatiere);
		model.addAttribute("matieresDureeMatiere2", matieresDureeMatiere2);

		// Fin ajouts de Klervi

		model.addAttribute("dates", dates);
		model.addAttribute("jours", jours);

		model.addAttribute("mois", mois);
		model.addAttribute("duree_mois", duree_mois);
		model.addAttribute("duree_mois_tot", duree_mois_tot);

		model.addAttribute("matieres", matieres);
		model.addAttribute("matieres_duree", matieres_duree);

		model.addAttribute("projet", projet);
		model.addAttribute("duree", ii);
		model.addAttribute("date", projet.getDebut().getDate());

		return "afficheProjet";
	}

	@SuppressWarnings("deprecation")
	private int duree_month(Date date) {
		int res2 = 0;
		switch (date.getMonth()) {
		case 0:
			res2 = 31;
			break;
		case 1:
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
			res2 = 31;
			break;
		case 3:
			res2 = 30;
			break;
		case 4:
			res2 = 31;
			break;
		case 5:
			res2 = 30;
			break;
		case 6:
			res2 = 31;
			break;
		case 7:
			res2 = 31;
			break;
		case 8:
			res2 = 30;
			break;
		case 9:
			res2 = 31;
			break;
		case 10:
			res2 = 30;
			break;
		case 11:
			res2 = 31;
			break;
		}
		return res2;
	}

	@SuppressWarnings("deprecation")
	private int duree_month(int id, List<Date> dates, Date date) {
		int res2 = 0;
		switch (dates.get(id).getMonth()) {
		case 0:
			res2 = 31;
			break;
		case 1:
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
			res2 = 31;
			break;
		case 3:
			res2 = 30;
			break;
		case 4:
			res2 = 31;
			break;
		case 5:
			res2 = 30;
			break;
		case 6:
			res2 = 31;
			break;
		case 7:
			res2 = 31;
			break;
		case 8:
			res2 = 30;
			break;
		case 9:
			res2 = 31;
			break;
		case 10:
			res2 = 30;
			break;
		case 11:
			res2 = 31;
			break;
		}
		return res2;
	}

	@SuppressWarnings("deprecation")
	private String nom_month(int id, List<Date> dates, Date date) {

		String res = "";
		switch (dates.get(id).getMonth()) {
		case 0:
			res = "Janvier";
			break;
		case 1:
			res = "F�vrier";
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
			;
			break;
		case 10:
			res = "Novembre";
			break;
		case 11:
			res = "Decembre";
			break;
		}
		return res;
	}

	@SuppressWarnings("deprecation")
	private String nom_day(int id, List<Date> dates, Date date, LocalDate local_date) {
		String res = "";
		dates.add((Date) java.sql.Date.valueOf(local_date.plusDays(id)));
		switch (dates.get(id).getDay()) {
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
		return res;
	}
}