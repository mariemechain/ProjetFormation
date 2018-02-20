package fr.formation.disponibilite.annexe;

import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="ordinateur")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@PrimaryKeyJoinColumn(name="ORD_ID", referencedColumnName="MAT_ID")
public class Ordinateur extends Materiel {

	@Column(name = "ORD_PROCESSEUR")
	private String processeur;
	@Column(name="ORD_RAM")
	private int ram;
	@Column(name="ORD_STOCKAGE")
	private int stockage;
	@Column(name="ORD_ACHAT", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date achat;
//	@JsonIgnoreProperties("ordinateur") 
//	@OneToMany(mappedBy= "ordinateur")
//	private List<Stagiaire> stagiaires;
	


//	public List<Stagiaire> getStagiaires() {
//		return stagiaires;
//	}
//
//	public void setStagiaires(List<Stagiaire> stagiaires) {
//		this.stagiaires = stagiaires;
//	}


	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getStockage() {
		return stockage;
	}

	public void setStockage(int stockage) {
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
	
	public Ordinateur(String processeur, int ram, int stockage, Date achat) {
		super();
		this.processeur = processeur;
		this.ram = ram;
		this.stockage = stockage;
		this.achat = achat;
	}
}
