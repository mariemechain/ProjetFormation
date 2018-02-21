<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Success" />

	<tiles:putAttribute name="content">


		<div class="container">

			<div align="center">
				<h1>Le fichier a bien été envoyé</h1>
			</div>

			<a href="/Geromino/matiere/" class="btn btn-outline-primary"
				role="button" aria-pressed="true">Retour aux matières</a>

		</div>


	</tiles:putAttribute>

</tiles:insertDefinition>