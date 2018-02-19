package fr.formation.ressources.metier;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="salle")
@PrimaryKeyJoinColumn(name="SAL_ID", referencedColumnName="MAT_ID")	
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Salle extends Materiel{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="SAL_PLACES")
	@NotNull(message = "Veuillez indiquer le nombre de places")
	private int places;
	
	@Column(name="SAL_ADRESSE")
	@NotEmpty(message = "Veuillez indiquer l'adresse")
	private String adresse;
	
	
	@ManyToOne
	@JoinColumn(name="SAL_CONTACT_ID")
	private Personne contact;


	@OneToOne
	@JoinColumn(name="SAL_VIDEOPROJECTEUR_ID")
	private VideoProjecteur videoprojecteur;

	
	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Personne getContact() {
		return contact;
	}

	public void setContact(Personne contact) {
		this.contact = contact;
	}

	public VideoProjecteur getVideoprojecteur() {
		return videoprojecteur;
	}

	public void setVideoprojecteur(VideoProjecteur videoprojecteur) {
		this.videoprojecteur = videoprojecteur;
	}
}
