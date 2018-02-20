<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Ajout d'un nouveau template cursus" />
	<tiles:putAttribute name="content">
	
			<form:form method="POST" modelAttribute="template">
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