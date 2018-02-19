
package fr.formation.projets.model;

import java.io.Serializable;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import fr.formation.ressources.model.Formateur;
import fr.formation.ressources.model.Matiere;

@Entity
@Table(name = "planification")
public class Planification implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLA_ID")
	private int id;

	@ManyToOne/*(fetch=FetchType.EAGER)*/
	@JoinColumn(name = "PLA_MATIER_ID")
	private Matiere matiere;
	
	@ManyToOne/*(fetch=FetchType.EAGER)*/
	@JoinColumn(name = "PLA_FORMATEUR_ID")
	private Formateur formateur;
	
//	@oneToMany
//	@JoinColumn(name = "PLA_PROJET")
//	private Projet projet;

	public Planification() {

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



}