package fr.formation.projets.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.formation.ressources.model.Formateur;
import fr.formation.ressources.model.Matiere;

@Entity
@Table(name = "plannification")
public class Plannification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLA_ID")
	private int id;

	@Column(name = "PLA_MATIERE")
	private Matiere matiere;
	@Column(name = "PLA_FORMATEUR")
	private Formateur formateur;
	@Column(name = "PLA_PROJET")
	private Projet projet;

	public Plannification() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}
