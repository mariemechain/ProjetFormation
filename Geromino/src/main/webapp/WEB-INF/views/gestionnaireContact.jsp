<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Gestion des contacts" />
	<tiles:putAttribute name="content">


		<table class="table table-striped" style="text-align:center">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Adresse</th>
					<th>Date de naissance</th>
					<th>Email</th>
					<th>Téléphone</th>
					<th></th>
					<th></th>

				</tr>
			</thead>
			<c:forEach items="${contacts}" var="contact">
				<tr>
					<td>${contact.id }</td>
					<%-- <td>${projet.XXX }</td>--%>
					<td>${contact.nom}</td>
					<td>${contact.prenom}</td>
 					<td>${contact.adresse }</td>		
					<td>${contact.date}</td>
					<td>${contact.email}</td>
					<td>${contact.telephone}</td>
					<td><a
						href="/Geromino/gestionnaire/gestionnaireEditerContact?id=${contact.id }"><button
								type="button" class="btn btn-primary">Modifier</button></a>
					</td>
					<td><a
						href="/Geromino/gestionnaire/gestionnaireSupprimerContact?id=${contact.id }"><button
								type="button" class="btn btn-danger">X</button></a></td>
				</tr>
			</c:forEach>
		</table>

		<div>
			<a href="/Geromino/gestionnaire/gestionnaireAjouterContact"><button
					type="button" class="btn btn-success">Ajouter un nouveau
					Contact</button></a>
					<a href="/Geromino/gestionnaire/">
					<button type="button" class="btn btn-danger">Revenir au
						menu précédent</button>
				</a>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>