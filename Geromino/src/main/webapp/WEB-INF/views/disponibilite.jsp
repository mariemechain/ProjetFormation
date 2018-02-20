<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Disponibilité du matériel" />


	<tiles:putAttribute name="content">
		<div class="container">

			<div id="carouselExampleControls" class="carousel slide"
				data-ride="carousel" data-interval="false">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="5"></li>

				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<table class="table table-sm">

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
									<c:if test="${liste.id == 1}">
										<tr>
											<th scope="row">${liste.date}</th>
											<!-- 										Salles -->
											<c:if test="${liste.etatSalle <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 10 && liste.etatSalle <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										Ordinateurs -->
											<c:if test="${liste.etatOrdi <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 10 && liste.etatOrdi <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										VideoProjecteurs -->
											<c:if test="${liste.etatVideoProj <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if
												test="${liste.etatVideoProj > 10 && liste.etatVideoProj <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatVideoProj > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>

										</tr>
									</c:if>
								</c:forEach>
							</tbody>

						</table>
					</div>

					<div class="carousel-item">
						<table class="table table-sm">

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
									<c:if test="${liste.id == 2}">
										<tr>
											<th scope="row">${liste.date}</th>
											<!-- 										Salles -->
											<c:if test="${liste.etatSalle <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 10 && liste.etatSalle <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										Ordinateurs -->
											<c:if test="${liste.etatOrdi <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 10 && liste.etatOrdi <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										VideoProjecteurs -->
											<c:if test="${liste.etatVideoProj <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if
												test="${liste.etatVideoProj > 10 && liste.etatVideoProj <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatVideoProj > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>

										</tr>
									</c:if>
								</c:forEach>
							</tbody>

						</table>
					</div>
					<div class="carousel-item">
						<table class="table table-sm">

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
									<c:if test="${liste.id == 3}">
										<tr>
											<th scope="row">${liste.date}</th>
											<!-- 										Salles -->
											<c:if test="${liste.etatSalle <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 10 && liste.etatSalle <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										Ordinateurs -->
											<c:if test="${liste.etatOrdi <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 10 && liste.etatOrdi <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										VideoProjecteurs -->
											<c:if test="${liste.etatVideoProj <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if
												test="${liste.etatVideoProj > 10 && liste.etatVideoProj <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatVideoProj > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>

										</tr>
									</c:if>
								</c:forEach>
							</tbody>

						</table>
					</div>
					<div class="carousel-item">
						<table class="table table-sm">

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
									<c:if test="${liste.id == 4}">
										<tr>
											<th scope="row">${liste.date}</th>
											<!-- 										Salles -->
											<c:if test="${liste.etatSalle <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 10 && liste.etatSalle <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										Ordinateurs -->
											<c:if test="${liste.etatOrdi <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 10 && liste.etatOrdi <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										VideoProjecteurs -->
											<c:if test="${liste.etatVideoProj <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if
												test="${liste.etatVideoProj > 10 && liste.etatVideoProj <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatVideoProj > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>

										</tr>
									</c:if>
								</c:forEach>
							</tbody>

						</table>
					</div>
					<div class="carousel-item">
						<table class="table table-sm">

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
									<c:if test="${liste.id == 5}">
										<tr>
											<th scope="row">${liste.date}</th>
											<!-- 										Salles -->
											<c:if test="${liste.etatSalle <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 10 && liste.etatSalle <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										Ordinateurs -->
											<c:if test="${liste.etatOrdi <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 10 && liste.etatOrdi <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										VideoProjecteurs -->
											<c:if test="${liste.etatVideoProj <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if
												test="${liste.etatVideoProj > 10 && liste.etatVideoProj <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatVideoProj > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>

										</tr>
									</c:if>
								</c:forEach>
							</tbody>

						</table>
					</div>
					<div class="carousel-item">
						<table class="table table-sm">

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
									<c:if test="${liste.id == 6}">
										<tr>
											<th scope="row">${liste.date}</th>
											<!-- 										Salles -->
											<c:if test="${liste.etatSalle <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 10 && liste.etatSalle <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										Ordinateurs -->
											<c:if test="${liste.etatOrdi <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 10 && liste.etatOrdi <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										VideoProjecteurs -->
											<c:if test="${liste.etatVideoProj <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if
												test="${liste.etatVideoProj > 10 && liste.etatVideoProj <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatVideoProj > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>

										</tr>
									</c:if>
								</c:forEach>
							</tbody>

						</table>
					</div>
					<div class="carousel-item">
						<table class="table table-sm">

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
									<c:if test="${liste.id == 7}">
										<tr>
											<th scope="row">${liste.date}</th>
											<!-- 										Salles -->
											<c:if test="${liste.etatSalle <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 10 && liste.etatSalle <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatSalle }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatSalle > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										Ordinateurs -->
											<c:if test="${liste.etatOrdi <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 10 && liste.etatOrdi <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatOrdi }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatOrdi > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>
											<!-- 										VideoProjecteurs -->
											<c:if test="${liste.etatVideoProj <= 10}">
												<td class="text-danger">
													<div class="border border-danger rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if
												test="${liste.etatVideoProj > 10 && liste.etatVideoProj <= 30}">
												<td class="text-warning">
													<div class="border border-warning rounded">${ liste.etatVideoProj }%</div>
												</td>
											</c:if>
											<c:if test="${liste.etatVideoProj > 30}">
												<td class="text-success">
													<div class="border border-success rounded">Bon état
														du stock</div>
												</td>
											</c:if>

										</tr>
									</c:if>
								</c:forEach>
							</tbody>

						</table>
					</div>

				</div>
				<a class="carousel-control-prev" href="#carouselExampleControls"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleControls"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>


	</tiles:putAttribute>

</tiles:insertDefinition>