package fr.formation.projets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projets.model.Planification;

public interface IPlanificationDAO extends JpaRepository<Planification, Integer>{

}
