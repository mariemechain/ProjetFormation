package fr.formation.ressources.metier;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import fr.formation.matieres.model.Matiere;




@Entity
@Table(name="ordrematiere")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OrdreMatiere {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORD_ID")
	private int id;
	
	@Column(name="ORD_ORDRE")
	private int ordre;

	@ManyToOne
	@JoinColumn(name="ORD_MATIERE_ID")
	private Matiere matiere;

	@ManyToOne
	@JoinColumn(name="ORD_TEMPLATE_ID")
	private Template template;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public String toString() {
		return "OrdreMatiere [id=" + id + ", ordre=" + ordre + ", matiere=" + matiere + "]";
	}
	
}
