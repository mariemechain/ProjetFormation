package fr.formation.formateur.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="disponibilite")
public class Disponibilite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DIS_ID")
	private int id;
	
	@Column(name="DIS_DATEDEBUT")
	private Date date_debut;
	
	@Column(name="DIS_DATEFIN")
	private Date date_fin;
	
	@ManyToOne
	@JoinColumn(name="DIS_FORMATEUR_ID")
	@JsonIgnoreProperties("disponibilites")
	private Formateur formateur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
	
}
