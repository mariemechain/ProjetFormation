<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Planning d'un projet" />
	<tiles:putAttribute name="content">
		<div id="printable">
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
					<c:forEach var="i" begin="0" end="${duree-1}">
						<tr>
							<c:choose>
								<c:when test="${i==0}">
									<td rowspan="${duree_mois[0]+1}">${mois[0]}</td>
								</c:when>
								<c:when test="${i==duree_mois[0]+1}">
									<td rowspan="${duree_mois[duree_mois[0]+1]}">${mois[duree_mois[0]+1]}</td>
								</c:when>
								<c:when test="${i==duree_mois[1]+duree_mois[0]+1}">
									<td rowspan="${duree_mois[duree_mois[1]+duree_mois[0]+1]}">C${mois[duree_mois[1]+duree_mois[0]+1]}</td>
								</c:when>
								<c:when test="${i==duree_mois[2]+duree_mois[1]+duree_mois[0]+1}">
									<td
										rowspan="${duree_mois[duree_mois[2]+duree_mois[1]+duree_mois[0]+1]}">${duree_mois[2]+duree_mois[1]+duree_mois[0]+1}</td>
								</c:when>
								<c:when
									test="${i==duree_mois[3]+duree_mois[2]+duree_mois[1]+duree_mois[0]+1}">
									<td rowspan="${duree_mois[4]}">${mois[4]}</td>
								</c:when>
							</c:choose>
							<td>${dates[i].getDate()}</td>
							<td>${jours[i]}</td>
							<td>${matieres[i]}</td>
							<c:if test="${i==0}">
								<td rowspan="${duree}">PAPA</td>
								<td rowspan="${duree}">MAMAN</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
>
