<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
    function StartPrintProcess(){
            window.print();
    }
</script>
    
<tiles:insertDefinition name="app.layout">
    <tiles:putAttribute name="title" value="Planning d'un projet" />
    <tiles:putAttribute name="content">
        <div id="printable">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th style="width:100px;">Mois</th>
                        <th style="width:100px;" colspan="2">Date</th>
                        <th>Module</th>
                        <th style="width:100px;">Formateurs</th>
                        <th style="width:100px;">Titres</th>
                    </tr>
                </thead>
                
                <tbody>
                    <c:forEach var="i" begin="0" end="${duree-1}">
                        <tr>
                            <c:if test="${i==duree_mois_tot[i]}">
                                <td  rowspan="${duree_mois[i]}"><div class="divcolonne" style="height:${duree_mois[i]*48}px;"><b>${mois[i]}</b></div></td>
                            </c:if>
                            <td style="width: 40px;">${dates[i].getDate()}</td>
                            <td>${jours[i]}</td>
                            <c:if test="${datesDebutMatiere[i]==dates[i]}">
                                <td style="padding:0;" rowspan="${matieresDureeMatiere2[i]}" ><div  style="background:${couleurs[i]};height:${matieresDureeMatiere2[i]*53}px;" class="matiere"><b>${matierePlanning[i]}</b></div></td>
                            </c:if>
                            <c:if test="${datesDebut[i]==dates[i]}">
                                <td rowspan="${formateurDuree[i]}"><div class="divcolonne" style="height:${formateurDuree[i]*48}px;"><b>${formateursPrenom2[i]}</b></div></td>
                            </c:if>
                            <c:if test="${datesDebut[i]==dates[i]}">
                                <td rowspan="${formateurDuree[i]}"><div class="divcolonne" style="height:${formateurDuree[i]*48}px;"><b>${formateurs2[i]}</b></div></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
<a class="btn btn-secondary" href="javascript:StartPrintProcess()">Imprimer/Exporter en pdf</a>
    </tiles:putAttribute>
</tiles:insertDefinition>