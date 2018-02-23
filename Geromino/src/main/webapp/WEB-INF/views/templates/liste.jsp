<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Liste des templates cursus" />
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
							<td><a class="btn btn-success" href="/Geromino/gestionnaire/gestionnaireTemplates/visualiser/${Template.id}" role="button">Visualiser</a>
							<a class="btn btn-danger" href="/Geromino/gestionnaire/gestionnaireTemplates/supprimer/${Template.id}"role="button">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="form-group row">
				<div class="col-sm-10">
				<a class="btn btn-primary" href="/Geromino/gestionnaire/gestionnaireTemplates/ajouter" role="button">Créer un nouveau template</a>
					<a href="/Geromino/gestionnaire">
			<button class="btn btn-danger" type="button" >Revenir au menu précédent</button></a>
			</div>
			</div>

	</tiles:putAttribute>
</tiles:insertDefinition>