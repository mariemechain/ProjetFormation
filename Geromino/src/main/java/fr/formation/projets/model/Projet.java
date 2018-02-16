package fr.formation.projets.model;

import java.util.Date;
import java.util.List;

import fr.formation.ressources.model.Gestionnaire;
import fr.formation.ressources.model.Materiel;
import fr.formation.ressources.model.Salle;
import fr.formation.ressources.model.Stagiaire;

public class Projet {
	private int duree; 
	private Salle salle;
	private Stagiaire stagiaire; 
	private Gestionnaire gestionnaire; 
	private Date dateDebut; 
	private Materiel materiel; 
	private List<Plannification> plannifications;
	
	
	/* ===========================================
	 * 	Constructeur(s)
	 * =========================================== */
	public Projet() {
		// ctor par d�faut
	}

	/* ===========================================
	 * 	Accesseurs : Getters & Setters
	 * =========================================== */
	public int getDuree() { return duree; }
	public void setDuree(int duree) { this.duree = duree; }

	public Salle getSalle() { return salle; }
	public void setSalle(Salle salle) { this.salle = salle; }

	public Stagiaire getStagiaire() { return stagiaire; }
	public void setStagiaire(Stagiaire stagiaire) { this.stagiaire = stagiaire; }

	public Gestionnaire getGestionnaire() { return gestionnaire; }
	public void setGestionnaire(Gestionnaire gestionnaire) { this.gestionnaire = gestionnaire; }

	public Date getDateDebut() { return dateDebut; }
	public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }

	public Materiel getMateriel() { return materiel; }
	public void setMateriel(Materiel materiel) { this.materiel = materiel; }

	public List<Plannification> getPlannifications() { return plannifications; }
	public void setPlannifications(List<Plannification> plannifications) { this.plannifications = plannifications; }

	/* ===========================================
	 * 	ToString 
	 * =========================================== */
	@Override
	public String toString() {
		return "Projet [duree=" + duree + ", salle=" + salle + ", stagiaire=" + stagiaire + ", gestionnaire="
				+ gestionnaire + ", dateDebut=" + dateDebut + ", materiel=" + materiel + ", plannifications="
				+ plannifications + "]";
	} 
	
}
