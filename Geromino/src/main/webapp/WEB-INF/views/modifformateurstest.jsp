<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<tiles:insertDefinition name="app.layout">

<tiles:putAttribute name="navigation" value="/WEB-INF/views/navigation.jsp" />

<tiles:putAttribute name="content">


<c:if test="${ statut == 'ajout' }">
<form method="POST" action="">
  <div class="form-group">
  	<input type="hidden" id="idf" name="idf" value="${formateur.id}">
  	<label for="nom">Nom:</label>
    <input type="text" class="form-control" name="nom" id="nom" value="${formateur.nom}">
    <label for="prenom">Prenom:</label>
    <input type="text" class="form-control" name="prenom" id="prenom" value="${formateur.prenom}">
    <label for="titre">Titre:</label>
    <input type="text" class="form-control" name="titre" id="titre">
  </div>
  <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
</c:if>


<c:if test="${ statut == 'edition' }">
<form method="POST" action="">
  <div class="form-group">
  	<input type="hidden" id="idf" name="idf" value="${formateur.id}">
  	<label for="nom">Nom:</label>
    <input type="text" class="form-control" name="nom" id="nom" value="${formateur.nom}">
    <label for="prenom">Prenom:</label>
    <input type="text" class="form-control" name="prenom" id="prenom" value="${formateur.prenom}">
	<label for="titre">Titre:</label>
    <input type="text" class="form-control" name="titre" id="titre" value="${formateur.titre}">
  </div>
  <button type="submit" class="btn btn-primary">Editer</button>
</form>
</c:if>



</tiles:putAttribute>
</tiles:insertDefinition>
