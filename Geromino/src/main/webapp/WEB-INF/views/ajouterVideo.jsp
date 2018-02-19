<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
     
<tiles:insertDefinition name="app.layout"> 
 
<tiles:putAttribute name="title" value="Ajouter un videoprojecteur" /> 
 
<tiles:putAttribute name="content"> 
 
<form:form method="POST" modelAttribute="videoprojecteur"> 
<div class="container"> 

<br/> 
      <div class="form-group"> 
          <label for="id">Identifiant :</label> 
          <c:if test="${videoprojecteur.id == null}"> 
          <input name="id" type="text" class="form-control" id="id" value="${videoprojecteur.id}" placeholder="id"> 
 			</c:if>
           <label>${videoprojecteur.id}</label>
        </div> 
        
        <div class="form-group">
					<label for="cout">Coût d'utilisation journalier</label>
					<input name="cout"
						type="number" class="form-control" id="cout"
						value="${videoprojecteur.cout}" placeholder="Cout d'utilisation">
				</div>

				<div class="form-group">
					<label for="date">Date de retour (aaaa/mm/jj)</label>
					<c:if test="${videoprojecteur.id != null}"> 
					<input name="date"
						type="text" class="form-control" id="date"
						value="${videoprojecteur.date}" placeholder="Date de retour">
				</c:if>		
				<label>${videoprojecteur.date}</label>
				</div>
 
 
        <button type="submit" class="btn btn-primary">Submit</button> 
      </div> 
    </form:form> 
 
 
 
</tiles:putAttribute> 
 
 
</tiles:insertDefinition>