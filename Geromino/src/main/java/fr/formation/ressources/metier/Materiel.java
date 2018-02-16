package fr.formation.ressources.metier;

import java.sql.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

@Entity
@Table(name = "materiel")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Materiel {

	@Id
	@Column(name = "MAT_ID")
	private String id;
	@Column(name = "MAT_COUT", columnDefinition = "INTEGER")
	private int cout;
	@Column(name = "MAT_ETAT", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToMany(mappedBy = "projets")
	private List<Projet> dispo;
	
	
	// Constructeur par defaut	
	public Materiel() {
		super();
	}


	//GETTERS ET SETTERS des attributs
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getCout() {
		return cout;
	}



	public void setCout(int cout) {
		this.cout = cout;
	}



	public List<Projet> getDispo() {
		return dispo;
	}



	public void setDispo(List<Projet> dispo) {
		this.dispo = dispo;
	}



	@Override
	public String toString() {
		return "Materiel [id = " + id + " - cout = " + cout + " - dispo = " + dispo + "]";
	}

	
	
	
}
	
