package fr.formation.matieres.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.matieres.model.UploadFile;

public interface IUploadFileDAO extends JpaRepository<UploadFile, Integer>{


}
