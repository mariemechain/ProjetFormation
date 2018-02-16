package fr.formation.ressources.test;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;


public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
	}
}