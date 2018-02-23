<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	function genPDF() {
		html2canvas(document.getElementById("printable")).then(
				function(canvas) {
					var img = canvas.toDataURL('image/png');
					var doc = new jsPDF();
					doc.addImage(img, 'JPEG', 20, 20);
					doc.save('test.pdf');
				});
	}
</script>

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
							<c:if test="${i==duree_mois_tot[i]}">
								<td rowspan="${duree_mois[i]}">${mois[i]}</td>
							</c:if>
							<td>${dates[i].getDate()}</td>
							<td>${jours[i]}</td>
							<c:if test="${datesDebutMatiere[i]==dates[i]}">
								<td rowspan="${matieresDureeMatiere2[i]}" bgcolor="${couleurs[i]}">${matierePlanning[i]}</td>
							</c:if>
							<c:if test="${datesDebut[i]==dates[i]}">
								<td rowspan="${formateurDuree[i]}">${formateursPrenom2[i]}</td>
							</c:if>
							<c:if test="${datesDebut[i]==dates[i]}">
								<td rowspan="${formateurDuree[i]}">${formateurs2[i]}</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a href="javascript:genPDF()">Exporter au format PDF</a>

	</tiles:putAttribute>
</tiles:insertDefinition>

