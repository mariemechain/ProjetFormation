package fr.formation.ressources.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="contact")
@PrimaryKeyJoinColumn(name="CON_ID", referencedColumnName="PER_ID")
public class Contact extends Personne {
	
	@Column
	@OneToMany(mappedBy="contact")
	private List<Salle> salles;

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}
	
	

}
