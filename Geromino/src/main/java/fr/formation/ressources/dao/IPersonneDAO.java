package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.ressources.metier.Personne;

public interface IPersonneDAO extends JpaRepository <Personne, Integer> {

	
	
	@Query("select p from Personne p where p.login=:login and p.motDePasse =:motDePasse")
    public Personne auth(@Param("login") String login,  @Param("motDePasse") String motDePasse);
	
	
	
}
