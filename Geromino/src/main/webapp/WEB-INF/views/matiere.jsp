<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Liste des matieres" />

	<tiles:putAttribute name="content">


		<div class="row">

			<div class="col-6">
				<div class="list-group">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Matières</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${matieres}" var="m">


								<tr>
									<th class="colonne1" scope="row"><span class="h6">${m.titre}</span></th>

									<td><a class="btn btn-outline-success"
										href="/Geromino/matiere/information?id=${m.id}">Informations</a>
									</td>
									<td><a class="btn btn-outline-secondary"
										href="/Geromino/matiere/editer?id=${m.id}">Modifier</a></td>
									<td><a id="suppr" class="btn btn-outline-danger"
										href="/Geromino/matiere/supprimer?id=${m.id}">Supprimer</a></td>
								</tr>
							</c:forEach>
						</tbody>


					</table>
				</div>
				<div class="list-group">
					<a href="/Geromino/matiere/ajouter" class="btn btn-outline-primary"
						role="button" aria-pressed="true">Ajouter une nouvelle matière</a>
				</div>
			</div>

			<div class="col-1"></div>

			<div class="col-5">
				<span class="d-block p-2 bg-light text-black">
					<h2>Details de la matière sélectionnée :</h2> <c:if
						test="${detailMatiere==null}">
					</c:if> <c:if test="${detailMatiere!=null}">
						<p>Matière : ${detailMatiere.titre}</p>
						<p>Durée de la matière : ${detailMatiere.duree} jour(s)</p>
						<p>Objectif de la matière : ${detailMatiere.objectif}</p>
						<c:if test="${detailMatiere.prerequis=='[]'}">
							<p>Prérequis de la matière : aucun</p>
						</c:if>
						<c:if test="${detailMatiere.prerequis!='[]'}">
							<p>Prérequis de la matière :</p>
							<c:forEach items="${Prerequis}" var="matierePrerequis">
								<p>- ${matierePrerequis}</p>
							</c:forEach>
						</c:if>
						<p>Contenu de la matière : ${detailMatiere.contenu}</p>
					</c:if>
				</span>
			</div>

			<a href="/Geromino/upload/download" class="btn btn-outline-primary"
				role="button" aria-pressed="true">Fichiers en ligne</a>

		</div>




	</tiles:putAttribute>

</tiles:insertDefinition>
