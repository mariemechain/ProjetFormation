package fr.formation.projets.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import fr.formation.ressources.metier.Gestionnaire;
import fr.formation.ressources.metier.Materiel;
import fr.formation.ressources.metier.Salle;
import fr.formation.ressources.metier.Stagiaire;

@Entity
@Table(name="projet")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Projet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRO_ID") private int id;

	@Column(name="PRO_NOM") private String nom; 
	
	@Column(name="PRO_DUREE") private int duree; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="PRO_DEBUT") private Date dateDebut; 
	
	@OneToOne
	@JoinColumn(name="PRO_SALLE_ID") private Salle salle;

	@ManyToOne 
	@JoinColumn(name="PRO_GESTIONNAIRE_ID") 
	private Gestionnaire gestionnaire; 

	@OneToMany(mappedBy="projet", fetch=FetchType.EAGER) 
	private List<Planification> planifications;
	
	@ManyToMany//(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name="participation", 
			joinColumns = @JoinColumn(name="PAR_PROJET_ID", referencedColumnName="PRO_ID"),
			inverseJoinColumns = @JoinColumn(name="PAR_STAGIAIRE_ID", referencedColumnName="STA_ID")
	) private List<Stagiaire> stagiaires; 
	
	@ManyToMany//(fetch=FetchType.EAGER) 
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
		name="reservation", 
		joinColumns = @JoinColumn(name="RES_PROJET_ID", referencedColumnName="PRO_ID"),
		inverseJoinColumns = @JoinColumn(name="RES_MATERIEL_ID", referencedColumnName="MAT_ID")
	) private List<Materiel> materiels; 
	
	/* ===========================================
	 * 	Constructeur(s)
	 * =========================================== */
	public Projet() {
		// ctor par defaut
	}

	/* ===========================================
	 * 	Accesseurs : Getters & Setters
	 * =========================================== */
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }

	public int getDuree() { return duree; }
	public void setDuree(int duree) { this.duree = duree; }

	public Date getDebut() { return dateDebut; }
	public void setDebut(Date debut) { this.dateDebut = debut; }

	public Salle getSalle() { return salle; }
	public void setSalle(Salle salle) { this.salle = salle; }
	
	public Gestionnaire getGestionnaire() { return gestionnaire; }
	public void setGestionnaire(Gestionnaire gestionnaire) { this.gestionnaire = gestionnaire; }

	public List<Planification> getPlanifications() { return planifications; }
	public void setPlanifications(List<Planification> plannifications) { this.planifications = plannifications; }

	public List<Stagiaire> getStagiaires() { return stagiaires; }
	public void setStagiaires(List<Stagiaire> stagiaires) { this.stagiaires = stagiaires; }

	public List<Materiel> getMateriels() { return materiels; }
	public void setMateriels(List<Materiel> materiels) { this.materiels = materiels; }

	/* ===========================================
	 * 	ToString 
	 * =========================================== */
	public String toString() {
		return "Projet [id=" + id + ", duree=" + duree + ", salle=" + salle + ", gestionnaire=" + gestionnaire
				+ ", dateDebut=" + dateDebut + ", planifications=" + planifications + ", stagiaires=" + stagiaires
				+ ", materiels=" + materiels + "]";
	}

	
}
