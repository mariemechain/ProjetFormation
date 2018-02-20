<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Ajouter un ordinateur" />

	<tiles:putAttribute name="content">

		<form:form method="POST" modelAttribute="ordinateur">
			<div class="container">


				<br />
				<div class="form-group">
					<label for="id">Identifiant :</label>
					<c:if test="${ordinateur.id == null || ordinateur.id==''}">
						<input name="id" type="text" class="form-control" id="id"
							value="${ordinateur.id}" placeholder="Identifiant">
						<form:errors path="id" element="div" cssClass="alert alert-danger" />
					</c:if>
					<label>${ordinateur.id}</label>
				</div>


				<div class="form-group">
					<form:label path="processeur">Processeur :</form:label>
					<form:input path="processeur" type="text" class="form-control"
						name="processeur" aria-describedby="Help" placeholder="Processeur"
						value="${ordinateur.processeur}" />
					<form:errors path="processeur" element="div"
						cssClass="alert alert-danger" />
				</div>

				<%-- <div class="form-group">
					<label for="processeur">Processeur :</label> <input
						name="processeur" type="text" class="form-control" id="processeur"
						value="${ordinateur.processeur}" placeholder="Processeur">
					<form:errors path="processeur" element="div"
						cssClass="alert alert-danger" />
				</div> --%>


				<div class="form-group">
					<form:label path="ram">RAM :</form:label>
					<form:input path="ram" type="number" class="form-control"
						name="ram" id="exampleInputPassword1" placeholder="Ram"
						value="${ordinateur.ram }" />
					<form:errors path="ram" element="div" cssClass="alert alert-danger" />
				</div>

				<div class="form-group">
					<form:label path="stockage">Stockage :</form:label>
					<form:input path="stockage" type="number" class="form-control"
						name="stockage" id="exampleInputPassword1" placeholder="Stockage"
						value="${ordinateur.stockage }" />
					<form:errors path="stockage" element="div"
						cssClass="alert alert-danger" />
				</div>

				<%-- <div class="form-group">
					<label for="stockage">Stockage</label> <input name="stockage"
						type="number" class="form-control" id="stockage"
						value="${ordinateur.stockage}" placeholder="Stockage">
					<form:errors path="stockage" element="div"
						cssClass="alert alert-danger" />
				</div> --%>

				<div class="form-group">
					<label for="achat">Date d'achat (aaaa-mm-jj)</label> <input
						name="achat" type="date" class="form-control" id="date"
						value="${ordinateur.achat}" placeholder="date d'achat">
					<form:errors path="achat" element="div"
						cssClass="alert alert-danger" />
				</div>

				<div class="form-group">
					<label for="cout">Coût d'utilisation journalier</label> <input
						name="cout" type="number" class="form-control" id="cout"
						value="${ordinateur.cout}" placeholder="Cout d'utilisation">
					<form:errors path="cout" element="div"
						cssClass="alert alert-danger" />
				</div>




				<button type="submit" class="btn btn-success">Ajouter</button>
				<a href="/Geromino/technicien/ordi">
					<button type="button" class="btn btn-danger">Revenir au
						menu précédent</button>
				</a>
			</div>
		</form:form>



	</tiles:putAttribute>


</tiles:insertDefinition>