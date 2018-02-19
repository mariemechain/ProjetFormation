package fr.formation.projets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.model.Matiere;

public interface IMatiereDAO extends JpaRepository<Matiere, Integer>{

}
