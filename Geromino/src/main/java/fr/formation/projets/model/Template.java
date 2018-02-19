
// Classe créée par Christophe

package fr.formation.projets.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fr.formation.ressources.model.Matiere;

@Entity
@Table(name="template")
public class Template implements Serializable{
	
	/*
	 * Attributs
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TEM_ID")
	private int id;
	
	@Column(name="TEM_NOM")
	private String nom;
	

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="contenu",
		joinColumns=@JoinColumn(name="CON_TEMPLATE_ID", referencedColumnName="TEM_ID"),
		inverseJoinColumns=@JoinColumn(name="CON_MATIERE_ID", referencedColumnName="MAT_ID")
	)
	private List<Matiere> matieres;
	
	/*
	 * Getters et setters
	 */
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public List<Matiere> getMatieres() {
		return matieres;
	}
	
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public String toString() {
		return "Template [id=" + id + ", nom=" + nom + "matieres=" + matieres + "]";
	}
}
