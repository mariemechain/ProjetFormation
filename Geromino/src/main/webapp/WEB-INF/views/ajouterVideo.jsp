<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Ajouter un videoprojecteur" />

	<tiles:putAttribute name="content">

		<form:form method="POST" modelAttribute="videoprojecteur">
			<div class="container">

				<br />
				<div class="form-group">
					<label for="id">Identifiant :</label>
					<c:if
						test="${videoprojecteur.id == null || videoprojecteur.id== ''}">
						<input name="id" type="text" class="form-control" id="id"
							value="${videoprojecteur.id}" placeholder="id">
						<form:errors path="id" element="div" cssClass="alert alert-danger" />
					</c:if>
					<label>${videoprojecteur.id}</label>
				</div>

				<div class="form-group">
					<label for="cout">Coût d'utilisation journalier</label> <input
						name="cout" type="number" class="form-control" id="cout"
						value="${videoprojecteur.cout}" placeholder="Cout d'utilisation">
					<form:errors path="cout" element="div"
						cssClass="alert alert-danger" />
				</div>

				<c:if
					test="${videoprojecteur.id != null && videoprojecteur.id== '' }">
					<div class="form-group">
						<label for="date">Date de retour (aaaa-mm-jj)</label> <input
							name="date" type="date" class="form-control" id="date"
							value="${videoprojecteur.date}" placeholder="Date de retour">
						<form:errors path="date" element="div"
							cssClass="alert alert-danger" />

						<%-- <c:if test="${ videoprojecteur.id== ''}">
					<label>${videoprojecteur.date}</label>
					</c:if> --%>
					</div>
				</c:if>

				<button type="submit" class="btn btn-primary">Ajouter</button>
				<a href="/Geromino/technicien/video">
					<button type="button" class="btn btn-danger">Revenir au
						menu précédent</button>
				</a>
			</div>
		</form:form>



	</tiles:putAttribute>


</tiles:insertDefinition>