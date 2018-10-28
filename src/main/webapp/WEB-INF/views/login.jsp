<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/osat/header.jsp" %>  
<div class="laatikko3">
<c:if test="${not empty loginerror}"><p class="kirjautumisVirhe"><spring:message code="login.kirjautumisvirhe"/></p></c:if>	
<form action="j_spring_security_check" method="post" id="login">
<span class="tietolabel"><spring:message code="login.otsikko"/></span>
<input type="text" maxlength="255" id="j_username" name="j_username" placeholder="<spring:message code="login.username"/>" required></input>
<input type="password" maxlength="255" id="j_password" name="j_password" placeholder="<spring:message code="login.password"/>" required></input>
<input type="submit" value="<spring:message code="login.otsikko"/>">
</form>   
</div>
<%@ include file="/WEB-INF/views/osat/footer.jsp" %>  