package fr.formation.ressources.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.ressources.metier.VideoProjecteur;

public interface IVideoProjecteurDAO extends JpaRepository<VideoProjecteur, String>
{
	
}