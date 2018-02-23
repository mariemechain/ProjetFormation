
package fr.formation.ressources.metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.formation.matieres.model.Matiere;

@Entity
@Table(name = "planification")
public class Planification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLA_ID")
	private int id;
	

//	@ManyToOne /* (fetch=FetchType.EAGER) */
//	@JoinColumn(name = "PLA_MATIER_ID")
//	private Matiere matiere;
	@ManyToOne 
	@JoinColumn(name = "PLA_MATIER_ID")
	private Matiere matiere;

	@ManyToOne /* (fetch=FetchType.EAGER) */
	@JoinColumn(name = "PLA_FORMATEUR_ID")
	private Formateur formateur;

	@ManyToOne
	@JoinColumn(name="PLA_PROJET_ID")
	private Projet projet;

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

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}




}