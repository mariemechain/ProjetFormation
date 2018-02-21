<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Gestion des projets" />
	<tiles:putAttribute name="content">


		<table class="table table-striped" style="text-align:center">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Durée</th>
					<th>Salle</th>
					<th>Date de début</th>
					<th>Option</th>

				</tr>
			</thead>
			<c:forEach items="${projet}" var="projet">
				<tr>
					<td>${projet.id }</td>
					<td>${projet.nom }</td>
					<%-- <td>${projet.XXX }</td>--%>
 					<td>${projet.duree }</td>	
 					<td>${projet.salle.id }</td>		
					<%-- <td>${projet.gestionnaire.nom }</td> --%>
					<td>${projet.dateDebut }</td> 
					<td><a
						href="/Geromino/gestionnaire/gestionnaireEditerProjet?id=${projet.id }"><button
								type="button" class="btn btn-outline-primary">modifier</button></a>
								<a
						href="/Geromino/gestionnaire/gestionnaireSupprimerProjet?id=${projet.id }"><button
								type="button" class="btn btn-danger">X</button></a>
					</td>
					
				</tr>
			</c:forEach>
		</table>

		<div>
			<a href="/Geromino/gestionnaire/gestionnaireAjouterProjet"><button
					type="button" class="btn btn-success">Ajouter un nouveau
					projet</button></a>
					<a href="/Geromino/gestionnaire/">
					<button type="button" class="btn btn-danger">Revenir au
						menu précédent</button>
				</a>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>