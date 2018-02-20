package fr.formation.ressources.controller;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.ressources.metier.Personnel;


@WebFilter("/*")
public class SecurityFilter implements Filter{


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String myProjectPath = req.getContextPath();
		String myPath = req.getServletPath().replaceAll(myProjectPath, "/");
		Personnel p =(Personnel)req.getSession().getAttribute("utilisateur");
		
		
		//Si pas connecté
		if (req.getSession().getAttribute("login") == null) {
			//Si ni "assets" ni "page de login"
			if (!myPath.startsWith("/css") && !myPath.startsWith("/js") && !myPath.startsWith("/connexion")) {
				resp.sendRedirect(myProjectPath + "/connexion");
				return;
			}
			
			else {
				chain.doFilter(request, response);
				return;
			}
		}
		
		//Si tout va bien, on autorise
		String metier = p.getType();
		
		if(metier.equals("Administrateur")) {
			chain.doFilter(request, response);
		}
		else if (metier.equals("Gestionnaire")) {
			chain.doFilter(request, response);
		}
		else if (metier.equals("Technicien")) {
			if (myPath.startsWith("/gestionnaire") ) {
				resp.sendRedirect(myProjectPath + "/mauvaiseRequete");
				return;
			}
			chain.doFilter(request, response);
		}
		else if (metier.equals("Formateur")) {
			chain.doFilter(request, response);
		}
	}
}