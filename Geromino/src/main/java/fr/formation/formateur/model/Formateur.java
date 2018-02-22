package fr.formation.formateur.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "formateur")
@PrimaryKeyJoinColumn(name = "FOR_ID", referencedColumnName = "PER_ID")
public class Formateur extends Personne {

	@Column(name = "FOR_TITRE")
	private String titre;

	@Column(name = "FOR_NOM")
	private String nom;
	@Column(name = "For_PRENOM")
	private String prenom;

//	@Column(name = "FOR_PATIENCE")
//	private double patience;

	@OneToMany(mappedBy = "formateur")
	@JsonIgnoreProperties("formateur")
	private List<Disponibilite> disponibilites;

	@OneToMany(mappedBy = "formateur", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("formateur")
	private List<Expertise> expertises;

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	public List<Disponibilite> getDisponibilites() {
		return disponibilites;
	}

	public void setDisponibilites(List<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}

	public List<Expertise> getExpertises() {
		return expertises;
	}

	public void setExpertises(List<Expertise> expertises) {
		this.expertises = expertises;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
