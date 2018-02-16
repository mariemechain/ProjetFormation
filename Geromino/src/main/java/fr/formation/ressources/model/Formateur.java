package fr.formation.ressources.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="formateur")
public class Formateur {
	
	@Column(name="FOR_NOM")
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Formateur " + nom ;
	}
	
	
	
	
	

}
