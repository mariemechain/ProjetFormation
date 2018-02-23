<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Upload" />

	<tiles:putAttribute name="content">


		<div class="container">

			<div align="center">
				<h1>Mettre en ligne un fichier</h1>
				<form method="post" action="doUpload" enctype="multipart/form-data">
					<table border="0">
						<tr>
							<td></td>
							<td><input type="file" name="fileUpload" size="50" /></td>
						</tr>
						
						<tr>
							<td colspan="2" align="center"><input type="submit"
								class="btn btn-success" value="Mettre en ligne" /></td>
						</tr>
					</table>
				</form>

				<a href="/Geromino/matiere/" class="btn btn-outline-danger"
					role="button" aria-pressed="true">Retour aux matières</a><a
					href="/Geromino/upload/download" class="btn btn-outline-warning"
					role="button" aria-pressed="true">Retour aux fichiers en ligne</a>

			</div>


		</div>


	</tiles:putAttribute>

</tiles:insertDefinition>
