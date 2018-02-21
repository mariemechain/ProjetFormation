<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Technicien" />

	<tiles:putAttribute name="content">


		<div class="container-fluid">
			<h3>Liste d'ordinateurs disponibles</h3>
			<br />
			<table class="table table-striped" style="text-align:center">
				<thead>
					<tr>
						<th>Identifiant</th>
						<th>Processeur</th>
						<th>RAM</th>
						<th>Stockage</th>
						<th>Date d'achat</th>
						<th>Cout journalier</th>
						<th>Date retour</th>
						<th>Option</th>
					</tr>
				</thead>
				<c:forEach items="${ ordinateurs }" var="ordinateur">

					<tr>
						<td>${ ordinateur.id }</td>
						<td>${ ordinateur.processeur }</td>
						<td>${ ordinateur.ram }</td>
						<td>${ ordinateur.stockage }</td>
						<td>${ ordinateur.achat }</td>
						<td>${ ordinateur.cout }€</td>
						<td>${ ordinateur.date }</td>
						<td><a
							href="/Geromino/technicien/ordi/modifier?id=${ordinateur.id}"
							class="btn btn-primary">Modifier</a></td>

						<td><a
							href="/Geromino/technicien/ordi/allouer?id=${ordinateur.id}"
							class="btn btn-dark">Allouer</a></td>
						<td><a
							href="/Geromino/technicien/ordi/etat?id=${ordinateur.id}"
							class="btn btn-warning">OUT</a> <a
							href="/Geromino/technicien/ordi/supprimer?id=${ordinateur.id}"
							class="btn btn-danger">X</a></td>

					</tr>
				</c:forEach>



			</table>
			<a href="/Geromino/technicien/ordi/ajouter" class="btn btn-success">Ajouter un ordinateur</a>
			<a href="/Geromino/technicien">
				<button type="button" class="btn btn-danger">Revenir au
					menu précédent</button>
			</a>
		</div>


	</tiles:putAttribute>


</tiles:insertDefinition>