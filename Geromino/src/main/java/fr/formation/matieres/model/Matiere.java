package fr.formation.matieres.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@NotEmpty(message="le titre de la matiere ne peut pas etre nul")
	private String titre;
	
	
	@Column(name="MAT_DUREE")
	@NotEmpty(message="la duree de la matiere ne peut pas etre nul")
	@Positive(message="la duree de la matiere doit etre une valeur positive")
	private int duree;
	
	@Column(name="MAT_OBJECTIF")
	private String objectif;
	
	@Column(name="MAT_CONTENU")
	private String contenu;
	
//	@Column(name="MAT_PREREQUIS")
//	private List<Matiere> prerequis;
//	
	
	//Getter et Setter de tous les attributs
	public String getTitre() {
		return titre;
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
	public String getObjectifs() {
		return objectif;
	}
	public void setObjectifs(String objectif) {
		this.objectif = objectif;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
//	public List<Matiere> getPrerequis() {
//		return prerequis;
//	}
//	public void setPrerequis(List<Matiere> prerequis) {
//		this.prerequis = prerequis;
//	}
	
//	@Override
//	public String toString() {
//		return "Matiere [titre=" + titre + ", duree=" + duree + ", objectif=" + objectif + ", contenu=" + contenu
//				+ ", prerequis=" + prerequis + "]";
//	}
	
	
}
