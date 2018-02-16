package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Technicien;

public interface ITechnicienDAO  extends JpaRepository<Technicien, Integer>{ 

}
