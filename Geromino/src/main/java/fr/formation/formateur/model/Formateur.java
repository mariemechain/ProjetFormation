package fr.formation.formateur.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="formateur")
@PrimaryKeyJoinColumn(name="FOR_ID", referencedColumnName="PER_ID")
public class Formateur extends Personne{
	
	@Column(name="FOR_TITRE")
	private String titre;
	
	@Column(name="FOR_PATIENCE")
	private double patience;
	

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

}
