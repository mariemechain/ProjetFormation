package fr.formation.projets.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.projets.model.OrdreMatiere;

public interface IOrdreMatiereDAO extends JpaRepository<OrdreMatiere, Integer> {
	
	@Query("from OrdreMatiere o left join fetch o.template t where t.id =:id")
	public List<OrdreMatiere> findByTemplateId(@Param("id") int id);
	
	
	@Transactional
	@Modifying
	@Query("delete from OrdreMatiere o where o.template.id =:id")
	public void deleteByTemplateId(@Param("id") int id);
	
	@Query("select distinct o from OrdreMatiere o left join fetch o.matiere m left join fetch m.prerequis p where o.template.id =:id order by o.ordre")
	public List<OrdreMatiere> findAllByTemplateId(@Param("id") int id);

}
