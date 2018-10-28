<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/osat/header.jsp" %>  
<div class="laatikko4">
<input type="text" id="artistiHaku" onkeyup="artistiHaku()" placeholder="<spring:message code="artisti.haku"/>">
<ul id="artistiLista">
<c:forEach items="${levyArtistit}" var="levyArtisti"><a title="<c:out value="${levyArtisti.nimi}"/>" href="/musiikkikokoelma/levyt/#<c:out value="${levyArtisti.nimi}"/>">
<li><span><c:out value="${levyArtisti.nimi}"/></span><br>
(<c:out value="${levyArtisti.levyMaara}"/><c:if test="${levyArtisti.levyMaara == 1}"><spring:message code="artisti.yksilevy"/></c:if><c:if test="${levyArtisti.levyMaara > 1}"><spring:message code="artisti.montalevya"/></c:if>)</li>
</a>
</c:forEach>
</ul>
</div>
<%@ include file="/WEB-INF/views/osat/footer.jsp" %>  