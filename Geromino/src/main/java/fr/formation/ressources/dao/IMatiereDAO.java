package fr.formation.ressources.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.ressources.metier.Matiere;

public interface IMatiereDAO extends JpaRepository<Matiere, Integer>{

	@Query("from Matiere m left join fetch m.prerequis p where m.id = :id")
	public Matiere findById(@Param("id") int id);

}
