package fr.formation.projets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Salle;


public interface ISalleDAO extends JpaRepository<Salle, String>{

}
