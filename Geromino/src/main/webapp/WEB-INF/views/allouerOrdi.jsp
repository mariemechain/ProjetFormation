<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<tiles:insertDefinition name="app.layout">

<tiles:putAttribute name="title" value="Allouer un ordinateur à un stagiaire" />

<tiles:putAttribute name="content">

<form:form method="POST" >
<div class="container">

<br/>
				<div class="form-group">
					<label for="id">Identifiant :</label> 
					<label>${ordinateur.id}</label>
				</div>


			<div class="form-group">
					<label for="processeur">Processeur :</label> 
					<label>${ordinateur.processeur}</label>
		
			</div>
				<div class="form-group">
					<label for="ram">RAM : </label> 
					<label>${ordinateur.ram}</label>
				</div>
					
				<div class="form-group">
					<label for="stockage">Stockage</label>
					<label>${ordinateur.stockage}</label>
				</div>
				
				<div class="form-group">
					<label for="achat">Date d'achat :</label>
					<label>${ordinateur.achat}</label>
				</div> 
				
				<div class="form-group">
					<label for="cout">Coût d'utilisation journalier :</label>
					<label>${ordinateur.cout}</label>
				</div>

				<div class="form-group">
					<label for="date">Date de retour :</label>
					<label>${ordinateur.date}</label>
				</div>
				
				<div class="form-group">
					<label for="stagiaires">Stagiaires :</label>
					<select  name="stagiaires">
					
					<c:forEach items="${stagiaires}" var = "stagiaire">
					<c:if test="${stagiaire.ordinateur == null && stagiaire.formation != null}">
					 <option value="${stagiaire.id}">${stagiaire.nom}</option>
						</c:if>			 
					</c:forEach>
					
					</select>

				</div>

				<button type="submit" class="btn btn-success">Envoyer</button>
				<a href="/Geromino/technicien/ordi"><button
					type="button" class="btn btn-danger">Revenir au menu précedent</button></a>
			</div>
		</form:form>



</tiles:putAttribute>


</tiles:insertDefinition>