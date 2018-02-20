<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Menu du gestionnaire" />
	<tiles:putAttribute name="content">


		<table class="table table-striped">

			<thead>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tr>
				<td><a href="/Geromino/gestionnaire/gestionnaireSalle"><button
							type="button" class="btn btn-success">Gestion des salles</button></a>
				</td>
				<td><a href="/Geromino/gestionnaire/gestionnaireProjet"><button
							type="button" class="btn btn-info">Gestion des projets</button></a></td>
				<td><a href="/Geromino/gestionnaire/gestionnaireFormateur"><button
							type="button" class="btn btn-danger ">Gestion des
							formateurs</button></a></td>
				<td><a href="/Geromino/gestionnaire/gestionnaireContact"><button
							type="button" class="btn btn-warning ">Gestion des
							contacts</button></a></td>
				<td><a href="/Geromino/gestionnaire/gestionnaireCursus"><button
							type="button" class="btn btn-warning ">Gestion des
							cursus</button></a></td>
		</table>

	</tiles:putAttribute>
</tiles:insertDefinition>