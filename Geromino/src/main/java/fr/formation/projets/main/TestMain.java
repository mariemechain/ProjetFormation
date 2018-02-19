package fr.formation.projets.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.projets.dao.IGestionnairerDAO;
import fr.formation.projets.dao.IMatiereDAO;
import fr.formation.projets.dao.IProjetDAO;
import fr.formation.projets.dao.ISalleDAO;
import fr.formation.projets.dao.ITemplateDAO;
import fr.formation.projets.model.Projet;
import fr.formation.projets.model.Template;
import fr.formation.ressources.metier.Gestionnaire;
import fr.formation.ressources.metier.Salle;
import fr.formation.ressources.model.Matiere;

public class TestMain {
	
    public static void main( String[] args )
    {
//    	testModif();
    	testFindAll(); 
    }
    
    /*
     * Test des méthodes de la dao Template
     */
	
    static void testFindAll() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ITemplateDAO tdao = myContext.getBean(ITemplateDAO.class);
    	
    	List listTemplate = tdao.findAll();
    	
    	System.out.println(listTemplate);
    }
    
    
    static void testSave() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ITemplateDAO  tdao = myContext.getBean(ITemplateDAO .class);
		IMatiereDAO  mdao = myContext.getBean(IMatiereDAO .class);
    	
    	Template template = new Template();
    	template.setNom("test-Lien");
    	
    	Matiere matiere1 = mdao.findById(4).get();
    	Matiere matiere2 = mdao.findById(5).get();
    	Matiere matiere3 = mdao.findById(6).get();
    	
    	List<Matiere> matieres = new ArrayList<Matiere>();
    	matieres.add(matiere1);
    	matieres.add(matiere2);
    	matieres.add(matiere3);
    	
    	template.setMatieres(matieres);
    	
    	tdao.save(template);
    	
    	System.out.println("Sauvegarde OK");
    }
    
    static void testDelete() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
		ITemplateDAO tdao = myContext.getBean(ITemplateDAO.class);
		
    	Template template = tdao.findById(5).get();
    	
    	tdao.delete(template);
    	
    	System.out.println("suppression OK");
    }
    
    static void testFindById() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ITemplateDAO tdao = myContext.getBean(ITemplateDAO.class);
		
		Template template = tdao.findById(9).get(); // on rajoute un .get() pour éviter Optional<Produit> (car le résultat est optionel (il ne peut rien y avoir)

    	System.out.println(template);
    }
    
    static void testModif() {
AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ITemplateDAO  tdao = myContext.getBean(ITemplateDAO .class);
    	
    	Template template = tdao.findById(6).get();
 
    	template.setNom("test-mofif");
    	
    	tdao.save(template);
    	
    	System.out.println("modif OK");
    }
    
    /*
     * Test des méthode de la dao Projet
     */
 
/*
    static void testDAOProjet() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
//		Gestionnaire g = new Gestionnaire();
//		g.setNom("MBAE");
//		g.setPrenom("Saïd");
//		g.setAdresse("66 cours charlemagne");
//		IGestionnairerDAO daoG = myContext.getBean(IGestionnairerDAO.class); 
//		daoG.save(g); 
			
		Salle s = new Salle(); 
		s.setId("Salle 201");
		s.setAdresse("66 cours charlemagne - etage 1");
		s.setPlaces(15);
		s.setCout(500);
		s.setVideoprojecteur(null);
		s.setContact(null);
		ISalleDAO daoS = myContext.getBean(ISalleDAO.class); 
		daoS.save(s);
		
//		Projet p = new Projet(); 
//		p.setDebut(new Date());
//		p.setDuree(400);
//		p.setNom("Formation #WaterDance");
//		p.setGestionnaire(g);
//		p.setSalle(s);
//		IProjetDAO pdao = myContext.getBean(IProjetDAO.class);
//    	pdao.save(p); 
		
//    	System.out.println(pdao.findAll());

    }    
*/
    
}
