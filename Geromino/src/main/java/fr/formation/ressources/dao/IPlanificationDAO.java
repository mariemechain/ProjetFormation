package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Planification;

public interface IPlanificationDAO extends JpaRepository<Planification, Integer>{ 
	
//	@Query("select p from Planification p where p.projet.getId() = :idProjet")
//	public List<Planification> findByProjetId(@Param("idProjet") int idProjet);

}
