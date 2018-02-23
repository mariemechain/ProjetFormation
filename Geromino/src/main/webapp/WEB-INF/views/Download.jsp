<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Download" />

	<tiles:putAttribute name="content">


		<div class="container">

			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Fichiers</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${fichiers}" var="f">


						<tr>
							<th class="colonne1" scope="row"><span class="h6">${f.fileName}</span></th>

							<td><a class="btn btn-outline-secondary"
								href="/Geromino/upload/download/${f.id}">Télécharger</a></td>
							<td><a class="btn btn-outline-danger"
								href="/Geromino/upload/download/supprimer?id=${f.id}">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>


			</table>


			<a href="/Geromino/upload/" class="btn btn-outline-primary"
				role="button" aria-pressed="true">Upload</a> <a
				href="/Geromino/matiere/" class="btn btn-outline-warning"
				role="button" aria-pressed="true">Retour</a>

		</div>


	</tiles:putAttribute>

</tiles:insertDefinition>
