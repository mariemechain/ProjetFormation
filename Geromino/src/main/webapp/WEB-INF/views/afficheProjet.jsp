<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Planning d'un projet" />
	<tiles:putAttribute name="content">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Mois</th>
					<th colspan="2">Date</th>
					<th>Module</th>
					<th>Formateurs</th>
					<th>Titres</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" begin="0" end="${duree}">
					<tr>
						<td>${mois[i]}</td>
						<td>${dates[i].getDate()}</td>
						<td>${jours[i]}</td>
						<td>plup</td>
						<c:if test="${i==0}">
							<td rowspan="${duree}">PAPA</td>
							<td rowspan="${duree}">MAMAN</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</tiles:putAttribute>
</tiles:insertDefinition>
>
