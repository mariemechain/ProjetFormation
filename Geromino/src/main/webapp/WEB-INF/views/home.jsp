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

		
		<p></p>
		<p>Bonjour et bienvenue ${login} sur ta page d'accueil</p>
		<p>Votre id est : ${utilisateur.id}</p>
		<p>Votre prénom est: ${utilisateur.prenom }</p>
		<p>Votre nom est: ${utilisateur.nom}</p>
		<p>Votre fonction est: ${utilisateur.type}</p>


	</tiles:putAttribute>
</tiles:insertDefinition>
