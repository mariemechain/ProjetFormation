<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Selection Fournisseur" />
	<tiles:putAttribute name="content">


		<div>
			<!-- Selection formateur -->

			<select>
				<c:forEach items="${formateurs }" var="formateur">
					<option>${formateur}
					<option>
				</c:forEach>
			</select>
		</div>


	</tiles:putAttribute>
</tiles:insertDefinition>