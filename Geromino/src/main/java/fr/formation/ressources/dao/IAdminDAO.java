package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Admin;

public interface IAdminDAO extends JpaRepository<Admin, Integer> {

}
