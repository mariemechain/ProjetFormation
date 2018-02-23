<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<tiles:insertDefinition name="app.layout">

<tiles:putAttribute name="navigation" value="/WEB-INF/views/navigation.jsp" />

<tiles:putAttribute name="content">



   <h2>Liste des formateurs: </h2>
   
<!--#########	Partie Filtre	#########-->


 	<form method="POST" action="">
  	<div class="form-group">
  	<input type="hidden" id="idf" name="idf" value="${formateur.id}">
  	
  	
	<label for="filtre">Filtre:</label>
	
	<div class="form-group">
	<label for="sel1">Niveaux:</label>
 	 <select class="form-control" id="sel1" name="niveau">
    <option value="Debutant">Debutant</option>
    <option value="Intermediaire">Intermediaire</option>
    <option value="Avance">Avance</option>
    <option value="Expert">Expert</option>
 	 </select>
  	</div>
  
  <div class="form-group">
  <label for="sel2">Matières:</label>
  	<select class="form-control" id="sel2" name="matiere">
	  	<c:forEach items="${ listeMatiere }" var="Matieres">
		<option value="${ Matieres.id }">${ Matieres.titre }</option>
		</c:forEach>
  	</select>
  	</div>
  
	<button type="submit" class="btn btn-primary">Filtrer</button>
	<a href="/Geromino/formateurs/liste" class="btn btn-primary" > Annuler Filtre </a>
	</div>
	</form>
 
  <a href="/Geromino/formateurs/ajouter" class="btn btn-success btn-lg" > Ajouter un formateur</a>
  
  
  <!--#########	Liste	#########-->
  
  
  <table class="table table-hover">
    <thead>
      <tr>
        <th>#</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${ listeformateurs }" var="listeFormateurs">
			<tr>
			<td>${ listeFormateurs.id }</td>
			<td>${ listeFormateurs.nom }</td>
			<td>${ listeFormateurs.prenom }</td>
			<td> <a href="/Geromino/formateurs/modifier?idf=${listeFormateurs.id}" class="btn btn-primary">Editer</a><a href="/Geromino/formateurs/supprimer?idf=${listeFormateurs.id}" class="btn btn-danger">Supprimer</a><a href="/Geromino/formateur/liste?idf=${listeFormateurs.id}" class="btn btn-info">Expertise</a></td>
			
			</tr>
	</c:forEach>
    </tbody>
  </table>



</tiles:putAttribute>
</tiles:insertDefinition>
