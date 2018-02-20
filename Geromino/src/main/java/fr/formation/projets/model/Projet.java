package fr.formation.projets.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "projet")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_ID")
	private int id;

	@Column(name = "PRO_NOM")
	private String nom;

	@Column(name = "PRO_DUREE")
	private int duree;

	@Temporal(TemporalType.DATE)
	@Column(name = "PRO_DEBUT")
	private Date dateDebut;

	@OneToMany(mappedBy = "projet", fetch = FetchType.EAGER)
	private List<Planification> planifications;

	/*=========================================== 
	 * Constructeur(s) 
	 * =========================================== */
	public Projet() {
		// ctor par defaut
	}

	/* =========================================== 
	 * Accesseurs : Getters & Setters 
	 * =========================================== */
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

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Date getDebut() {
		return dateDebut;
	}

	public void setDebut(Date debut) {
		this.dateDebut = debut;
	}

	public List<Planification> getPlanifications() {
		return planifications;
	}

	public void setPlanifications(List<Planification> plannifications) {
		this.planifications = plannifications;
	}

	/* ===========================================
	 * 	ToString 
	 * =========================================== */
	@Override
	public String toString() {
		return "Projet [id=" + id + ", nom=" + nom + ", duree=" + duree + ", dateDebut=" + dateDebut
				+ ", planifications=" + planifications + "]";
	}

}
