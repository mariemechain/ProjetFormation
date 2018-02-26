<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Connexion" />

	<tiles:putAttribute name="content">

		<c:if test="${isErreur == true }">
			<div class="alert alert-danger">
				L'identifiant ou le mot de passe n'est pas le bon
			</div>
		
		
		</c:if>
			<form method="POST" class="px-4 py-3">
				<div class="form-group">
					<!-- <label for="identifiants">Identifiants</label>  -->
					<input type="text" name="login" class="form-control"
						id="identifiants" placeholder="Identifiants">
				</div>
				<div class="form-group">
					<!-- <label for="motDePasse">Mot de passe</label>  -->
					<input type="password" name="motDePasse" class="form-control"
						id="motDePasse" placeholder="Mot de Passe">
				</div>
				
				<button type="submit" class="btn btn-primary">Se connecter</button>
			</form>
			<div class="dropdown-divider"></div>
			
	</tiles:putAttribute>
</tiles:insertDefinition>