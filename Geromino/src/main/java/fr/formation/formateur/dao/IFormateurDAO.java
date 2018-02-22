package fr.formation.formateur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.formateur.model.Formateur;
import fr.formation.formateur.model.Niveau;

public interface IFormateurDAO extends JpaRepository<Formateur, Integer>{
	
	//Requête de filtre : trouver les formateurs selon des compétences et des niveaux
	
//	@Query("select distinct f from Formateur f left join f.expertises e where e.matiere.id =:matiere and e.niveau >=:niveau")
	@Query("select distinct f from Formateur f left join f.expertises e where e.matiere.id =:matiere")
	public List<Formateur> findByFilter(@Param("matiere") int matiere);
	

	
}
