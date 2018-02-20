<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Planning d'un projet" />
	<tiles:putAttribute name="content">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Mois</th>
					<th colspan="2">Date</th>
					<th>Module</th>
					<th>Formateurs</th>
					<th>Titres</th>
				</tr>
			</thead>
			<c:forEach items="${produits}" var="produit">
				<tr>
					<td>${produit.libelle }</td>
					<td>${produit.prix }£</td>
					<td>${produit.fournisseur.societe}</td>
					<td><a href="/Mvc/produits/editer?id=${produit.id }"><button
								type="button" class="btn btn-outline-primary">modifier</button></a>
						<a href="/Mvc/produits/supprimer?id=${produit.id }"><button
								type="button" class="btn btn-danger">X</button></a></td>
				</tr>
			</c:forEach>
		</table>

	</tiles:putAttribute>
</tiles:insertDefinition>>