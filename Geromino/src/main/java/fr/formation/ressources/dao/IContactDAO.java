package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.Contact;
import fr.formation.ressources.metier.Projet;

public interface IContactDAO  extends JpaRepository<Contact, Integer>{ 

}


