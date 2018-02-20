package fr.formation.ressources.metier;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name="ADM_ID", referencedColumnName="PNL_ID")
public class Admin extends Personnel {
	private static final long serialVersionUID = 1L;

	@Override
	public String getType() {
		return "Administrateur";
	}
}
