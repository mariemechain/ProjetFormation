package fr.formation.ressources.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.ressources.metier.Salle;

public interface ISalleDAO extends JpaRepository<Salle, String> {
	//@Query("from Salle s left join fetch s.dispo")
    public List<Salle> findAll();
}
