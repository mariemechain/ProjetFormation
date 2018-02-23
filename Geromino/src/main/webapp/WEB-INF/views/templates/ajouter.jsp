<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Edition" />
	<tiles:putAttribute name="content">
	
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Matière</th>
						<th scope="col">durée</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
						
					<c:forEach items="${ ordreMatieres }" var="ordreMatiere" varStatus="loop">
						<tr>
							<td>${ ordreMatiere.matiere.titre }</td>
							<td>${ ordreMatiere.matiere.duree } jours</td>
							<td>
							<a class="btn btn-danger" href="/Geromino/gestionnaire/gestionnaireTemplates/editer/supprimer/${ loop.index }"role="button">Supprimer</a>
							<c:if test ="${ loop.index > 0 }">
								<a class="btn btn-secondary" href="/Geromino/gestionnaire/gestionnaireTemplates/editer/haut/${ loop.index }"role="button">&uarr;</a>
							</c:if>
							<c:if test ="${ loop.index <= 0 }">
								<a class="btn btn-secondary" role="button" disabled>&uarr;</a>
							</c:if>
							<c:if  test ="${ loop.index < tailleMax-1 }">
								<a class="btn btn-secondary" href="/Geromino/gestionnaire/gestionnaireTemplates/editer/bas/${ loop.index }"role="button">&darr;</a>
							</c:if>
							<c:if  test ="${ loop.index >= tailleMax-1 }">
								<a class="btn btn-secondary" role="button" disabled>&darr;</a>
							</c:if>
							</td>
						</tr>
					</c:forEach>
					
						<tr>
						<form:form method="POST" action="/Geromino/gestionnaire/gestionnaireTemplates/editer/ajouterligne" modelAttribute="template" id="myForm">	
							<td>			
							<select name="matiereId" class="form-control">
								<c:forEach items="${listeMatiere }" var="listeMatiere">
									<option value="${listeMatiere.id }">${listeMatiere.titre}</option>
								</c:forEach>
							</select>
						</td>
    							<td></td>
							<td><button type="submit" class="btn btn-success">Ajouter</button></td>
							</form:form>
						</tr>
				</tbody>
			</table>
	
			<form:form method="POST" action="/Geromino/gestionnaire/gestionnaireTemplates/valider" modelAttribute="template">
					<div class="form-group">
						<label for="nom">Nom</label> 
						<input id="nom"
							class="form-control" name="nom" type="text"
							value="${ template.nom }" />
					</div>
					
					<input id="id" name="id" type="hidden" value="${ template.id }">
					
					<form:errors path="nom" element="div" cssClass="alert alert-danger" />
					
					<div>
						<button type="submit" class="btn btn-primary">Valider</button>
					</div>
					<div>
					<a href="/Geromino/gestionnaire/gestionnaireTemplates">
			<button type="button" class="btn btn-danger mb-4">Revenir au menu précédent</button></a>
			</div>
				</form:form>

	</tiles:putAttribute>
</tiles:insertDefinition>