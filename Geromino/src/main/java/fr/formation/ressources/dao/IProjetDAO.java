package fr.formation.ressources.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.ressources.metier.Projet;
import fr.formation.ressources.metier.Stagiaire;

public interface IProjetDAO extends JpaRepository<Projet, Integer>{
	
	@Query("from Projet p left join fetch p.stagiaires where p.id=:id")
    public Projet findById(@Param("id") int idProjet);

}
