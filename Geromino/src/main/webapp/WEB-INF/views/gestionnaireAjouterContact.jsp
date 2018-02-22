<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title"
		value="Ajout ou modification d'un contact" />
	<tiles:putAttribute name="content">
		<form:form method="POST" modelAttribute="contact">

			

			<div class="form-group">
				<form:label path="adresse">Adresse :</form:label>
				<form:input path="adresse" type="text" class="form-control"
					name="places" id="exampleInputPassword1" placeholder="Adresse"
					value="${contact.adresse}" />
				<form:errors path="adresse" element="div"
					cssClass="alert alert-danger" />
			</div>

			<div class="form-group">
				<form:label path="date">Date de naissance :</form:label>
				<form:input path="date" type="date" class="form-control"
					name="date" aria-describedby="Help" placeholder="Date de naissance"
					value="${contact.date}" />
				<form:errors path="date" element="div"
					cssClass="alert alert-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="email">Email :</form:label>
				<form:input path="email" type="text" class="form-control"
					name="email" aria-describedby="Help" placeholder="Email"
					value="${contact.email}" />
				<form:errors path="email" element="div"
					cssClass="alert alert-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="nom">Nom :</form:label>
				<form:input path="nom" type="text" class="form-control"
					name="nom" aria-describedby="Help" placeholder="Nom"
					value="${contact.nom}" />
				<form:errors path="nom" element="div"
					cssClass="alert alert-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="prenom">Prenom :</form:label>
				<form:input path="prenom" type="text" class="form-control"
					name="prenom" aria-describedby="Help" placeholder="Prenom"
					value="${contact.prenom}" />
				<form:errors path="prenom" element="div"
					cssClass="alert alert-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="telephone">T�l�phone :</form:label>
				<form:input path="telephone" type="text" class="form-control"
					name="telephone" aria-describedby="Help" placeholder="Telephone"
					value="${contact.telephone}" />
				<form:errors path="telephone" element="div"
					cssClass="alert alert-danger" />
			</div>





			<button type="submit" class="btn btn-success mb-4">Ajouter</button>
			<a href="gestionnaire/gestionnaireContact">
			<button type="button" class="btn btn-danger mb-4">Revenir au menu pr�c�dent</button></a>



		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>