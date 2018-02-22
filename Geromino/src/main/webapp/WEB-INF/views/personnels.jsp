<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Administrateur" />

	<tiles:putAttribute name="content">


		<div class="container-fluid">
			<h3>Liste personnels</h3>
			<br />
			<table style="width:100%" class="table table-striped"  id="myTable" >
				<thead style ="text-align:center; vertical-align:middle">
					<tr id="colonneP">
						<th style="width:5%"> <p onclick="visi1()" title="Cliquez pour filtrer" style="cursor: pointer;">Id</p><input type="text" type = "hidden" id="myInput1" onkeyup="myFunction1()" size="3" ></th>
						<th style="width:10%"> <p onclick="visi2()" title="Cliquez pour filtrer" style="cursor: pointer;">Nom </p><input type="text" id="myInput2" onkeyup="myFunction2()"  size="8" id="foo"></th>
						<th style="width:10%"> <p onclick="visi3()" title="Cliquez pour filtrer" style="cursor: pointer;">Prénom</p><input type="text" id="myInput3" onkeyup="myFunction3()"  size="8"></th>
						<th style="width:20%"> <p onclick="visi4()" title="Cliquez pour filtrer" style="cursor: pointer;">E-Mail</p><input type="text" id="myInput4" onkeyup="myFunction4()" size="15"></th>
						<th style="width:20%"> <p onclick="visi5()" title="Cliquez pour filtrer" style="cursor: pointer;">Type</p><input type="text" id="myInput5" onkeyup="myFunction5()" size="15"></th>
						<th style="width:35%"></th>

					</tr>
				</thead>
				<c:forEach items="${ personnels }" var="personnel">

					<tr id="ligne">
						<td>${ personnel.id }</td>
						<td>${ personnel.nom }</td>
						<td>${ personnel.prenom }</td>
						<td>${ personnel.email }</td>
						<td>${personnel.type}</td>
						<td><a
							href="/Geromino/adminEditerPersonnel?id=${personnel.id}"
							class="btn btn-primary">Modifier</a>
							<a
							href="/Geromino/adminSupprimerPersonnel?id=${personnel.id}"
							class="btn btn-danger">X</a>
							<c:if test="${personnel.type == 'Formateur'}">
							<a
							href="/Geromino/formateur/liste?idf=${personnel.id}"
							class="btn btn-dark">Expertise</a>
							</c:if></td>


					</tr>
				</c:forEach>



			</table>
			<a href="/Geromino/adminAjouterPersonnel" class="btn btn-success">Ajouter un personnel</a>
			<a href="gestionnaire/"> <a href="/Geromino/home">
					<button type="button" class="btn btn-danger">Revenir au
						menu précédent</button>
			</a>

		</div>
		

	</tiles:putAttribute>


</tiles:insertDefinition>