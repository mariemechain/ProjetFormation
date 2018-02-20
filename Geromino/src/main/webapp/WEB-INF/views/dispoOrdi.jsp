<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title"
		value="Définir la disponibilité de l'ordinateur" />

	<tiles:putAttribute name="content">

		<form:form method="POST" modelAttribute="ordinateur">
			<div class="container">

				<br />
				<div class="form-group">
					<label for="id">Identifiant :</label> <label>${ordinateur.id}</label>
				</div>

				<div class="form-group">
					<label for="date">Veuillez indiquer la date de retour de réparation estimé du matériel (aaaa-mm-jj) :</label> <input name="date"
						type="text" class="form-control" id="date"
						value="${ordinateur.date}" placeholder="Date de retour">


				</div>
				<button type="submit" class="btn btn-primary">Submit</button>

			</div>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
