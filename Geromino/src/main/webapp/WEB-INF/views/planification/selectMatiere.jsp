<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Select Matiere" />
	<tiles:putAttribute name="content">


		<div>
			<!-- Selection matiere -->

			<select>
				<c:forEach items="${matieres }" var="matiere">
					<option>${matiere.nom}
					<option>
				</c:forEach>
			</select>
		</div>
		<button name="" type="submit" class="btn btn-primary btn-info">Valider</button>



	</tiles:putAttribute>
</tiles:insertDefinition>