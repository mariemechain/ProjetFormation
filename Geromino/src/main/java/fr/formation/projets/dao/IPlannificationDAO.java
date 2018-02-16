package fr.formation.projets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projets.model.Plannification;

public interface IPlannificationDAO extends JpaRepository<Plannification, Integer>{

}
