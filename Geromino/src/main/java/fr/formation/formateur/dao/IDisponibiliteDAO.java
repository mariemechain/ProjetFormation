package fr.formation.formateur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.formateur.model.Disponibilite;


public interface IDisponibiliteDAO extends JpaRepository< Disponibilite, Integer>{

}
