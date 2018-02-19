package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Projet;

public interface IProjetDAO extends JpaRepository<Projet, Integer>{

}
