<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Création d'un projet" />
	<tiles:putAttribute name="content">

		<form:form method="POST" modelAttribute="projet">
			<!-- On assigne un Id au projet, mais normalement c'est autogenerer d'ou le commentaire de la partie  -->
			<div class="form-group row">
				<label for="nom" class="col-sm-2 col-form-label">Nom</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nom" name="nom"
						value="${ projet.nom }" placeholder="Nom" />
				</div>
			</div>

			<div class="form-group row">
				<label for="debut" class="col-sm-2 col-form-label">Date de début</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="debut" name="dateDebut"
						   value="<fmt:formatDate pattern="yyyy-MM-dd" value="${ projet.dateDebut }" />"
						   placeholder="Date de début" />
				</div>
			</div>

			<div class="form-group row">
				<label for="salles" class="col-sm-2 col-form-label">Salle</label> 
				<div class="col-sm-10">
					<select name="idSalle" class="form-control">
						<c:forEach items="${ salles }" var="salle">
							<option value="${ salle.id }">${ salle.id}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="templates" class="col-sm-2 col-form-label">Template</label> 
				<div class="col-sm-10">
					<select name="idTemplate" class="form-control">
						<c:forEach items="${ templates }" var="template">
							<option value="${ template.id }">${ template.nom}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</div>
			</div>

			<br>

		</form:form>

	</tiles:putAttribute>
</tiles:insertDefinition>
