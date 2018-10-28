<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/osat/header.jsp" %>  
<div class="laatikko3">
<form action="uusi" method="post" id="lisaaLevy">
<span class="tietolabel"><spring:message code="levy.otsikko"/></span>
<input type="text" maxlength="255" id="otsikko" name="otsikko" placeholder="<spring:message code="levy.otsikkoesimerkki"/>" required></input>
<br>
<span class="tietolabel"><spring:message code="levy.artisti"/></span>
<input type="text" maxlength="255" id="artisti" name="artisti" placeholder="<spring:message code="levy.artistiesimerkki"/>" required></input>
<input type="submit" value="<spring:message code="levy.lisaa"/>">
</form>
</div>
<%@ include file="/WEB-INF/views/osat/footer.jsp" %>  