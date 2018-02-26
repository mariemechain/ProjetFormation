package fr.formation.ressources.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.ressources.metier.Projet;

public interface IProjetDAO extends JpaRepository<Projet, Integer>{
	
	@Query("from Projet p left join fetch p.stagiaires where p.id=:id")
    public Optional<Projet> findById(@Param("id") int idProjet);

}
