package fr.formation.formateur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.formateur.model.Formateur;
import fr.formation.formateur.model.Niveau;

public interface IFormateurDAO extends JpaRepository<Formateur, Integer>{
	
	@Query("select f from Formateur f left join f.expertises e where e.matiere.id =:matiere and e.niveau >=:niveau")
	public Formateur findByFilter(@Param("matiere") int matiere, @Param("niveau") Niveau niveau);
	
}
