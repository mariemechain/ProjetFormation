
package fr.formation.projets.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.engine.internal.Cascade;


@Entity
@Table(name="template")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Template implements Serializable{
	
	/*
	 * Attributs
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TEM_ID")
	private int id;
	
	@Column(name="TEM_NOM")
	@NotEmpty(message = "Le nom du cursus est obligatoire")
	private String nom;
	
	@OneToMany(mappedBy="template", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("ordre")
    private List<OrdreMatiere> ordreMatieres;

	
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
	

	public List<OrdreMatiere> getOrdreMatieres() {
		return ordreMatieres;
	}

	public void setOrdreMatieres(List<OrdreMatiere> ordreMatieres) {
		this.ordreMatieres = ordreMatieres;
	}

	public String toString() {
		return "Template [id=" + id + ", nom=" + nom + " ordreMatieres=" + ordreMatieres + "]";
	}
}
