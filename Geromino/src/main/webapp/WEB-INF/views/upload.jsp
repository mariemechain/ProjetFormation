<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">

	<tiles:putAttribute name="title" value="Liste des matieres" />

	<tiles:putAttribute name="content">


		<div class="container">

			<div align="center">
				<h1>Spring MVC - Hibernate File Upload to Database Demo</h1>
				<form method="post" action="doUpload" enctype="multipart/form-data">
					<table border="0">
						<tr>
							<td>Pick file #1:</td>
							<td><input type="file" name="fileUpload" size="50" /></td>
						</tr>
						<tr>
							<td>Pick file #2:</td>
							<td><input type="file" name="fileUpload" size="50" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="Upload" /></td>
						</tr>
					</table>
				</form>
			</div>
			
			
		</div>


	</tiles:putAttribute>

</tiles:insertDefinition>
