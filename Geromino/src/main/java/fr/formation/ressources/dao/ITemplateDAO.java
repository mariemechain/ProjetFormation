package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Template;

public interface ITemplateDAO extends JpaRepository<Template, Integer> {

}
