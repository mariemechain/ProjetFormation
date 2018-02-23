package fr.formation.ressources.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.ressources.metier.OrdreMatiere;

public interface IOrdreMatiereDAO extends JpaRepository<OrdreMatiere, Integer> {
	
	@Query("from OrdreMatiere o left join fetch o.template t where t.id =:id")
	public List<OrdreMatiere> findByTemplateId(@Param("id") int id);
	
	
	@Transactional
	@Modifying
	@Query("delete from OrdreMatiere o where o.template.id =:id")
	public void deleteByTemplateId(@Param("id") int id);

}
