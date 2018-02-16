<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Technicien" />

	<tiles:putAttribute name="content">


<div class="container">
<br/>
<h3>Interface Technicien</h3>
<br/>
<a href="/Geromino/technicien/ordi" class="btn btn-secondary mr-4">Liste ordinateurs</a><a href="/Geromino/technicien/video" class="btn btn-secondary">Liste vidéoprojecteurs</a>





		</div>

	</tiles:putAttribute>


</tiles:insertDefinition>
