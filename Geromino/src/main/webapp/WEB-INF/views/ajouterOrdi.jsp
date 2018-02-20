<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    
<tiles:insertDefinition name="app.layout">

<tiles:putAttribute name="title" value="Ajouter un ordinateur" />

<tiles:putAttribute name="content">

<form:form method="POST" modelAttribute="ordinateur">
<div class="container">


<br/>
				<div class="form-group">
					<label for="id">Identifiant :</label> 
					<c:if test="${ordinateur.id == null}"> 
					<input name="id" type="text" class="form-control" id="id" value="${ordinateur.id}" placeholder="Identifiant">
					</c:if>
					<label>${ordinateur.id}</label>
				</div>


			<div class="form-group">
					<label for="processeur">Processeur :</label> <input name="processeur"
						type="text" class="form-control" id="processeur"
						value="${ordinateur.processeur}" placeholder="Processeur">

					
				</div>
				<div class="form-group">
					<label for="ram">RAM : </label> <input name="ram"
						type="number" class="form-control" id="ram"
						value="${ordinateur.ram}" placeholder="RAM">


				</div>

				<div class="form-group">
					<label for="stockage">Stockage</label>
					<input name="stockage"
						type="number" class="form-control" id="stockage"
						value="${ordinateur.stockage}" placeholder="Stockage">
				</div>
				
				<div class="form-group">
					<label for="achat">Date d'achat (aaaa-mm-jj)</label>
					<input name="achat"
						type="text" class="form-control" id="date"
						value="${ordinateur.achat}" placeholder="achat">
				</div> 
				
				<div class="form-group">
					<label for="cout">Coût d'utilisation journalier</label>
					<input name="cout"
						type="number" class="form-control" id="cout"
						value="${ordinateur.cout}" placeholder="Cout d'utilisation">
				</div>

				
				
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>



</tiles:putAttribute>


</tiles:insertDefinition>