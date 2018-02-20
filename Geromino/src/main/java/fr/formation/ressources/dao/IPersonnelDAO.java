package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import fr.formation.ressources.metier.Personnel;

public interface IPersonnelDAO extends JpaRepository <Personnel, Integer> {

	
	
	@Query("select p from Personnel p where p.login=:login and p.motDePasse =:motDePasse")
    public Personnel auth(@Param("login") String login,  @Param("motDePasse") String motDePasse);
	
	
	
}
