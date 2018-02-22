<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Liste des projets" />

	<tiles:putAttribute name="content">
		<a href="projet/ajouter" class="btn btn-success">+</a>


		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Info</th>
					<th scope="col">Nom</th>
					<th scope="col">Date de début</th>
					<th scope="col">Durée</th>
					<th scope="col">Salle</th>
					<th scope="col">Cursus</th>
					<th scope="col">Stagiaires</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ Projet }" var="projet">
					<tr>
						<td>
							<a href="projet/detailProjet/${projet.id }" class="btn btn-success">détail</a>
						</td>
						<td>${ projet.nom }</td>
						<td>${ projet.dateDebut}</td>
						<td>${ projet.duree} jours</td>
						<td>${ projet.salle.id}</td>
						<td> </td>
						<td>${ projet.stagiaires} / ${ projet.salle.places}</td>
						<td>
							<a href="projet/editer/${ projet.id }" class="btn btn-primary">Editer</a>
							<a href="projet/supprimer?id=${ projet.id }" class="btn btn-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</tiles:putAttribute>
</tiles:insertDefinition>
