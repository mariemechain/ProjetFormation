<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    
<tiles:insertDefinition name="app.layout">

<tiles:putAttribute name="title" value="Technicien" />

<tiles:putAttribute name="content">


<div class="container">
<h3>Liste d'ordinateurs disponibles</h3>
<br/>
<table class="table table-striped">
<c:forEach items="${ ordinateurs }" var="ordinateur">
<thead>
<tr>
<th> Identifiant</th>
<th>Processeur</th>
<th>RAM</th>
<th>Stockage</th>
<th>Option</th>
</tr>
</thead>
<tr>
<td>${ ordinateur.id }  </td> 
<td>${ ordinateur.processeur }  </td> 
<td>${ ordinateur.ram } </td>
<td>${ ordinateur.stockage } </td>
<%-- <td>${ ordinateur.date } </td> --%>
<td><a href="/Geromino/technicien/edit?id=${ordinateur.id}" class="btn btn-outline-success">Modifier</a>
</td>
<td><a href="/Geromino/technicien/ordi/supprimer?id=${ordinateur.id}" class="btn btn-outline-danger">Supprimer</a>
</td>
</tr>
</c:forEach>



</table>
<a href="/Geromino/technicien/ordi/ajouter" class="btn btn-primary">Ajouter</a>

</div>
</tiles:putAttribute>


</tiles:insertDefinition>