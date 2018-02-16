package fr.formation.ressources.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "matiere")
public class Matiere {

	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
