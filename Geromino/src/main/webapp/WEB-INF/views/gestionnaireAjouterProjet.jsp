<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title"
		value="Ajout ou modification d'une salle" />
	<tiles:putAttribute name="content">
		<form:form method="POST" modelAttribute="projet">

			<div class="form-group">
				<form:label path="id">Id :</form:label>
				<form:input path="id" type="text" class="form-control" name="id"
					aria-describedby="Help" placeholder="Id" value="${projet.id}" />
				<form:errors path="id" element="div" cssClass="alert alert-danger" />
			</div>

			<div class="form-group">
				<form:label path="XXX">XXX :</form:label>
				<form:input path="XXX" type="XXX" class="form-control"
					name="XXX" id="exampleInputPassword1" placeholder="XXX"
					value="${projet.XXX }" />
				<form:errors path="XXX" element="div"
					cssClass="alert alert-danger" />
			</div>

			<div class="form-group">
				<form:label path="duree">Durée :</form:label>
				<form:input path="duree" type="text" class="form-control"
					name="duree" aria-describedby="Help" placeholder="duree"
					value="${projet.duree}" />
				<form:errors path="duree" element="div"
					cssClass="alert alert-danger" />
			</div>
            
            <div class="form-group row">
				<label for="prix" class="col-sm-2 col-form-label">Stagiaires
					:</label>
				<div class="col-sm-10>">
					<form:select path="contact.id" items="${stagiaires}"
						itemLabel="nom" itemValue="id" cssClass="form-control" />
				</div>
			</div>
			
			 <div class="form-group row">
				<label for="prix" class="col-sm-2 col-form-label">Gestionnaires
					:</label>
				<div class="col-sm-10>">
					<form:select path="gestionnaire.id" items="${gestionnaires}"
						itemLabel="nom" itemValue="id" cssClass="form-control" />
				</div>
			</div>



			<div class="form-group">
				<form:label path="debut">Date de début :</form:label>
				<form:input path="debut" type="text" class="form-control"
					name="debut" aria-describedby="Help" placeholder="debut"
					value="${projet.debut}" />
				<form:errors path="debut" element="div"
					cssClass="alert alert-danger" />
			</div>



			<button type="submit" class="btn btn-success">Ajouter</button>


			<a href="/Geromino/gestionnaire/gestionnaireProjet"><button type="button"
					class="btn btn-danger">Revenir au menu précédent</button></a>
		

		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>