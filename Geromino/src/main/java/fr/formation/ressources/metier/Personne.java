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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

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
	@NotEmpty(message = "Veuillez indiquer le nom")
	private String nom;

	@Column(name = "PER_PRENOM")
	@NotEmpty(message = "Veuillez indiquer le pr�nom")
	private String prenom;

	@Column(name = "PER_EMAIL", columnDefinition = "VARCHAR(50)") // => VARCHAR(50)
	@NotEmpty(message = "Veuillez indiquer l'email")
	private String email;

	@Column(name = "PER_TELEPHONE", columnDefinition = "VARCHAR(50)")
	@NotEmpty(message = "Veuillez indiquer le num�ro")
	private String telephone;

	@Column(name = "PER_DATEDENAISSANCE", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Veuillez indiquer la date de naissance")
	private Date date;

	@Column(name = "PER_ADRESSE", columnDefinition = "VARCHAR(50)")
	@NotEmpty(message = "Veuillez indiquer l'adresse")
	private String adresse;

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