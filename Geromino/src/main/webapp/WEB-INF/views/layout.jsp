<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/Geromino/css/bootstrap.min.css" />
<!-- 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"> -->
		<link rel="stylesheet" href="/Geromino/css/zoneTexte.css" />
		<title>Geromino</title>
	</head>
	<body>
		<script type="assets/js/jquery-3.1.1.min.js"></script>
		<script type="assets/js/popper.min.js"></script>
		<script type="assets/js/bootsrap.min.js"></script>
		
			<div>
				<ul class="nav nav-tabs">
					<li><a href="/Geromino/projet"> Projet</a></li>
					<li><a href="/Geromino/matiere"> Matiere</a></li>
					<li class="disabled"><a href="/Geromino/planification"> Planification</a></li>
					<li><a href="/Geromino/templates"> Templates</a></li>
					<li><a href="/Geromino/formateurs"> Filtre Formateur</a></li>
				 </ul>
			</div>
		
		<section>
			<div class="container">
				<h1>
					<tiles:insertAttribute name="title" />
				</h1>
			
				<tiles:insertAttribute name="content" />
			</div>
		<section>
	</body>
</html>