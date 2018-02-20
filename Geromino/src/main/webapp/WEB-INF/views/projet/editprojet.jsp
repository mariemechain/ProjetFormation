<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Edition d'un projet" />
	<tiles:putAttribute name="content">


		<form:form method="POST" modelAttribute="projet">
			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">ID</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" name="template"
						value="${ projet.id }" placeholder="ID" />
				</div>
			</div>

			<div class="form-group row">
				<label for="nom" class="col-sm-2 col-form-label">Nom</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nom" name="nom"
						value="${ projet.nom }" placeholder="Nom" />
				</div>
			</div>


			<div class="form-group row">
				<label for="date de debut" class="col-sm-2 col-form-label">Date
					de début</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="date de debut"
						name="date de debut" value="${ projet.debut }"
						placeholder="Date de début" />
				</div>
			</div>

			<%--  
			<div class="form-group row">
				<label for="planification" class="col-sm-2 col-form-label">Planification</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="planification"
						name="plannification" value="${ projet.planification }"
						placeholder="Planification" />
				</div>
			</div>  
			--%>




			<div class="form-group row">
				<label for="duree" class="col-sm-2 col-form-label">Durée</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="duree" name="duree"
						value="${ projet.duree }" placeholder="Duree" />
				</div>
			</div>


			<label>Salle</label>
			<select name="idSalle" class="form-control">
				<c:forEach items="${ salle }" var="salle">
					<option value="${ salle.id }">${ salle.adresse }</option>
				</c:forEach>
			</select>


			<%-- 
			<div class="form-group row">
				<label for="stagiaires" class="col-sm-2 col-form-label">Stagiaire</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="stagiaires" name="stagiaires"
						value="${ projet.stagiaires }" placeholder="Stagiaires" />
				</div>
			</div>
			--%>
			
			<!--Reorientation sur /Geromino/planification  -->
			<td><a href="../planification?id=${projet.id }"
				class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span>
					Planification</a>


	            <button type="submit" class="btn btn-success">Modifier</button>
			
				
			


		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>