package fr.formation.projets.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.projets.dao.IProjetDAO;
import fr.formation.projets.dao.ITemplateDAO;
import fr.formation.projets.model.Template;
import fr.formation.projets.dao.IMatiereDAO;
import fr.formation.ressources.model.Matiere;

public class TestMain {
	
    public static void main( String[] args )
    {
    	testModif();
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
    	
    static void testDAOProjet() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		IProjetDAO pdao = myContext.getBean(IProjetDAO.class);
    	
    	List listProjet = pdao.findAll();
    	
    	System.out.println(listProjet);
    	
    	
    }
    

}
