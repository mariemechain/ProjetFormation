<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title"
		value="Liste stagiaires" />

	<tiles:putAttribute name="content">

		<form:form method="POST" modelAttribute="projet">
			<div class="container">

				<br />
				<div class="form-group">
					<label for="id">Identifiant :</label> <label>${projet.nom}</label>
				</div>

				<div class="form-group">
					<label for="dateDebut">Date de début :</label> <label>${projet.dateDebut}</label>
				</div>
				
				<div class="form-group">
					<label for="duree">Durée du projet :</label> <label>${projet.duree} jours</label>
				</div>
				
				<div class="form-group">
					<label for="salle">Salle :</label> <label>${projet.salle.id}</label>
				</div>
				
				<div class="form-group">
					<label for="gestionnaire">Gestionnaire :</label> <label>${projet.gestionnaire.nom}</label>
				</div>
				
						

		<div class="form-group row">
                <label for="stagiaires" class="col-sm-2 col-form-label">Stagiaires : </label> 
                <div class="col-sm-10">
                    <select name="idStagiaire" class="form-control">
                        <c:forEach items="${ stagiaires }" var="stagiaire">
                        <c:if test="${stagiaire.formation == null }">
                            <option value="${ stagiaire.id }">${ stagiaire.nom}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>

				<button type="submit" class="btn btn-success mb-4">Ajouter</button>
				
				
		<table class="table table-striped" style="text-align: center">
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
					<th>Formation</th>
					<th></th>
					

				</tr>
			</thead>
			<c:forEach items="${projet.stagiaires}" var="stagiaire">
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
					<td>${stagiaire.formation.nom}</td>
					
					<td><a
						href="/Geromino/gestionnaire/gestionnaireProjetStagiairesSupprimer?id=${projet.id}&idstag=${stagiaire.id }"><button
								type="button" class="btn btn-danger">X</button></a></td>
				</tr>
			</c:forEach>
		</table>

	</br>
	<h3>Liste des matières et des formateurs :  <a href="gestionnaire/afficheProjet?id=${projet.id}">
			<button type="button" class="btn btn-primary mb-4">Planification</button></a>
			<a href="gestionnaire/gestionnaireProjetStagiaires/${projet.id}/planification">
			<button type="button" class="btn btn-primary mb-4">Ajouter un formateur</button></a>
			 </h3>
			
	
	<table class="table table-striped" style="text-align: center">
			<thead>
				<tr>
					<th>Matières</th>
					<th>Formateurs</th>
				</tr>
			</thead>
			<c:forEach items="${projet.planifications}" var="planification">
				<tr>
					<td>${planification.matiere.titre }</td>
					<td>${planification.formateur.nom }</td>
				</tr>
			</c:forEach>
		</table>
		
	<a href="gestionnaire/gestionnaireProjet">
			<button type="button" class="btn btn-danger mb-4">Revenir au menu précédent</button></a>
			</div>
				
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>
