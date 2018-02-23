<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Edition d'un projet" />
	<tiles:putAttribute name="content">
	
		<form:form method="POST" modelAttribute="projet">
			<div class="form-group row">
				<label for="nom" class="col-sm-2 col-form-label">Nom</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nom" name="nom"
						value="${ projet.nom }" placeholder="Nom" />
				</div>
			</div>

			<div class="form-group row">
				<label for="date de debut" class="col-sm-2 col-form-label">Date de d�but</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="date de debut" name="dateDebut" 
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${ projet.dateDebut }" />"
						placeholder="Date de d�but" />
				</div>
			</div>

			<div class="form-group row">
				<label for="salles" class="col-sm-2 col-form-label">Salle</label>
				<div class="col-sm-10">
					<select name="idSal" class="form-control">
						<c:forEach items="${ salles }" var="sal">
							<option value="${ sal.id }" 
								<c:if test="${ projet.salle.id == sal.id }"> selected </c:if> >${ sal.id }
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="templates" class="col-sm-2 col-form-label">Template</label> 
				<div class="col-sm-10">
					<select name="idTemplate" class="form-control">
						<c:forEach items="${ templates }" var="template">
							<option value="${ template.id }"
								<c:if test="${ projet.nomTemplate == template.nom }"> selected </c:if> >${ template.nom}
							</option>
						</c:forEach>
					</select>
				</div>
			</div>

            <button type="submit" class="btn btn-success">Modifier</button>
			
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>