package fr.formation.ressources.metier;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import fr.formation.projets.model.Projet;

@Entity
@Table(name="gestionnaire")
@PrimaryKeyJoinColumn(name="GES_ID", referencedColumnName="PER_ID")
public class Gestionnaire extends Personne{
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="gestionnaire")
	private List<Projet> projets; 
	
	public Gestionnaire() {
		super();
	}

}
