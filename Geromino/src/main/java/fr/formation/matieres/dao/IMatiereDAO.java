package fr.formation.matieres.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.matieres.model.*;

public interface IMatiereDAO extends JpaRepository<Matiere, Integer>{

	@Query("select matiere from Matiere matiere where matiere.titre = :titre")
	public Matiere findByTitre(@Param("titre") String titre);
	
	@Query("delete matiere from Matiere matiere where matiere.titre = :titre")
	public Matiere deleteByTitre(@Param("titre") String titre);
	
}
