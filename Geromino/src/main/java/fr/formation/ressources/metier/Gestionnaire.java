package fr.formation.ressources.metier;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="gestionnaire")
@PrimaryKeyJoinColumn(name="GES_ID", referencedColumnName="PNL_ID")
public class Gestionnaire extends Personnel{
	
	@OneToMany(mappedBy="gestionnaire")
	private List<Projet> projets;
	
	
	private static final long serialVersionUID = 1L;
	
	public Gestionnaire() {
		super();
	}
	
	@Override
	public String getType() {
		return "Gestionnaire";
	}

}
