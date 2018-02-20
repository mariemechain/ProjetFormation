<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!--  si je suis connecté, j'affiche le menu de navigation sinon je ne l'affiche pas. -->
<c:if test="${login != null }">


	<nav class="navbar navbar-expand-lg navbar-light bg-light mb-4">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">

			<a class="navbar-brand" href="home">MONIQUE PASSION GESTION DE FORMATION</a> 
			<c:if test="${page == 'home'}">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link" href="home">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="technicien">Techniciens</a></li>
					<li class="nav-item"><a class="nav-link" href="gestionnaire">Gestionnaire</a></li>
					<li class="nav-item"><a class="nav-link" href="personnels">Personnels</a></li>
					<li class="nav-item"><a class="nav-link" href="deconnexion">Déconnexion</a></li>
				</ul>
			</c:if>


			<c:if test="${page == 'technicien'}">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="technicien">Techniciens <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link" href="gestionnaire">Gestionnaire</a></li>
					<li class="nav-item"><a class="nav-link" href="personnels">Personnels</a></li>
					<li class="nav-item"><a class="nav-link" href="deconnexion">Déconnexion</a></li>
				</ul>
			</c:if>

			<c:if test="${page == 'gestionnaire'}">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="technicien">Techniciens
					</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="gestionnaire">Gestionnaire<span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link" href="personnels">Personnels</a></li>
					<li class="nav-item"><a class="nav-link" href="deconnexion">Déconnexion</a></li>
				</ul>
			</c:if>

			<c:if test="${page == 'personnels'}">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="technicien">Techniciens
					</a></li>
					<li class="nav-item"><a class="nav-link" href="gestionnaire">Gestionnaire</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="Personnels">Personnels <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link" href="deconnexion">Déconnexion</a></li>
				</ul>
			</c:if>
			

		</div>
	</nav>





</c:if>

<c:if test="${login == null }">

</c:if>

