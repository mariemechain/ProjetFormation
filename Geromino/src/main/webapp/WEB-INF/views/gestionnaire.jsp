<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Menu du gestionnaire" />
	<tiles:putAttribute name="content">
		<div>
			<a href="/Geromino/gestionnaire/gestionnaireSalle"><button type="button"
					class="btn btn-success">Gestion des salles</button></a>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>