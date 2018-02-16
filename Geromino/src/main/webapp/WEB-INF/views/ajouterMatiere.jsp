<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Ajout d'une matière" />
	
	<tiles:putAttribute name="content">
		<form:form method="post" modelAttribute="matiere">
			<table>
				<tr>
					<td><form:label path="titre">Titre</form:label></td>
				    <td><form:input path="titre" /></td>
			    </tr>
				<tr>
					<td><form:label path="duree">Durée</form:label></td>
				    <td><form:input path="duree" /></td>
			    </tr>
				<tr>
				    <td><form:label path="objectif">Objectifs</form:label></td>
				    <td><form:input path="objectif" /></td>
			    </tr>
				<tr>
				    <td><form:label path="fournisseur">Fournisseur</form:label></td>
				    <td><select name="idFournisseur" class="custom-select" path="fournisseur"> 
				    	  <option selected>Selection d'un fournisseur</option>
				    	  <c:forEach items="${fournisseurs}" var="fournisseur">
						  		<option value="${fournisseur.id}">${fournisseur.societe}</option>
						  </c:forEach>
					</select></td>
				</tr>
			</table>
		    
		    <button type="submit" class="btn btn-outline-success" value="Valider"> Ajouter un produit</button>
		</form:form>	
	</tiles:putAttribute>
	
</tiles:insertDefinition>