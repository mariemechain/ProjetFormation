<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Geromino/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/Geromino/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
	<link rel="stylesheet"
	href="/Geromino/assets/css/zoneTexte.css" />
<title>Insert title here</title>
</head>
<body>
	<script type="assets/js/jquery-3.1.1.min.js"></script>
	<script type="assets/js/popper.min.js"></script>
	<script type="assets/js/bootsrap.min.js"></script>
<head>
<a href="projet"> Projet</a>
<a href="matiere"> matiere</a>
<a href="planification"> planification</a>
<a href="templates"> templates</a>
<a href="formateurs"> filtre formateur</a>
</head>

	



<div class="container">
	<h1>
		<tiles:insertAttribute name="title" />
	</h1>

	<br>
	<tiles:insertAttribute name="content" />
</div>



</body>
</html>