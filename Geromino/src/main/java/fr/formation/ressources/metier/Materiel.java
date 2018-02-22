package fr.formation.ressources.metier;


import java.io.Serializable;
import java.util.*;


import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "materiel")
@Inheritance(strategy=InheritanceType.JOINED)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Materiel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "MAT_ID")
	@NotEmpty(message = "Veuillez indiquer l''ID")
	private String id;
	
	@Column(name = "MAT_COUT", columnDefinition = "DOUBLE")
	@NotNull(message = "Veuillez indiquer le prix")
	private Double cout;
	
	@Column(name = "MAT_ETAT", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@ManyToMany(mappedBy = "materiels")
	private List<Projet> dispo;
	
	
	// Constructeur par defaut	
	public Materiel() {
		super();
	}


	//GETTERS ET SETTERS des attributs
	
	public List<Projet> getDispo() {
		return dispo;
	}


	public void setDispo(List<Projet> dispo) {
		this.dispo = dispo;
	}
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Double getCout() {
		return cout;
	}



	public void setCout(Double cout) {
		this.cout = cout;
	}
	




public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	//	public List<Projet> getDispo() {
//		return dispo;
//	}
//
//
//
//	public void setDispo(List<Projet> dispo) {
//		this.dispo = dispo;
//	}
//
//
//
	@Override
	public String toString() {
		return "Materiel [id = " + id + " - cout = " + cout +"]";
	}

	
	
	
}
	
