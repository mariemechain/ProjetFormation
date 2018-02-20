package fr.formation.projets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Materiel;

public interface IMaterielDAO extends JpaRepository<Materiel, Integer>{

}
