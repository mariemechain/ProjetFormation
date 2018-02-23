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
				<br/>
				<br/>
				<form method="post" action="gestionnaire/upload/doUpload"
					enctype="multipart/form-data">
					<table border="0" class="table" style="text-align: center">
						<tr class="col-md-2">
							
							<td><input type="file" name="fileUpload" size="50" /></td>
						</tr>

						<tr class="col-md-2">
							<td colspan="2" align="center"><input type="submit"
								class="btn btn-success" value="Mettre en ligne" /></td>
						</tr>
					</table>
				</form>
				<table class="table" style="text-align: center">
				
					<tr class="col-md-2">
						<td><a href="/Geromino/gestionnaire/gestionnaireMatieres/"
							class="btn btn-danger" role="button" aria-pressed="true">Retour
							aux matières</a></td>

						<td><a href="/Geromino/gestionnaire/upload/download"
							class="btn btn-warning" role="button" aria-pressed="true">Retour
							aux fichiers en ligne</a></td>
							</tr>
							</table>
			</div>


		</div>


	</tiles:putAttribute>

</tiles:insertDefinition>
