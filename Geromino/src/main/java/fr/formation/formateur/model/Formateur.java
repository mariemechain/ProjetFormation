package fr.formation.formateur.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="formateur")
@PrimaryKeyJoinColumn(name="FOR_ID", referencedColumnName="PER_ID")
public class Formateur {
	
	@Column(name="FOR_TITRE")
	private String titre;
	
	@Column(name="FOR_PATIENCE")
	private double patience;
	
	@Column(name="FOR_DISPONIBILITE")
	private List<Date> disponibilite;
	
	@Column(name="FOR_EXPERTISES")
	@OneToMany(mappedBy="formateur")
	@JsonIgnoreProperties("formateur")
	private List<Expertise> expertises;	
	
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
		return expertises;
	}
	public void setExpertise(List<Expertise> expertise) {
		this.expertises = expertise;
	}
	
	
}
