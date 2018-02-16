<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Technicien" />

	<tiles:putAttribute name="content">


		<div class="container">

<<<<<<< HEAD
<h3>Liste de videoprojecteurs disponibles</h3>
<br/>
<table class="table table-striped">

<c:forEach items="${ videoprojecteurs }" var="videoprojecteur">
<thead>
				<tr>
				<th>Identifiant</th>
				<th>Option</th>
				</tr>
				</thead>
<tr>
<td>${ videoprojecteur.id }  </td> 
<td><a href="/Geromino/technicien/video/edit?id=${videoprojecteur.id}" class="btn btn-outline-success">Modifier</a>
</td>
<td><a href="/Geromino/technicien/video/supprimer?id=${videoprojecteur.id}" class="btn btn-outline-danger">Supprimer</a>
</td>
</tr>
</c:forEach>
=======
			<h3>Liste de videoprojecteurs disponibles</h3>

			<table class="table table-striped">

				<c:forEach items="${ videoprojecteurs }" var="videoprojecteur">
					<tr>
						<td>${ videoprojecteur.id }</td>
						<td><a
							href="/Geromino/technicien/video/edit?id=${videoprojecteur.id}"
							class="btn btn-outline-success">Modifier</a></td>
						<td><a
							href="/Geromino/technicien/video/supprimer?id=${videoprojecteur.id}"
							class="btn btn-outline-danger">Supprimer</a></td>
					</tr>
				</c:forEach>
>>>>>>> Module_ressources



			</table>


			<a href="/Geromino/technicien/video/ajouter" class="btn btn-primary">Ajouter</a>

		</div>
	</tiles:putAttribute>


</tiles:insertDefinition>