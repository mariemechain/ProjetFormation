package fr.formation.projets.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


import fr.formation.ressources.model.Matiere;

@WebListener
public class ListenerMatiere implements ServletContextListener {

	
	private List<Matiere> myMatieres = new ArrayList<Matiere>();
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		
		Matiere m1 = new Matiere();
		Matiere m2 = new Matiere();
		Matiere m3 = new Matiere();

		m1.setId(1);
		m1.setNom("JAVA");
		m2.setId(2);
		m2.setNom("ANGULAR");
		m3.setId(3);
		m3.setNom("SPRING");
		
		myMatieres.add(m1);
		myMatieres.add(m2);
		myMatieres.add(m3);
		
		sce.getServletContext().setAttribute("myMatieresListener", myMatieres);
		
		
	}

}
