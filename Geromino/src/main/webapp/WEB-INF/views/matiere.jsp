<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Liste des matieres" />

	<tiles:putAttribute name="content">

		<div class="container">
			<div class="row">

				<div class="col-5">
					<div class="list-group">
						<c:forEach items="${matieres}" var="m">
							<p
								class="list-group-item d-flex justify-content-between align-items-center">
								${m.titre} <span class="badge badge-success badge-pill"><a
									class="text-white"
									href="/Geromino/matiere/information?id=${m.id}">Informations</a></span>
								<span class="badge badge-primary badge-pill"><a
									class="text-white" href="/Geromino/matiere/editer?id=${m.id}">Modifier</a></span>
								<span class="badge badge-danger badge-pill"><a
									class="text-white"
									href="/Geromino/matiere/supprimer?id=${m.id}">Supprimer</a></span>
							</p>
						</c:forEach>
					</div>
					<div class="list-group">
						<a href="/Geromino/matiere/ajouter"
							class="btn btn-outline-primary" role="button" aria-pressed="true">Ajouter
							une nouvelle matière</a>
					</div>
				</div>

				<div class="col-1"></div>

				<div class="col-6">
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
								<p>Prérequis de la matière : ${detailMatiere.prerequis}</p>
							</c:if>
							<p>Contenu de la matière : ${detailMatiere.contenu}</p>
						</c:if>
					</span>
				</div>

			</div>
		</div>



	</tiles:putAttribute>

</tiles:insertDefinition>
