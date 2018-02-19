<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Select Matiere" />
	<tiles:putAttribute name="content">

		<form method="post">
			<div>
				<!-- Selection matiere -->

				<select name="selectMat">
					<c:forEach items="${matieres}" var="matiere">
						<!-- Ce que j'ai dans value est la valeur que je recupere en parametre dans mon url -->
						<option value="${matiere}">${matiere.nom}</option>
					</c:forEach>
				</select>
			</div>
			<button name="" type="submit" class="btn btn-primary btn-info">Valider</button>
		</form>






	</tiles:putAttribute>
</tiles:insertDefinition>