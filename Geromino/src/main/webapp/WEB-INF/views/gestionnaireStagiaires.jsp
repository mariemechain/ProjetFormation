<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Gestion des stagiaires" />
	<tiles:putAttribute name="content">


		<table class="table table-striped" style="text-align:center">
			<thead>
				<tr>
					<th>Id</th>
					<th>Adresse</th>
					<th>Date de naissance</th>
					<th>Email</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Téléphone</th>
					<th>Ordinateur</th>

				</tr>
			</thead>
			<c:forEach items="${stagiaires}" var="stagiaire">
				<tr>
					<td>${stagiaire.id }</td>
					<%-- <td>${projet.XXX }</td>--%>
 					<td>${stagiaire.adresse }</td>		
					<td>${stagiaire.date}</td>
					<td>${stagiaire.email}</td>
					<td>${stagiaire.nom}</td>
					<td>${stagiaire.prenom}</td>
					<td>${stagiaire.telephone}</td>
					<td>${stagiaire.ordinateur.id}</td>
					<td><a
						href="/Geromino/gestionnaire/gestionnaireEditerStagiaire?id=${stagiaire.id }"><button
								type="button" class="btn btn-outline-primary">modifier</button></a>
					</td>
					<td><a
						href="/Geromino/gestionnaire/gestionnaireSupprimerStagiaire?id=${stagiaire.id }"><button
								type="button" class="btn btn-danger">X</button></a></td>
				</tr>
			</c:forEach>
		</table>

		<div>
			<a href="/Geromino/gestionnaire/gestionnaireAjouterStagiaire"><button
					type="button" class="btn btn-success">Ajouter un nouveau
					Stagiaire</button></a>
					<a href="/Geromino/gestionnaire/">
					<button type="button" class="btn btn-danger">Revenir au
						menu précédent</button>
				</a>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>