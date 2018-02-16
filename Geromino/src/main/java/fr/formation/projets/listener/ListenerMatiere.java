package fr.formation.projets.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

import fr.formation.ressources.model.Formateur;
import fr.formation.ressources.model.Materiel;
import fr.formation.ressources.model.Matiere;

@WebServlet
public class ListenerMatiere implements ServletContextListener {

	
	private List<Matiere> myMatieres = new ArrayList<Matiere>();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Matiere m1 = new Matiere();
		Matiere m2 = new Matiere();
		Matiere m3 = new Matiere();

		m1.setNom("JAVA");
		m2.setNom("ANGULAR");
		m3.setNom("SPRING");
		
		myMatieres.add(m1);
		myMatieres.add(m2);
		myMatieres.add(m3);
		
		sce.getServletContext().setAttribute("listeMatiereListener", myMatieres);
		
		
	}

}
