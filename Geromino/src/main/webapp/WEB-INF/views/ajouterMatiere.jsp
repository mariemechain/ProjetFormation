<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title"
		value="Ajout/Modification d'une matière" />

	<tiles:putAttribute name="content">
		<div class="container">



			<form:form method="post" modelAttribute="matiere">

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<form:label class="input-group-text" id="inputGroup-sizing-sm"
							path="titre">Titre</form:label>
						<form:input class="form-control" aria-label="Small" path="titre" />
					</div>
				</div>

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<form:label class="input-group-text" id="inputGroup-sizing-sm"
							path="duree">Durée</form:label>
						<form:input class="form-control" aria-label="Small" path="duree" />
					</div>
				</div>

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<form:label class="input-group-text" id="inputGroup-sizing-sm"
							path="objectif">Objectifs</form:label>
						<form:input class="form-control" aria-label="Small"
							path="objectif" />
					</div>
				</div>

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<form:label class="input-group-text" id="inputGroup-sizing-sm"
							path="prerequis">Prérequis</form:label>
					
					<div class="form-check" aria-label="Small">
						<c:forEach items="${matieres}" var="matiere">
						    <input type="checkbox"  class="filled-in" name="test_${matiere.id}">
						    <label >${matiere.titre}</label>
					    </c:forEach>
					</div>
					</div>
					
				</div>

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<form:label class="input-group-text" id="inputGroup-sizing-sm"
							path="contenu">Contenu</form:label>
						<form:input class="form-control" aria-label="Small" path="contenu" />
					</div>
				</div>

				<form:errors path="titre" element="div" cssClass="alert alert-danger" />
				<form:errors path="duree" element="div" cssClass="alert alert-danger" />

				<div>
					<button type="submit" class="btn btn-outline-success"
						value="Ajouter">Valider</button>
				</div>

			</form:form>
		</div>
	</tiles:putAttribute>

</tiles:insertDefinition>