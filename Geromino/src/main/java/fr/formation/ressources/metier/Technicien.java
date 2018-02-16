package fr.formation.ressources.metier;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "technicien")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Technicien extends Personne {

	public Technicien() {
		super();
	}

}
