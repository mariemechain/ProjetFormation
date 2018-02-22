package fr.formation.ressources.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.ressources.metier.Ordinateur;
import fr.formation.ressources.metier.Projet;



public interface IOrdinateurDAO extends JpaRepository<Ordinateur, String>
{
	 @Query("from Ordinateur o left join fetch o.dispo")
	    public List<Ordinateur> findAll();
	
	@Query("from Ordinateur o left join fetch o.dispo s where o.id=:id")
    public Optional<Ordinateur> findById(@Param("id") String idOrdinateur);
}
