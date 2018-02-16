package fr.formation.projets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projets.model.Projet;

public interface IProjetDAO extends JpaRepository<Projet, Integer>{
	
}
