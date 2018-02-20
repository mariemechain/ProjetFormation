<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Planification" />
	<tiles:putAttribute name="content">





		<div class=" container">


			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">matiere</th>
						<th scope="col">Formateur</th>
						<th scope="col">Edit</th>
					</tr>

				</thead>

				<tbody>
					<c:forEach items="${ planifications }" var="planif">

						<tr>
							<!-- On parcours ,notre list<Produit> et on lui demande de nous afficher juste le nom et le prix(il reconnait tous seul que se sont les attribut
				 d'un produit car c'est ainsi qu'on les appelés la bas et on a fait les dependance -->
							<td>${ planif.id }</td>
							<td>${ planif.matiere.titre }</td>
							<td>${ planif.formateur.nom }</td>


							<!-- Excecution des methodes du controller avec un mapping "/edit" -->
							<td><a href="selectFormateur?id=${planif.id}"
								class="btn btn-warning"><span
									class="glyphicon glyphicon-pencil"></span> Edit Formateur</a> <!-- Excecution des methodes du controller avec un mapping "/delete" -->
								<a href="planification/delete?id=${planif.id }"
								class="btn btn-sm btn-danger"><span
									class="glyphicon glyphicon-remove"></span> Delete Formateur </a>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>