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

    
    <label for="sel1">Niveaux:</label>
  <select class="form-control" id="sel1" name="niveau">
    <option value="Debutant">Debutant</option>
    <option value="Intermediaire">Intermediaire</option>
    <option value="Avance">Avance</option>
    <option value="Expert">Expert</option>
  </select>
  </div>
  
 
  <div class="form-group">
    
    <label for="sel2">Matières:</label>
  	<select class="form-control" id="sel2" name="idM">
	  	<c:forEach items="${ listeMatiere }" var="Matieres">
		<option value="${ Matieres.id }">${ Matieres.titre }</option>
		</c:forEach>
  	</select>
  </div>
  <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
</c:if>


<c:if test="${ statut == 'edition' }">
<form method="POST" action="">
  <div class="form-group">
  	<input type="hidden" id="idf" name="idf" value="${formateur.id}">
    
        <label for="sel1">Editer Niveau:</label>
	  <select class="form-control" id="sel1" name="niveau">
	  
	   <c:if test="${ nivexpertise == 'Debutant' }">
	    <option value="Debutant" selected>Debutant</option>
	     <option value="Intermediaire">Intermediaire</option>
	    <option value="Avance">Avance</option>
	    <option value="Expert">Expert</option>
	    </c:if>
	    
	    <c:if test="${ nivexpertise == 'Intermediaire' }">
	    <option value="Debutant">Debutant</option>
	    <option value="Intermediaire" selected>Intermediaire</option>
	    <option value="Avance">Avance</option>
	    <option value="Expert">Expert</option>
	    </c:if>
	    
	    <c:if test="${ nivexpertise == 'Avance' }">
	    <option value="Debutant">Debutant</option>
	     <option value="Intermediaire">Intermediaire</option>
	    <option value="Avance" selected>Avance</option>
	    <option value="Expert">Expert</option>
	    </c:if>
	    
	    <c:if test="${ nivexpertise == 'Expert' }">
	    <option value="Debutant">Debutant</option>
	     <option value="Intermediaire">Intermediaire</option>
	    <option value="Avance">Avance</option>
	    <option value="Expert" selected>Expert</option>
	    </c:if>
	    
	  </select>
    
  </div>
  <button type="submit" class="btn btn-primary">Editer</button>
</form>
</c:if>



</tiles:putAttribute>
</tiles:insertDefinition>