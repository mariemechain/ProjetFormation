package fr.formation.ressources.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="salle")
@PrimaryKeyJoinColumn(name="SAL_ID", referencedColumnName="MAT_ID")	
public class Salle extends Materiel{
	
	@Column(name="SAL_PLACES")
	private int places;
	
	@Column(name="SAL_ADRESSE")
	private String adresse;
	
	@Column(name="SAL_CONTACT")
	@ManyToOne
	@JoinColumn(name="SAL_CONTACT_ID")
	private Personne contact;


	@Column(name="SAL_VIDEOPROJECTEUR")
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
