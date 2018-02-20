package fr.formation.ressources.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.ressources.metier.Ordinateur;



public interface IOrdinateurDAO extends JpaRepository<Ordinateur, String>
{
	// @Query("from Ordinateur o left join fetch o.dispo")
	    public List<Ordinateur> findAll();
}
