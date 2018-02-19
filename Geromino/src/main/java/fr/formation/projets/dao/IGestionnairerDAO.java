package fr.formation.projets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Gestionnaire;

public interface IGestionnairerDAO extends JpaRepository<Gestionnaire, Integer>{

}
