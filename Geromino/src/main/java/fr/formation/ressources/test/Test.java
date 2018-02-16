package fr.formation.ressources.test;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import fr.formation.config.AppConfig;
import fr.formation.ressources.dao.IGestionnaireDAO;
import fr.formation.ressources.dao.IOrdinateurDAO;
import fr.formation.ressources.dao.IProjetDAO;
import fr.formation.ressources.dao.ISalleDAO;
import fr.formation.ressources.dao.IStagiaireDAO;
import fr.formation.ressources.dao.ITechnicienDAO;
import fr.formation.ressources.dao.IVideoProjecteurDAO;


public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Environment myEnvironment = myContext.getBean(Environment.class);
		 ISalleDAO sdao = myContext.getBean(ISalleDAO.class);
		 IOrdinateurDAO odao= myContext.getBean(IOrdinateurDAO.class);
		 IGestionnaireDAO gdao=myContext.getBean(IGestionnaireDAO.class);
		 IStagiaireDAO stdao=myContext.getBean(IStagiaireDAO.class);
		 ITechnicienDAO tdao=myContext.getBean(ITechnicienDAO.class);
		 IVideoProjecteurDAO vdao=myContext.getBean(IVideoProjecteurDAO.class);
		 IProjetDAO pdao = myContext.getBean(IProjetDAO.class);
		 
	}
		 
	        
}