package fr.formation.formateur.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Formateur {
	private String titre;
	private double patience;
	private List<Date> disponibilite;
	private Expertise expertise;
	
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public double getPatience() {
		return patience;
	}
	public void setPatience(double patience) {
		this.patience = patience;
	}
	public Expertise getExpertise() {
		return expertise;
	}
	public void setExpertise(Expertise expertise) {
		this.expertise = expertise;
	}
	public List<Date> getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(List<Date> disponibilite) {
		this.disponibilite = disponibilite;
	}
	
	
}
