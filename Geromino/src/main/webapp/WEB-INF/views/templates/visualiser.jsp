<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Visualisation du cursus ${ Template.nom }" />
	<tiles:putAttribute name="content">

     <table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Matière</th>
						<th scope="col">durée</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ Matieres }" var="Matieres">
						<tr>
							<td>${ Matieres.titre }</td>
							<td>${ Matieres.duree }</td>
							<td><a class="btn btn-secondary" href="/Geromino/templates/modifier/${Templates.id}" role="button">Modifier</a>
							<a class="btn btn-danger" href="/Geromino/templates/supprimer/${Templates.id}"role="button">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
				<a class="btn btn-primary" href="/Geromino/templates/ajouter" role="button">Ajouter une matiere</a>
			</div>

	</tiles:putAttribute>
</tiles:insertDefinition>