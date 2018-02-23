<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="navigation"
		value="/WEB-INF/views/navigation.jsp" />

	<tiles:putAttribute name="content">



		<h2>Ajout de matiere</h2>

		
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Matiere</th>
					<th>Choix</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ matieres2 }" var="matiere">
					<tr>
						<td>${ matiere.id }</td>
						<td>${ matiere.titre }</td>
						<td><a href="choixMat?idm=${matiere.id}">add</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		

	</tiles:putAttribute>
</tiles:insertDefinition>
