<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!--  si je suis connecté, j'affiche le menu de navigation sinon je ne l'affiche pas. -->
<%-- <c:if test="${login != null }"> --%>


<nav class="navbar navbar-expand-lg navbar-light bg-light mb-4">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarTogglerDemo01">

		<!--  <a class="navbar-brand" href="#">Hidden brand</a>  -->
		<c:if test="${page == 'technicien'}">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="/Geromino/technicien">Techniciens <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/Geromino/gestionnaire">Gestionnaire</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Geromino/technicien">Matière</a></li>
				<li class="nav-item"><a class="nav-link"
					href="Geromino/home">Déconnexion</a></li>
			</ul>
		</c:if>

		<c:if test="${page == 'gestionnaire'}">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link"
					href="/Geromino/technicien">Techniciens </a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/Geromino/gestionnaire">Gestionnaire<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/Geromino/gestionnaire">Matières</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Geromino/home">Déconnexion</a></li>
			</ul>
		</c:if>

		<c:if test="${page == 'matiere'}">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link"
					href="/Geromino/technicien">Techniciens </a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Geromino/gestionnaire">Gestionnaire</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/Geromino/gestionnaire">Matières <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/TetrisFinal/deconnexion">Déconnexion</a></li>
			</ul>
		</c:if>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Chercher!</button>
		</form>
	</div>
</nav>





<%-- </c:if>
    
    <c:if test="${login == null }">
        
    </c:if>  --%>

