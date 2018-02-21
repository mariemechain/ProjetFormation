<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Liste des matieres" />

	<tiles:putAttribute name="content">


		<div class="container">

			<div align="center">
				<h1>Files have been uploaded successfully!</h1>
			</div>

		</div>


	</tiles:putAttribute>

</tiles:insertDefinition>