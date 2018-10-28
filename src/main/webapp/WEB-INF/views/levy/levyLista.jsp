<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/osat/header.jsp" %>  
<div id="jarj"><!-- tässä valinnat järjestykselle --></div>
<div id="eiTuloksia">Yhtään levyä ei löytynyt.</div>
<div id="levyt">
<c:forEach items="${levyt}" var="levy">
<a class="levy" id="<c:out value="${levy.id}"/>" href="/musiikkikokoelma/levyt/<c:out value="${levy.id}"/>">
<div class="levykuva" title="<c:out value="${levy.otsikko}"/>" name="<c:out value="${levy.levyArtisti.nimi}"/>" id="<c:out value="${levy.id}"/>">
<img class="placeholder" src="/musiikkikokoelma/resources/images/lata_pink.gif"/>
<img class="kuva" name="eiladattu" src="/musiikkikokoelma/resources/images/lata_pink.gif"/>
</div>
<div class="levykuvaOverlay"></div>
<div class="albumitiedot">
<div class="tiedotVasen">
<h1><c:out value="${levy.otsikko}"/></h1>
<h2><c:out value="${levy.levyArtisti.nimi}"/></h2>
<h2><c:out value="${levy.julkaisuVuosi}"/> (<c:out value="${levy.levyTyyppi.nimi}"/>)</h2>
</div>
<div class="tiedotOikea">
<div class="arvosana"></div><i class="material-icons">star_rate</i><br/><span class="numero"><c:out value="${levy.arvosana}"/></span></div>
</div>
<div class="clear"></div>
</a>
</c:forEach>
<ul id="piilotetut"></ul>
</div>
<div class="sivutus"></div>
<%@ include file="/WEB-INF/views/osat/footer.jsp" %>  