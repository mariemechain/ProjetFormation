<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" href="/Geromino/css/dispo.css" />

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Disponibilité du matériel" />

	<tiles:putAttribute name="content">
		<div class="container">
		
			<c:forEach var = "i" begin = "1" end = "6">
			
				<table class="table table-bordered table-sm">
				
					<thead>
						<tr>
							<th scope="col">Date</th>
							<th scope="col">Salles</th>
							<th scope="col">Ordinateurs</th>
							<th scope="col">Vidéoprojecteurs</th>
						</tr>
					</thead>
				  
					<tbody>
						<c:forEach items="${liste}" var="liste">
							<c:if test="${liste.id == i}">
								<tr>
									<th scope="row">${liste.date}</th>
<!-- 										Salles -->
										<c:if test="${liste.etatSalle <= 10}">
											<td bgcolor=#ff0c0c>${ liste.etatSalle }%</td>
										</c:if>
										<c:if test="${liste.etatSalle > 10 && liste.etatSalle <= 30}">
											<td bgcolor="#ffef1c" >${ liste.etatSalle }%</td>
										</c:if>
										<c:if test="${liste.etatSalle > 30}">
											<td bgcolor=#57f72e >Bon état du stock</td>
										</c:if>
<!-- 										Ordinateurs -->
										<c:if test="${liste.etatOrdi <= 10}">
											<td bgcolor=#ff0c0c >${ liste.etatOrdi }%</td>
										</c:if>
										<c:if test="${liste.etatOrdi > 10 && liste.etatOrdi <= 30}">
											<td bgcolor="#ffef1c" >${ liste.etatOrdi }%</td>
										</c:if>
										<c:if test="${liste.etatOrdi > 30}">
											<td bgcolor=#57f72e >Bon état du stock</td>
										</c:if>
<!-- 										VideoProjecteurs -->
										<c:if test="${liste.etatVideoProj <= 10}">
											<td bgcolor=#ff0c0c >${ liste.etatVideoProj }%</td>
										</c:if>
										<c:if test="${liste.etatVideoProj > 10 && liste.etatVideoProj <= 30}">
											<td bgcolor="#ffef1c" >${ liste.etatVideoProj }%</td>
										</c:if>
										<c:if test="${liste.etatVideoProj > 30}">
											<td bgcolor=#57f72e >Bon état du stock</td>
										</c:if>

							    </tr>
							</c:if>
					   	</c:forEach>
					</tbody>
				 
				</table>
			</c:forEach>
		</div>
	</tiles:putAttribute>

</tiles:insertDefinition>