<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Gestion des salles" />
	<tiles:putAttribute name="content">


		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre de place</th>
					<th>Adresse</th>
					<th>Contact</th>
					<th>VideoProjecteur</th>
					<th>Coût</th>
					

				</tr>
			</thead>
			<c:forEach items="${salle}" var="salle">
				<tr>
					<td>${salle.id }</td>
					<td>${salle.places }</td>
					<td>${salle.adresse }</td>
					<td>${salle.contact.nom }</td>
					<td>${salle.videoprojecteur.id }</td>
					 <td>${salle.cout}</td> 
					<td><a
						href="/Geromino/gestionnaire/gestionnaireEditerSalle?id=${salle.id }"><button
								type="button" class="btn btn-outline-primary">modifier</button></a>
					</td>
					<td><a
						href="/Geromino/gestionnaire/gestionnaireSupprimerSalle?id=${salle.id }"><button
								type="button" class="btn btn-danger">X</button></a></td>
				</tr>
			</c:forEach>
		</table>

		<div>
			<a href="/Geromino/gestionnaire/gestionnaireAjouterSalle"><button
					type="button" class="btn btn-success">Ajouter une salle</button></a>
					<a href="/Geromino/gestionnaire/">
					<button type="button" class="btn btn-danger">Revenir au
						menu précédent</button>
				</a>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>