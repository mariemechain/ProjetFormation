package fr.formation.ressources.metier;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "technicien")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@PrimaryKeyJoinColumn(name = "TEC_ID", referencedColumnName = "PNL_ID")
public class Technicien extends Personnel {

	public Technicien() {
		super();
	}
	
	@Override
	public String getType() {
		return "Technicien";
	}

}
