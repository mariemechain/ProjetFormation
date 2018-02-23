package fr.formation.formateur.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="matiere")
public class Matiere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MAT_ID")
	private int id;
	
	@Column(name="MAT_TITRE")
	private String titre;
	
	@OneToMany(mappedBy="matiere")
	@JsonIgnoreProperties("matiere")
	private List<Expertise> expertises;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Expertise> getExpertises() {
		return expertises;
	}

	public void setExpertises(List<Expertise> expertises) {
		this.expertises = expertises;
	}
	
	
	
}