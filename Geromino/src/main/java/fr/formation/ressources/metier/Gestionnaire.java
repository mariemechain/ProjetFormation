package fr.formation.ressources.metier;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="gestionnaire")
@PrimaryKeyJoinColumn(name="GES_ID", referencedColumnName="PER_ID")
public class Gestionnaire extends Personne{
	
	private static final long serialVersionUID = 1L;
	
	public Gestionnaire() {
		super();
	}

}
