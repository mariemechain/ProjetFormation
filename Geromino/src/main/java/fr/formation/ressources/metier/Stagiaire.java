package fr.formation.ressources.metier;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import fr.formation.projets.model.Projet;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="stagiaire")
@PrimaryKeyJoinColumn(name="STA_ID", referencedColumnName="PER_ID")
public class Stagiaire extends Personne{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="STA_ORD_ID")
	private Ordinateur ordinateur;
	
	@ManyToOne
	@JoinColumn(name="STA_PRO_ID")
	private Projet formation;

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}
	
	

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public Projet getFormation() {
		return formation;
	}

	public void setFormation(Projet formation) {
		this.formation = formation;
	}
	
}
