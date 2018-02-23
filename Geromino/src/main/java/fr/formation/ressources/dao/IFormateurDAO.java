package fr.formation.ressources.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.ressources.metier.Formateur;
import fr.formation.ressources.metier.Niveau;

public interface IFormateurDAO extends JpaRepository<Formateur, Integer>{
	
	//Requête de filtre : trouver les formateurs selon des compétences et des niveaux
	
//	@Query("select distinct f from Formateur f left join f.expertises e where e.matiere.id =:matiere and e.niveau >=:niveau")
//	public List<Formateur> findByFilter(@Param("matiere") int matiere, @Param("niveau") Niveau niveau);
	
	@Query("select distinct f from Formateur f left join f.expertises e where e.matiere.id =:matiere")
	public List<Formateur> findByFilter(@Param("matiere") int matiere);
	
	//Requête de connexion : trouver un formateur selon un login et un mot de passe
	
	@Query("select f from Formateur f left join fetch f.disponibilites where f.login =:login and f.motDePasse =:pwd")
	public Formateur findByAuthentification(@Param("login") String login, @Param("pwd") String pwd);
	
	
	
}
