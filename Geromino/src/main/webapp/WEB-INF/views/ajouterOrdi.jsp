<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    
<tiles:insertDefinition name="app.layout">

<tiles:putAttribute name="title" value="Ajouter ordi" />

<tiles:putAttribute name="content">

<form:form method="POST" modelAttribute="ordinateur">
<div class="container">

<h3>Ajouter un ordinateur</h3>

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


				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>



</tiles:putAttribute>


</tiles:insertDefinition>