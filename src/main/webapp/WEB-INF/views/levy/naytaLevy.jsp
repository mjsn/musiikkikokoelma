<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/osat/header.jsp" %>  
<form id="levyMuokkaus" action="muokkaa" method="POST">
<div class="laatikko">
<sec:authorize access="hasRole('ROLE_ADMIN')">
<div class="muokkaa" id="muokkaaLevy"><a class="muokkaa" title="<spring:message code="levy.muuta"/>" href="#muokkaa"><i class="material-icons">edit</i></a></div>
<div class="tallennaperuuta" id="muokkaaLevy"><a title="<spring:message code="levy.levykuva"/>" class="haeKuva" name="<c:out value="${levy.id}"/>" href="/musiikkikokoelma/levyt/levykuva?id=<c:out value="${levy.id}"/>&u=1"><i class="material-icons">refresh</i></a><a title="<spring:message code="levy.tallenna"/>" class="tallenna" href="#"><i class="material-icons">save</i></a><a title="<spring:message code="levy.poista"/>" class="poista" href="#"><i class="material-icons">delete_forever</i></a><a title="<spring:message code="levy.peruuta"/>" class="peruuta" href="#"><i class="material-icons">close</i></a></div>
</sec:authorize>
<sec:authorize access="!hasRole('ROLE_ADMIN')">
<div class="muokkaa" id="muokkaaLevy"><a title="<spring:message code="levy.muuta"/>" href="/musiikkikokoelma/login"><i class="material-icons">edit</i></a></div>
</sec:authorize>
<div class="levykuva" title="<c:out value="${levy.otsikko}"/>" name="<c:out value="${levy.levyArtisti.nimi}"/>" id="<c:out value="${levy.id}"/>">
<img class="placeholder" style="opacity:0" src="/musiikkikokoelma/resources/images/lata_pink.gif"/>
<img class="kuva" name="eiladattu" style="opacity:1" src="/musiikkikokoelma/resources/images/lata_pink.gif"/>
</div>
<div id="levytiedot">
<input type="hidden" name="id" value="${levy.id}">
<ul>
<li class="otsikko"><span class="tietolabel"><spring:message code="levy.otsikko"/></span><input minlength="1" maxlength="255" type="text" name="otsikko" id="otsikko" value="<c:out value="${levy.otsikko}"/>" disabled required></li>
<li class="artisti"><span class="tietolabel"><spring:message code="levy.artisti"/><a id="artistiHaku" title="<spring:message code="levy.haeartisti"/>" href="/musiikkikokoelma/levyt/#<c:out value="${levy.levyArtisti.nimi}"/>"><i class="material-icons">search</i></a></span><input minlength="1" maxlength="255" type="text" name="artisti" id="artisti" value="<c:out value="${levy.levyArtisti.nimi}"/>" disabled required></li>
<li class="julkaisuVuosi"><span class="tietolabel"><spring:message code="levy.julkaisuvuosi"/></span><input minlength="4" maxlength="4" size="4" name="julkaisuVuosi" type="number" id="julkaisuVuosi" value="<c:out value="${levy.julkaisuVuosi}"/>" disabled></li>
<li class="levyGenre"><span class="tietolabel"><spring:message code="levy.genre"/></span>
<select name="genre" id="genre" disabled>
<c:forEach items="${levyGenret}" var="levyGenre">
<c:choose>
<c:when test="${levyGenre.nimi eq levy.levyGenre.nimi}">
<option value="<c:out value="${levyGenre.id}"/>" selected><spring:message code="levy.genre.${levyGenre.id}"/></option>
</c:when>
<c:otherwise>
<option value="<c:out value="${levyGenre.id}"/>"><spring:message code="levy.genre.${levyGenre.id}"/></option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</li>
<li class="arvosana"><span class="tietolabel"><spring:message code="levy.arvosana"/></span><input maxlength="1" name="arvosana" id="arvosana" value="<c:out value="${levy.arvosana}"/>" type="hidden"><span name="arvosana" class="arvostelu"><c:out value="${levy.arvosana}"/></span></li>
<li class="levytunnus"><span class="tietolabel"><spring:message code="levy.tunnus"/></span><input maxlength="20" name="tunnus" type="text" id="tunnus" value="<c:out value="${levy.tunnus}"/>" disabled></li>
<li class="levyMaara"><span class="tietolabel"><spring:message code="levy.levymaara"/></span><input maxlength="2" type="number" name="levyMaara" id="levyMaara" value="<c:out value="${levy.levyMaara}"/>" disabled></li>
<li class="levyTyyppi"><span class="tietolabel"><spring:message code="levy.tyyppi"/></span>
<select name="tyyppi" id="tyyppi" disabled>
<c:forEach items="${levyTyypit}" var="levyTyyppi">
<c:choose>
<c:when test="${levyTyyppi.nimi eq levy.levyTyyppi.nimi}">
<option value="<c:out value="${levyTyyppi.id}"/>" selected><c:out value="${levyTyyppi.nimi}"/></option>
</c:when>
<c:otherwise>
<option value="<c:out value="${levyTyyppi.id}"/>"><c:out value="${levyTyyppi.nimi}"/></option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
</li>
<li class="levyKunto"><span class="tietolabel"><spring:message code="levy.levykunto"/></span><input maxlength="1" name="levyKunto" id="levyKunto" value="<c:out value="${levy.levyKunto}"/>" type="hidden"><span name="levyKunto" class="arvostelu"><c:out value="${levy.levyKunto}"/></span></li>
<li class="kansiKunto"><span class="tietolabel"><spring:message code="levy.kansikunto"/></span><input maxlength="1" name="kansiKunto" id="kansiKunto" value="<c:out value="${levy.kansiKunto}"/>" type="hidden"><span name="kansiKunto" class="arvostelu"><c:out value="${levy.kansiKunto}"/></span></li>
</ul>
</div>
<div id="fix"></div>
</div>
<div class="laatikko2">
<div id="muutaTietoa">
<span class="tietolabel"><spring:message code="levy.muutatietoa"/></span>
<input type="text" maxlength="255" name="muutaTietoa" value="<c:out value="${levy.muutaTietoa}"/>" disabled>
</div>
<span class="tietolabel"><spring:message code="levy.kappalelista"/></span>
<ol type="1" id="kappalelista" title="<c:out value="${levy.otsikko}"/>" name="<c:out value="${levy.levyArtisti.nimi}"/>"><i><spring:message code="levy.kappalelistalataus"/></i></ol>
</div>
</form>
<form id="levyPoisto" action="poista" method="POST"><input type="hidden" name="id" value="<c:out value="${levy.id}"/>"></form>
<%@ include file="/WEB-INF/views/osat/footer.jsp" %>  
