package fr.formation.ressources.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Disponibilite;


public interface IDisponibiliteDAO extends JpaRepository< Disponibilite, Integer>{

}
