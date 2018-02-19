<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Accueil" />
	<tiles:putAttribute name="content">
		<p></p>
		<p>Bonjour et bienvenue ${login} sur ta page d'accueil</p>


	</tiles:putAttribute>
</tiles:insertDefinition>
