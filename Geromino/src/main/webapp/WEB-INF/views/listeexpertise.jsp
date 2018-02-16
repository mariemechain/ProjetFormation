<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<tiles:insertDefinition name="app.layout">

<tiles:putAttribute name="navigation" value="/WEB-INF/views/navigation.jsp" />

<tiles:putAttribute name="content">

<div class="container">
  <h2>Liste des Compétences: {{formateur.nom}}</h2>
  
  <a href="/Geronimo/formateur/ajouter?idf=${formateur.id}" class="btn-success" > Ajouter + </a>
  <table class="table table-dark table-striped">
    <thead>
      <tr>
        <th>#</th>
        <th>Matiere</th>
        <th>Niveau</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${ listeExpertises }" var="listeExpertises">
			<tr>
			<td>${ listeExpertises.id }</td>
			<td>${ listeExpertises.matiere }</td>
			<td>${ listeExpertises.niveau }</td>
			<td> <a href="/Geronimo/formateur/modifier?idf=${formateur.id}&ide=${expertise.id}" class="btn btn-primary">Editer</a><a href="/Geronimo/formateur/supprimer?ide=${expertise.id}" class="btn btn-danger">Supprimer</a></td>
			
			</tr>
	</c:forEach>
    </tbody>
  </table>
</div>


</tiles:putAttribute>
</tiles:insertDefinition>
