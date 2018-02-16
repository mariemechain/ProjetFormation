package fr.formation.ressources.metier;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="videoprojecteur")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class VideoProjecteur extends Materiel {

	
}
