
package fr.formation.projets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projets.model.Projet;
import fr.formation.ressources.model.Formateur;

public interface IFormateurDAO extends JpaRepository<Formateur, Integer>{

}

