package fr.formation.formateur.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.formation.test.Matiere;

@Entity
@Table(name="expertise")
public class Expertise {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EXP_ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="EXP_FORMATEUR_ID")
	@JsonIgnoreProperties("expertises")
	private Formateur formateur;
	
	@ManyToOne
	@JoinColumn(name="EXP_MATIERE_ID")
	@JsonIgnoreProperties("expertises")
	private Matiere matiere;
	
	@Column(name="EXP_NIVEAU")
	private Niveau niveau;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
	
}
