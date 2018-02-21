<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Cr�ation d'un projet" />
	<tiles:putAttribute name="content">

		<form:form method="POST" modelAttribute="projet">
			<div class="form-group row">
				<label for="nom" class="col-sm-2 col-form-label">Nom</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nom" name="nom" value="${ projet.nom }" placeholder="Nom" />
				</div>
			</div>

			 <div class="form-group row">
				<label for="dateDebut" class="col-sm-2 col-form-label">Date de d�but</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="dateDebut" name="dateDebut"
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${ projet.dateDebut }" />"
						placeholder="Date debut" />
				</div>
			</div> 

			
			<div class="form-group row">
				<label for="duree" class="col-sm-2 col-form-label">Dur�e</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="duree" name="duree"
						value="${ projet.duree }" placeholder="Duree" />
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

<%--
			<div class="form-group row">
				<label for="cursus" class="col-sm-2 col-form-label">Cursus</label>
				<div class="col-sm-10">
					<select name="idCursus" class="form-control">
						<c:forEach items="${ cursus }" var="planifications">
							<option value="${ cursus.id }">${ cursus.template }</option>
						</c:forEach>
					</select>
				</div>
			</div>
 --%>
			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</div>
			</div>
		</form:form>

	</tiles:putAttribute>
</tiles:insertDefinition>