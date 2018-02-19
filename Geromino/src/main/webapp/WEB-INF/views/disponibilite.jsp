<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Disponibilité du matériel" />

	<tiles:putAttribute name="content">
		<div class="container">
			
			<table class="table table-bordered" name="table1">
			
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
						<tr>
							<th scope="row">${liste.date}</th>
							<td>
								<c:if test="${liste.salle <= 10}">
									<td bgcolor=red >${ liste.salle }</td>
								</c:if>
								<c:if test="${liste.salle > 10 && liste.salle <= 30}">
									<td bgcolor=yellow >${ liste.salle }</td>
								</c:if>
								<c:if test="${liste.salle > 30}">
									<td bgcolor=green ></td>
								</c:if>
							</td>
							<td>
								<c:if test="${liste.ordi <= 10}">
									<td bgcolor=red >${ liste.ordi }</td>
								</c:if>
								<c:if test="${liste.ordi > 10 && liste.ordi <= 30}">
									<td bgcolor=yellow >${ liste.ordi }</td>
								</c:if>
								<c:if test="${liste.ordi > 30}">
									<td bgcolor=green ></td>
								</c:if>
							</td>
							<td>
								<c:if test="${liste.video <= 10}">
									<td bgcolor=red >${ liste.video }</td>
								</c:if>
								<c:if test="${liste.video > 10 && liste.video <= 30}">
									<td bgcolor=yellow >${ liste.video }</td>
								</c:if>
								<c:if test="${liste.video > 30}">
									<td bgcolor=green ></td>
								</c:if>
							</td>
					    </tr>
				   	</c:forEach>
				</tbody>
			 
			</table>

		</div>
	</tiles:putAttribute>

</tiles:insertDefinition>