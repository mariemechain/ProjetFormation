package fr.formation.ressources.metier;

import java.util.*;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
