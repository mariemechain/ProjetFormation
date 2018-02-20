package fr.formation.ressources.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "personnel")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "PNL_ID", referencedColumnName = "PER_ID")
public class Personnel extends Personne {
	
	@Column(name = "PNL_LOGIN")
	@NotEmpty(message = "Veuillez indiquer un login")
	private String login;

	@Column(name = "PNL_MOTDEPASSE")
	@NotEmpty(message = "Veuillez indiquer un mot de passe")
	private String motDePasse;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getType() {
		return "Personnel";
	}

}
