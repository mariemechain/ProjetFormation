package fr.formation.matieres.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;


@Entity
@Table(name="matiere")
public class Matiere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MAT_ID")
	private int id;
	
	@Column(name="MAT_TITRE")
	//@NotEmpty(message="le titre de la matiere ne peut pas etre nul")
	private String titre;
	
	
	@Column(name="MAT_DUREE")
	//@NotEmpty(message="la duree de la matiere ne peut pas etre nul")
	//@Positive(message="la duree de la matiere doit etre une valeur positive")
	private int duree;
	
	@Column(name="MAT_OBJECTIF")
	private String objectif;
	
	@Column(name="MAT_CONTENU")
	private String contenu;
	
	@ManyToMany
	@JoinTable(name="prerequis",
			joinColumns=@JoinColumn(name="PRE_PREREQUIS_ID", referencedColumnName="MAT_ID"),
			inverseJoinColumns=@JoinColumn(name="PRE_MAT_ID", referencedColumnName="MAT_ID"))
	private List<Matiere> matieres;

	//Getter et Setter de tous les attributs
	
	public String getTitre() {
		return titre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", titre=" + titre + ", duree=" + duree + ", objectif=" + objectif + ", contenu="
				+ contenu +"]";
	}
	
}
