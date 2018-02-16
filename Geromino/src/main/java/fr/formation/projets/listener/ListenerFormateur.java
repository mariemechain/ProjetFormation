package fr.formation.projets.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.formation.ressources.model.Formateur;

@WebListener
public class ListenerFormateur implements ServletContextListener {

	private List<Formateur> myFormateurs = new ArrayList<Formateur>();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	
		Formateur f1 = new Formateur();
		Formateur f2 = new Formateur();
		Formateur f3 = new Formateur();
		
		
		
		f1.setNom("jeremy");
		f2.setNom("jacky");
		f3.setNom("jor");
		
		myFormateurs.add(f1);
		myFormateurs.add(f2);
		myFormateurs.add(f3);
		
		sce.getServletContext().setAttribute("myFormateursListener", myFormateurs);
	}
}
