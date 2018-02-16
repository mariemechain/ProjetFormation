<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Ajout ou modification d'une salle" />
	<tiles:putAttribute name="content">
		<form:form method="POST" modelAttribute="salles">
		
			<div class="form-group">			
				<form:label path="id">Id :</form:label>
				<form:input path="id" type="text" class="form-control"
					name="id" aria-describedby="Help" placeholder="Id"
					value="${salle.id}" />
				<form:errors path="id" element="div"
					cssClass="alert alert-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="places">Nombre de places :</form:label>
				<form:input path="places" type="number" class="form-control"
					name="places" id="exampleInputPassword1" placeholder="Places"
					value="${salle.places }" />
				<form:errors path="places" element="div" cssClass="alert alert-danger" />
			</div>

			<div class="form-group">			
				<form:label path="adresse">Adresse :</form:label>
				<form:input path="adresse" type="text" class="form-control"
					name="adresse" aria-describedby="Help" placeholder="Adresse"
					value="${salle.adresse}" />
				<form:errors path="adresse" element="div"
					cssClass="alert alert-danger" />
			</div>

			<%-- <div class="form-group">
				<form:label path="contact">Contact :</form:label>
				<form:input path="contact" type="text" class="form-control"
					name="contact" aria-describedby="Help" placeholder="Contact"
					value="${salle.contact}" />
				<form:errors path="contact" element="div"
					cssClass="alert alert-danger" />
			</div> --%>
			
			<%-- <div class="form-group">
				<form:label path="videoprojecteur">VideoProjecteur :</form:label>
				<form:input path="videoprojecteur" type="text" class="form-control"
					name="videoprojecteur" aria-describedby="Help" placeholder="VideoProjecteur"
					value="${salle.videoprojecteur}" />
				<form:errors path="videoprojecteur" element="div"
					cssClass="alert alert-danger" />
			</div> --%>

			<button type="submit" class="btn btn-danger">Ajouter</button>



		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>