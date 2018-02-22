<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title"
		value="Ajout ou modification du personnel" />
	<tiles:putAttribute name="content">
		<form:form method="POST" modelAttribute="personnel">

			<div class="form-group">
				<label for="stagiaires">Type :</label>
				<c:if test="${personnel.id == 0}">
					<select onchange="activerBouton() ; changementType() "
						id="personnels" name="personnels">

						<option value="null">--</option>
						<option value="Formateur">Formateur</option>
						<option value="Technicien">Technicien</option>
						<option value="Gestionnaire">Gestionnaire</option>
						<option value="Administrateur">Admin</option>
					</select>
				</c:if>

				<c:if test="${personnel.id != 0}">
					<label>${personnel.type }</label>
				</c:if>
			</div>

			<div class="form-group">
				<form:label path="adresse">Adresse :</form:label>
				<form:input path="adresse" type="text" class="form-control"
					name="places" id="exampleInputPassword1" placeholder="Adresse"
					value="${personnel.adresse}" />
				<form:errors path="adresse" element="div"
					cssClass="alert alert-danger" />
			</div>

			<div class="form-group">
				<form:label path="date">Date de naissance :</form:label>
				<form:input path="date" type="date" class="form-control" name="date"
					aria-describedby="Help" placeholder="Date de naissance"
					value="${personnel.date}" />
				<form:errors path="date" element="div" cssClass="alert alert-danger" />
			</div>

			<div class="form-group">
				<form:label path="email">Email :</form:label>
				<form:input path="email" type="text" class="form-control"
					name="email" aria-describedby="Help" placeholder="Email"
					value="${personnel.email}" />
				<form:errors path="email" element="div"
					cssClass="alert alert-danger" />
			</div>

			<div class="form-group">
				<form:label path="nom">Nom :</form:label>
				<form:input path="nom" type="text" class="form-control" name="nom"
					aria-describedby="Help" placeholder="Nom" value="${personnel.nom}" />
				<form:errors path="nom" element="div" cssClass="alert alert-danger" />
			</div>

			<div class="form-group">
				<form:label path="prenom">Prenom :</form:label>
				<form:input path="prenom" type="text" class="form-control"
					name="prenom" aria-describedby="Help" placeholder="Prenom"
					value="${personnel.prenom}" />
				<form:errors path="prenom" element="div"
					cssClass="alert alert-danger" />
			</div>

			<div class="form-group">
				<form:label path="telephone">Téléphone :</form:label>
				<form:input path="telephone" type="text" class="form-control"
					name="telephone" aria-describedby="Help" placeholder="Telephone"
					value="${personnel.telephone}" />
				<form:errors path="telephone" element="div"
					cssClass="alert alert-danger" />
			</div>
			<div class="form-group" id="login">
				<form:label path="login">Login :</form:label>
				<form:input path="login" type="text" class="form-control"
					name="login" aria-describedby="Help" placeholder="Login"
					value="${personnel.login}" />
				<form:errors path="login" element="div"
					cssClass="alert alert-danger" />
			</div>
			<div class="form-group" id="password">
				<form:label path="motDePasse">Password :</form:label>
				<form:input path="motDePasse" type="text" class="form-control"
					name="motDePasse" aria-describedby="Help" placeholder="Password"
					value="${personnel.motDePasse}" />
				<form:errors path="motDePasse" element="div"
					cssClass="alert alert-danger" />
			</div>


			<c:if test="${personnel.id == 0}">
				<div class="form-group" id="titre">
					<label>Titre :</label> <input type="text" class="form-control"
						name="titre" aria-describedby="Help" placeholder="titre" />
					
				</div>
				<div class="form-group" id="patience">
					<label>Indice de patience :</label> <input type="number"
						class="form-control" name="patience" aria-describedby="Help"
						placeholder="Indice de patience" />
					
				</div>
			</c:if> 

			<c:if test="${personnel.type == 'Formateur' && personnel.id != 0}">
				<div class="form-group" id="titre2">
					<label>Titre :</label> <input type="text" class="form-control"
						name="titre" aria-describedby="Help" placeholder="titre" />
						
				</div>
				<div class="form-group" id="patience2">
					<label>Indice de patience :</label> <input type="number"
						class="form-control" name="patience" aria-describedby="Help"
						placeholder="Indice de patience" />
						
				</div>
			</c:if>

 			<c:if test="${personnel.id == 0}">
				<button type="submit" class="btn btn-success" disabled="disabled"
					id="bouton1" title="Veuillez choisir un type"
					style="cursor: not-allowed">Ajouter</button>
				<a href="/Geromino/admin">
					<button type="button" class="btn btn-danger">Revenir au
						menu principal</button> 
						
			</c:if>
			<c:if test="${personnel.id != 0}">
				<button type="submit" class="btn btn-success">Ajouter</button>
				<a href="/Geromino/admin">
					<button type="button" class="btn btn-danger">Revenir au
						menu principal</button>
			</c:if>
			</a>

		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>