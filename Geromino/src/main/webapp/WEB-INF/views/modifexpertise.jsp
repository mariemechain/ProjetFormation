<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<tiles:insertDefinition name="app.layout">

<tiles:putAttribute name="navigation" value="/WEB-INF/views/navigation.jsp" />

<tiles:putAttribute name="content">


<c:if test="${ statut == 'ajout' }">
<form method="POST" action="">
  <div class="form-group">
  	<input type="hidden" id="idf" name="idf" value="${formateur.id}">
    <label for="niveau">Niveau:</label>
    <input type="text" class="form-control" name="niveau" id="niveau">
  </div>
  <div class="form-group">
    <label for="idM">Matiere:</label>
    <input type="text" class="form-control" name="idM" id="idM">
    
  </div>
  <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
</c:if>


<c:if test="${ statut == 'edition' }">
<form method="POST" action="">
  <div class="form-group">
  	<input type="hidden" id="idf" name="idf" value="${formateur.id}">
    <label for="niveau">Niveau:</label>
    <c:if test="${ expertise.id == 1 }">
    <input type="text" class="form-control" name="niveau" id="niveau" value="Debutant">
    </c:if>
    <c:if test="${ expertise.id == 2 }">
    <input type="text" class="form-control" name="niveau" id="niveau" value="Intermediaire">
    </c:if>
    <c:if test="${ expertise.id == 3 }">
    <input type="text" class="form-control" name="niveau" id="niveau" value="Avance">
    </c:if>
    <c:if test="${ expertise.id == 4 }">
    <input type="text" class="form-control" name="niveau" id="niveau" value="Expert">
    </c:if>
    
  </div>
  <button type="submit" class="btn btn-primary">Editer</button>
</form>
</c:if>



</tiles:putAttribute>
</tiles:insertDefinition>