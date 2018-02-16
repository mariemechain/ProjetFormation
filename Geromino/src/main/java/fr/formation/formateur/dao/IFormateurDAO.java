package fr.formation.formateur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.formateur.model.Formateur;

public interface IFormateurDAO extends JpaRepository<Formateur, Integer>{

}
