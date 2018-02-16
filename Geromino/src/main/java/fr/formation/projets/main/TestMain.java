package fr.formation.projets.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.projets.dao.IProjetDAO;
import fr.formation.projets.dao.ITemplateDAO;
import fr.formation.projets.model.Template;

public class TestMain {
	
    public static void main( String[] args )
    {
    	testDAOProjet();
    }
	
    static void testFindAll() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ITemplateDAO tdao = myContext.getBean(ITemplateDAO.class);
    	
    	List listTemplate = tdao.findAll();
    	
    	System.out.println(listTemplate);
    }
    
    
    static void testSave() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ITemplateDAO  tdao = myContext.getBean(ITemplateDAO .class);
    	
    	Template template = new Template();
    	template.setNom("test2");

    	tdao.save(template);
    	
    	System.out.println("Sauvegarde OK");
    }
    
    static void testDelete() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
		ITemplateDAO tdao = myContext.getBean(ITemplateDAO.class);
		
    	Template template = new Template();
    	template.setId(4);
    	
    	tdao.delete(template);
    }
    
    static void testFindById() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ITemplateDAO tdao = myContext.getBean(ITemplateDAO.class);
		
		Template template = tdao.findById(5).get(); // on rajoute un .get() pour éviter Optional<Produit> (car le résultat est optionel (il ne peut rien y avoir)

    	System.out.println(template);
    }
    
    
    static void testDAOProjet() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		IProjetDAO pdao = myContext.getBean(IProjetDAO.class);
    	
    	List listProjet = pdao.findAll();
    	
    	System.out.println(listProjet);
    	
    	
    }
    

}
