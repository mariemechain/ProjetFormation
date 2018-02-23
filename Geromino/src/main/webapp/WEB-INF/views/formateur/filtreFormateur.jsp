<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="navigation"
		value="/WEB-INF/views/navigation.jsp" />

	<tiles:putAttribute name="content">



		<h2>Choix formateur pour la matiere : ${matiere.titre}</h2>

		<!--#########	Partie Filtre	#########-->


		<form method="POST" action="">
			<div class="form-group">
				<input type="hidden" id="idf" name="idf" value="${formateur.id}">





				<div class="form-group">
					<label for="sel2">Matières:</label> <span id="sel2" name="matiere"
						value="${ matiere.titre }">${ matiere.titre }</span>
				</div>

			</div>
		</form>



		<!--#########	Liste	#########-->


		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ listeformateurs }" var="listeFormateurs">
					<tr>
						<td>${ listeFormateurs.id }</td>
						<td>${ listeFormateurs.nom }</td>
						<td>${ listeFormateurs.prenom }</td>
						<td><a href="./formateurs/attribuer?idf=${listeFormateurs.id}">Attribuer</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>



	</tiles:putAttribute>
</tiles:insertDefinition>
