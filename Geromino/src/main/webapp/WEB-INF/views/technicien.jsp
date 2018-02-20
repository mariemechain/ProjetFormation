<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">
<c:if test="${utilisateur.type == 'Gestionnaire'}">
	<tiles:putAttribute name="title" value="Gestion du Technicien" />
</c:if>
<c:if test="${utilisateur.type != 'Gestionnaire'}">
<tiles:putAttribute name="title" value="Menu du Technicien" />
</c:if>
	<tiles:putAttribute name="content">


		<div class="container">
			<br /> <br /> <a href="/Geromino/technicien/ordi"
				class="btn btn-success mr-4">Liste ordinateurs</a><a
				href="/Geromino/technicien/video" class="btn btn-info">Liste
				vidéoprojecteurs</a>





		</div>

	</tiles:putAttribute>


</tiles:insertDefinition>
