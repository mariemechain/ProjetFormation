package fr.formation.ressources.metier;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PER_ID")
	private int id;

	@Column(name = "PER_NOM", columnDefinition = "VARCHAR(50)") // => VARCHAR(50)
	@NotEmpty
	private String nom;

	@Column(name = "PER_PRENOM")
	private String prenom;

	@Column(name = "PER_EMAIL", columnDefinition = "VARCHAR(50)") // => VARCHAR(50)
	private String email;

	@Column(name = "PER_TELEPHONE", columnDefinition = "VARCHAR(50)")
	private String telephone;

	@Column(name = "PER_DATEDENAISSANCE", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "PER_ADRESSE", columnDefinition = "VARCHAR(50)")
	private String adresse;

	@Column(name = "PER_LOGIN")
	private String login;

	@Column(name = "PER_MOTDEPASSE")
	private String motDePasse;

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return motDePasse;
	}

	public void setPassword(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}