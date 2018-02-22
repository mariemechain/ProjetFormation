<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Cursus ${ Template.nom }" />
	<tiles:putAttribute name="content">

     <table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Matière</th>
						<th scope="col">Durée</th>
						<th scope="col">Prerequis</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ ordreMatieres }" var="ordreMatiere">
						<tr>
							<td>${ ordreMatiere.matiere.titre }</td>
							<td>${ ordreMatiere.matiere.duree } jours</td>
							<c:if test="${ordreMatiere.matiere.prerequis == '[]'}">
								<td>aucun</td>
							</c:if>
							<c:if test="${ordreMatiere.matiere.prerequis != '[]'}">
								<td>
									<c:forEach items="${ordreMatiere.matiere.prerequis}" var="matierePrerequis">
										${matierePrerequis.titre},
									</c:forEach>
								</td>
							<%-- <td>${ordreMatiere.matiere.prerequis} </td> --%>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
				<a class="btn btn-primary" href="/Geromino/templates/modifier/${ Template.id }" role="button">Modifier</a>
				<a class="btn btn-secondary" href="/Geromino/templates" role="button">Retour</a>
			</div>

	</tiles:putAttribute>
</tiles:insertDefinition>