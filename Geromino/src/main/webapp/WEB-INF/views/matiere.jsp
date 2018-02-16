<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Liste des matieres" />
	
	<tiles:putAttribute name="content">
	
		<div class="container-fluid">
			<div class="row align-items-center">
   				<div class="col-2">
     				<div class="list-group">
     					<c:forEach items="${matieres}" var="m">
				        	<button  class="list-group-item">${m.titre}</button>
 				        	<a href="/Geromino/matiere/editer?id=${m.id}" class="list-group-item">Modifier</a>
<%-- 				        	<a href="/Geromino/matiere/supprimer?id=${m.id}" class="list-group-item">Supprimer</a> --%>
				        </c:forEach>
				    </div>
    			</div>
    			
    			<div class="col-1">
    			</div>
    			
    			<div class="col-8">
    				<p class="zoneTexte"></p>
	    				<h2>Details de la matière sélectionnée :</h2>
	    				<c:if test="detailMatiere!=null">
		    				<p> Durée de la matière : {detailMatiere.duree} jour</p>
		    				<p> Objectif de la matière : {detailMatiere.objectif}</p>
		    				<p> Prérequis de la matière : {detailMatiere.prerequis}</p>
		    				<p> Contenu de la matière : {detailMatiere.contenu}</p>
	    				</c:if>
	    		
    			</div>
    			
			</div>
		</div>
	</tiles:putAttribute>

</tiles:insertDefinition>
	