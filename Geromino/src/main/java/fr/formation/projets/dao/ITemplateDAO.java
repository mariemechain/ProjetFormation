package fr.formation.projets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.projets.model.Template;

public interface ITemplateDAO extends JpaRepository<Template, Integer> {

}
