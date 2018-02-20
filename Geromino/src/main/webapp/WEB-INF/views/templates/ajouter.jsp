<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Création d'un nouveau template cursus" />
	<tiles:putAttribute name="content">
	
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Matière</th>
						<th scope="col">durée</th>
						<td></td>
					</tr>
				</thead>
				<tbody>
						
					<c:forEach items="${ Matieres }" var="Matieres">
						<tr>
							<td>${ Matieres.titre }</td>
							<td>${ Matieres.duree } jours</td>
							<td></td>
						</tr>
					</c:forEach>
					
						<tr>
						<form:form method="POST" action="ajouterligne" modelAttribute="template" id="myForm">	
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
	
			<form:form method="POST" action="ajouter" modelAttribute="template">
					<div class="form-group">
						<label for="nom">Nom</label> 
						<input id="nom"
							class="form-control" name="nom" type="text"
							value="${ template.nom }" />
					</div>
					
					<form:errors path="nom" element="div" cssClass="alert alert-danger" />
					
					<div>
						<button type="submit" class="btn btn-primary">Valider</button>
					</div>
				</form:form>

	</tiles:putAttribute>
</tiles:insertDefinition>