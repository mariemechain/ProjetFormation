package fr.formation.ressources.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.ressources.metier.Ordinateur;
import fr.formation.ressources.metier.Stagiaire;

public interface IStagiaireDAO extends JpaRepository<Stagiaire, Integer>{
	@Query("from Stagiaire s left join fetch s.formation")
    public List<Stagiaire> findAll();
}
