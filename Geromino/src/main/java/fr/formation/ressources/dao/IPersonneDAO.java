package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Personne;

public interface IPersonneDAO extends JpaRepository <Personne, Integer> {

	
	
	
}
