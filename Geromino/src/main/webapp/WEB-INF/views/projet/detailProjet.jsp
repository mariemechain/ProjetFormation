<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Détails du projet sélectionné" />

	<tiles:putAttribute name="content">
		
		<p>Identifiant : ${ detailProjet.id }</p>
		
		<p>Nom du projet : ${ detailProjet.nom }</p>
		
		<p>Date du début de la formation : ${ detailProjet.dateDebut }</p>
		
		<p>Durée du projet : ${ detailProjet.duree} jours</p>
		
		<p>Salle : ${ detailProjet.salle.id}</p>

		<c:if test="${detailProjet.planifications == null}">
			<p>Planifications : aucun</p>
		</c:if>
		<c:if test="${detailProjet.planifications != null}">
			<p>Planifications :</p>
			<c:forEach items="${detailProjet.planifications}" var="planification">
				<p>- Matière : ${planification.matiere.titre} - Formateur : ${planification.formateur} </p>
			</c:forEach>
		</c:if>
				
		<c:if test="${detailProjet.stagiaires=='[]'}">
			<p>Stagiaires : aucun</p>
		</c:if>
		<c:if test="${detailProjet.stagiaires!='[]'}">
			<p>Stagiaires :</p>
			<c:forEach items="${stagiaires}" var="stagiaires">
				<p>- Nom : ${stagiaires.nom} </p>
			</c:forEach>
		</c:if>
		
		
		<a href="projet" class="btn btn-primary">Retour à la liste des projets</a> 
	
	</tiles:putAttribute>
</tiles:insertDefinition>