package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Ordinateur;



public interface IOrdinateurDAO extends JpaRepository<Ordinateur, String>
{
	
}
