package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Expertise;



public interface IExpertiseDAO extends JpaRepository< Expertise, Integer> {

}
