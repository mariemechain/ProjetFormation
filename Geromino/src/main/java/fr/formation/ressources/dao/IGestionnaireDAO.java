package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Gestionnaire;

public interface IGestionnaireDAO extends JpaRepository<Gestionnaire, Integer> {

}
