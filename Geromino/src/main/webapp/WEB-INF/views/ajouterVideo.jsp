<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    
<tiles:insertDefinition name="app.layout">

<tiles:putAttribute name="title" value="Ajouter ordi" />

<tiles:putAttribute name="content">

<form:form method="POST" modelAttribute="videoprojecteur">
<div class="container">

<h3>Ajouter un videoprojecteur</h3>
<br/>
			<div class="form-group">
					<label for="id">Identifiant :</label> <input name="id"
						type="text" class="form-control" id="id"
						value="${videoprojecteur.id}" placeholder="id">

					
				</div>


				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>



</tiles:putAttribute>


</tiles:insertDefinition>