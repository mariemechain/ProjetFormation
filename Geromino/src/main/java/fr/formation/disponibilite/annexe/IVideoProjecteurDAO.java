package fr.formation.disponibilite.annexe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IVideoProjecteurDAO extends JpaRepository<VideoProjecteur, String> {

	@Query("from VideoProjecteur v left join fetch v.dispo")
	public List<VideoProjecteur> findAll();
}
