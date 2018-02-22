<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Selection Fournisseur" />
	<tiles:putAttribute name="content">

		<form method="post">

			<div>
				<!-- Selection formateur -->

				<select name="selectForm">
					<c:forEach items="${formateurs }" var="formateur">
						<!-- Ce que j'ai dans value est la valeur que je recupere en parametre dans mon url pour la recuperer avec requestParam dans le controller -->
						<option value="${formateur.id }">${formateur.nom}</option>
					</c:forEach>
				</select>
			</div>
			<br>
			<button name="" type="submit" class="btn btn-primary btn-info">Valider</button>
		</form>
	</tiles:putAttribute>
</tiles:insertDefinition>