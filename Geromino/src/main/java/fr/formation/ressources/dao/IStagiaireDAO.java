package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.formation.ressources.metier.Stagiaire;

public interface IStagiaireDAO extends JpaRepository<Stagiaire, Integer>{

}
