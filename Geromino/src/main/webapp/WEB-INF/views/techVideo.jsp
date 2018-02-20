<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Technicien" />

	<tiles:putAttribute name="content">


		<div class="container">


			<h3>Liste de videoprojecteurs disponibles</h3>
			<br />
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Identifiant</th>
						<th>Cout journalier</th>
						<th>Date retour</th>
						<th>Option</th>
					</tr>
				</thead>
				<c:forEach items="${ videoprojecteurs }" var="videoprojecteur">

					<tr>
						<td>${ videoprojecteur.id }</td>
						<td>${ videoprojecteur.cout }€</td>
						<td>${ videoprojecteur.date }</td>
						<td><a
							href="/Geromino/technicien/video/modifier?id=${videoprojecteur.id}"
							class="btn btn-success">Modifier</a></td>

						<td><a
							href="/Geromino/technicien/video/etat?id=${videoprojecteur.id}"
							class="btn btn-warning">OUT</a> <a
							href="/Geromino/technicien/video/supprimer?id=${videoprojecteur.id}"
							class="btn btn-danger">X</a></td>

					</tr>
				</c:forEach>

			</table>


			<a href="/Geromino/technicien/video/ajouter" class="btn btn-primary">Ajouter</a>
			<a href="/Geromino/technicien">
				<button type="button" class="btn btn-danger">Revenir au
					menu précédent</button>
			</a>
		</div>
	</tiles:putAttribute>


</tiles:insertDefinition>