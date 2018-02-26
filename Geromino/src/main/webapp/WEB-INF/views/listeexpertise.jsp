<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<tiles:insertDefinition name="app.layout">

<tiles:putAttribute name="navigation" value="/WEB-INF/views/navigation.jsp" />

<tiles:putAttribute name="content">

<!-- <div class="container"> -->

  <h2>Formateur: </h2>         
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Informations</th>
      </tr>
    </thead>
    <tbody>
     <tr>
        <td>${formateur.nom}</td>
      </tr>
      <tr>
        <td>${formateur.prenom}</td>
      </tr>
      </tbody>
     </table>
 
  <a href="/Geromino/formateur/ajouter?idf=${formateur.id}" class="btn btn-success btn-lg" > Ajouter une compétence</a>
  <a href="/Geromino/admin" class="btn btn-info">Retour</a>
  <table class="table table-hover">
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
			<td>${ listeExpertises.matiere.titre }</td>
			<td>${ listeExpertises.niveau }</td>
			<td> <a href="/Geromino/formateur/modifier?idf=${formateur.id}&ide=${listeExpertises.id}" class="btn btn-primary">Editer</a><a href="/Geromino/formateur/supprimer?idf=${formateur.id}&ide=${listeExpertises.id}" class="btn btn-danger">Supprimer</a></td>
			
			</tr>
	</c:forEach>
    </tbody>
  </table>
<!-- </div> -->


</tiles:putAttribute>
</tiles:insertDefinition>

