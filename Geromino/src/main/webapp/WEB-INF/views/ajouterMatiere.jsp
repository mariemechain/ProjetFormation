<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Ajout d'une matière" />
	
	<tiles:putAttribute name="content">
		<form:form method="post" modelAttribute="matiere">
		
			<div class="form-group">
				<form:label path="titre">Titre</form:label>
				<form:input path="titre" />
			</div>
			<div class="form-group">
				<form:label path="duree">Durée</form:label>
				<form:input path="duree" />
			</div>
			<div class="form-group">
				<form:label path="objectif">Objectifs</form:label>
				<form:input path="objectif" />
			</div>
			<div class="form-group">
				<form:label path="prerequis">Prérequis</form:label>
				<div class="btn-group btn-group-toggle" data-toggle="buttons">
					<c:forEach items="${matiere}" var="matiere">
					  <label class="btn btn-secondary active">
					    <input type="checkbox" name="options" autocomplete="off" value="${matiere.id}"> ${matiere.titre}
					  </label>
					</c:forEach>
				</div>
			</div>
			<div class="form-group">
				<form:label path="contenu">Contenu</form:label>
				<form:input path="contenu" />
		    </div>
		    <div>
		    	<button type="submit" class="btn btn-outline-success" value="Ajouter"> Ajouter une matière</button>
		    </div>
		    
		</form:form>	
	</tiles:putAttribute>
	
</tiles:insertDefinition>