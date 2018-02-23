<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/Geromino/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Geromino/css/bootstrap.min.css" />
<link rel="stylesheet" href="/Geromino/css/zoneTexte.css" />
<link rel="stylesheet" href="/Geromino/css/dispo.css" />
<title>Site professionnel</title>
</head>
<body>
	<nav> <tiles:insertAttribute name="navigation" /> </nav>
	<div class="container">

		<h1>
			<tiles:insertAttribute name="title" />
		</h1>

		<br>
		<tiles:insertAttribute name="content" />
	</div>

	
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/ajouterFormateur.js"></script>
	<script src="js/filtrerTable.js"></script>
	<script src="js/meteoScript.js"></script>
	
	<script src="js/ajouterFormateur.js"></script>
</body>
</html>