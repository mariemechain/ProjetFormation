package fr.formation.projets.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.projets.model.OrdreMatiere;

public interface IOrdreMatiereDAO extends JpaRepository<OrdreMatiere, Integer> {
	
	@Query("from OrdreMatiere m left join fetch m.template t where t.id =:id")
	public List<OrdreMatiere> findByTemplateId(@Param("id") int id);

}
