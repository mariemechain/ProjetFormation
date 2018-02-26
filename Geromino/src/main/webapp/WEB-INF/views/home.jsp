<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Accueil" />
	<tiles:putAttribute name="content">


	
			<div id="container">
 <!-- Code generated at https://WeatherWidget.io -->  
<a class="weatherwidget-io" href="https://forecast7.com/fr/45d764d84/lyon/" data-label_1="LYON" data-label_2="METEO" data-theme="orange" >Météo Lyon</a>

<!-- / Code generated at https://WeatherWidget.io --> 
  </div>
<c:if test="${utilisateur.type == 'Administrateur' }">	
      <!-- Jumbotron Header -->
      <header class="jumbotron my-4">
        <h1 class="display-3">Bonjour et bienvenue ${utilisateur.prenom} sur votre page d'accueil!</h1>
        <p class="lead">En tant qu' ${utilisateur.type}, vous administrez les ressources humaines et materielles. Votre accès est complet.</p>
        <a href="admin" class="btn btn-primary btn-lg">J'administre!</a>
      </header>
</c:if>	
		
<c:if test="${utilisateur.type == 'Gestionnaire' }">	
      <!-- Jumbotron Header -->
      <header class="jumbotron my-4">
        <h1 class="display-3">Bonjour et bienvenue ${utilisateur.prenom} sur votre page d'accueil!</h1>
        <p class="lead">En tant que ${utilisateur.type}, vous êtes à même de pouvoir gérer les projets et les matières</p>
        <a href="gestionnaire" class="btn btn-primary btn-lg">Je gère!</a>
      </header>
</c:if>	

<c:if test="${utilisateur.type == 'Technicien' }">	
      <!-- Jumbotron Header -->
      <header class="jumbotron my-4">
        <h1 class="display-3">Bonjour et bienvenue ${utilisateur.prenom} sur votre page d'accueil!</h1>
        <p class="lead">En tant que ${utilisateur.type}, vous gérez les ressources matérielles. </p>
        <a href="technicien" class="btn btn-primary btn-lg">Je gère!</a>
      </header>
</c:if>	
		


	</tiles:putAttribute>
</tiles:insertDefinition>
