package fr.formation.formateur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.formateur.model.Disponibilite;


public interface IDisponibiliteDAO extends JpaRepository< Disponibilite, Integer>{

	//Requête de read : trouver la liste des disponibilités à partir d'un id formateur
	@Query("select d from Disponibilite d left join fetch d.formateur where d.formateur.id =:id")
	public List<Disponibilite> findByIdFetch(@Param("id") int id);
	
	
}
