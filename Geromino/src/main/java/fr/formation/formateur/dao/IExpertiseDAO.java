package fr.formation.formateur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.formateur.model.Expertise;



public interface IExpertiseDAO extends JpaRepository< Expertise, Integer> {

}
