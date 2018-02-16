package fr.formation.formateur.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Formateur {
	private String titre;
	private double patience;
	private List<Date> disponibilite;
	private List<Expertise> expertise;
	
	
	
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
	public List<Date> getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(List<Date> disponibilite) {
		this.disponibilite = disponibilite;
	}
	public List<Expertise> getExpertise() {
		return expertise;
	}
	public void setExpertise(List<Expertise> expertise) {
		this.expertise = expertise;
	}
	
	
}
