<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ include file="/WEB-INF/views/osat/header.jsp" %>  
<div class="laatikko">
<h1><spring:message code="etusivu.otsikko"/></h1>
<p><spring:message code="etusivu.eka"/></p>
<p><spring:message code="etusivu.toka"/></p>
<p><spring:message code="etusivu.kolmas"/></p>
<p><spring:message code="etusivu.neljas"/></p>
<p><spring:message code="etusivu.viides"/></p>
<div id="fix"></div>
</div>
<div class="laatikko2"><h2><spring:message code="etusivu.top"/></h2>
<ul>
<c:forEach items="${top10Levyt}" var="levy" varStatus="loop">
<a href="levyt/<c:out value="${levy.id}"/>"><li class="top">
<div class="numba"><c:out value="${loop.index + 1}"/></div><div id="fix"></div>
<div class="einumba">
<c:out value="${levy.otsikko}"/><br/>
<span class="pikku"><c:out value="${levy.levyArtisti.nimi}"/>
<span class="arvostelu"><c:out value="${levy.arvosana}"/></span></span>
</div>
</li>
</a><div id="fix"></div>
</c:forEach>
</ul>
</div>
<%@ include file="/WEB-INF/views/osat/footer.jsp" %>  