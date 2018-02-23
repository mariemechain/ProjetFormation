package fr.formation.ressources.metier;

import java.util.*;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ordinateur")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@PrimaryKeyJoinColumn(name="ORD_ID", referencedColumnName="MAT_ID")
public class Ordinateur extends Materiel {
	


	private static final long serialVersionUID = 1L;
	
	@Column(name = "ORD_PROCESSEUR")
	@NotEmpty(message = "Veuillez indiquer le processeur")
	private String processeur;
	
	@Column(name="ORD_RAM")
	@NotNull(message = "Veuillez indiquer la quantit� de RAM")
	private Integer ram;
	
	@Column(name="ORD_STOCKAGE")
	@NotNull(message = "Veuillez indiquer la quantit� de m�moire")
	private Integer stockage;
	
	@Column(name="ORD_ACHAT", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Veuillez indiquer la date d'achat")
	private Date achat;
	
	@JsonIgnoreProperties("ordinateur") 
	@OneToMany(mappedBy= "ordinateur")
	private List<Stagiaire> stagiaires;
	
	

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getStockage() {
		return stockage;
	}

	public void setStockage(Integer stockage) {
		this.stockage = stockage;
	}

	public Date getAchat() {
		return achat;
	}

	public void setAchat(Date achat) {
		this.achat = achat;
	}

	public Ordinateur() {
		
	}
	
	public Ordinateur(String processeur, Integer ram, Integer stockage, Date achat) {
		super();
		this.processeur = processeur;
		this.ram = ram;
		this.stockage = stockage;
		this.achat = achat;
	}
	@Override
	public String toString() {
		return "Ordinateur [processeur=" + processeur + ", ram=" + ram + ", stockage=" + stockage + "]";
	}
	
}
