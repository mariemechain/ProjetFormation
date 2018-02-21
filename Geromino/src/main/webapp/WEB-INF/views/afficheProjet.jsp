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
									<td rowspan="${duree_mois[i+1]+1}">${mois[i]}</td>
								</c:when>
								<c:when test="${i==duree_mois[1]+1}">
									<td rowspan="${duree_mois[i+1]+1}">${mois[i]}</td>
								</c:when>
								<c:when test="${i==duree_mois[2]+1}">
									<td rowspan="${duree_mois[i+1]+1}">${mois[i]}</td>
								</c:when>
								<c:when test="${i==duree_mois[3]+1}">
									<td rowspan="${duree_mois[i+1]+1}">${mois[i]}</td>
								</c:when>
								<c:when test="${i==duree_mois[4]+1}">
									<td rowspan="${duree_mois[i+1]+1}">${mois[i]}</td>
								</c:when>
							</c:choose>
							<td>${dates[i].getDate()}</td>
							<td>${jours[i]}</td>
							<c:if test="${i==0}">
								<td rowspan="${matieres_duree[i]}">${matieres[i]}</td>
							</c:if>
							<c:if test="${i==0}">
								<td rowspan="${matieres_duree[i]}">PAPA</td>
								<td rowspan="${matieres_duree[i]}">MAMAN</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			Gros bouton export PDF
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

