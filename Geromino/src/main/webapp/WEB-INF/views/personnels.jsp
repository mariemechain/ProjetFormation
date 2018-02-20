<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Administrateur" />

	<tiles:putAttribute name="content">


		<div class="container-fluid">
			<h3>Liste personnels</h3>
			<br />
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Identifiant</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>E-Mail</th>
						<th>Type</th>
						<th>Option</th>
					</tr>
				</thead>
				<c:forEach items="${ personnels }" var="personnel">

					<tr>
						<td>${ personnel.id }</td>
						<td>${ personnel.nom }</td>
						<td>${ personnel.prenom }</td>
						<td>${ personnel.email }</td>
						<td>${personnel.type}</td>
						<td><a
							href="/Geromino/technicien/ordi/modifier?id=${personnel.id}"
							class="btn btn-success">Modifier</a>
							<a
							href="/Geromino/technicien/ordi/supprimer?id=${personnel.id}"
							class="btn btn-danger">X</a></td>


					</tr>
				</c:forEach>



			</table>
			<a href="/Geromino/technicien/ordi/ajouter" class="btn btn-primary">Ajouter</a>

		</div>
		

	</tiles:putAttribute>


</tiles:insertDefinition>