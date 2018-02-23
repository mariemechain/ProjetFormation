<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Cursus ${ Template.nom }" />
	<tiles:putAttribute name="content">

     <table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Matière</th>
						<th scope="col">Durée</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ ordreMatieres }" var="ordreMatiere">
						<tr>
							<td>${ ordreMatiere.matiere.titre }</td>
							<td>${ ordreMatiere.matiere.duree } jours</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="form-group row">
				<div class="col-sm-10">
				<a class="btn btn-primary" href="/Geromino/gestionnaire/gestionnaireTemplates/modifier/${ Template.id }" role="button">Modifier</a>
				<a class="btn btn-secondary" href="/Geromino/gestionnaire/gestionnaireTemplates" role="button">Retour</a>
			</div>
			</div>
	</tiles:putAttribute>
</tiles:insertDefinition>