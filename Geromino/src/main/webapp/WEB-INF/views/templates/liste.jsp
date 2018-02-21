<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="liste des templates cursus" />
	<tiles:putAttribute name="content">
	
	
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Nom</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ Templates }" var="Template">
						<tr>
							<td>${ Template.nom }</td>
							<td><a class="btn btn-success" href="/Geromino/templates/visualiser/${Template.id}" role="button">Visualiser</a>
							<a class="btn btn-danger" href="/Geromino/templates/supprimer/${Template.id}"role="button">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
				<a class="btn btn-primary" href="/Geromino/templates/ajouter" role="button">Créer un nouveau template</a>
			</div>

	</tiles:putAttribute>
</tiles:insertDefinition>