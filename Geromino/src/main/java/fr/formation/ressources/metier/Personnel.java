package fr.formation.ressources.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "personnel")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "PNL_ID", referencedColumnName = "PER_ID")
public class Personnel extends Personne {
	
	@Column(name = "PNL_LOGIN")
	private String login;

	@Column(name = "PNL_MOTDEPASSE")
	private String motDePasse;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return motDePasse;
	}

	public void setPassword(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getType() {
		return "Personnel";
	}

}
