<%@ page trimDirectiveWhitespaces="true" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=480px, initial-scale=1, maximum-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><spring:message code="otsikko"/></title>
<link href="//fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="//fonts.googleapis.com/earlyaccess/roundedmplus1c.css" rel="stylesheet">
<link rel="stylesheet" href="/musiikkikokoelma/resources/styles/style.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/musiikkikokoelma/resources/javascript/jPages.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/localization/messages_<spring:message code="lokaali"/>.min.js"></script>
<script src="/musiikkikokoelma/resources/javascript/jquery.ajax-retry.min.js"></script> 
<script src="//cdnjs.cloudflare.com/ajax/libs/tinysort/2.3.6/tinysort.js"></script> 
<script>
var nykyinenSivu = "<%=this.getClass().getSimpleName().replaceFirst("_jsp","")%>";
var poistetaanko = "<spring:message code="levy.poistetaanko"/>";
var poistetaanko2 = poistetaanko;
var kappalelistaVirhe = "<spring:message code="levy.kappalelistavirhe"/>";
</script>
</head>
<body>
<div id="yla">
<div id="ylasis">
<div class="vasen">
<h1><a href="/musiikkikokoelma/"><spring:message code="otsikko"/></a></h1>
</div>
<div class="oikee">
<input placeholder="<spring:message code="navigaatio.haku"/>"><span title="<spring:message code="navigaatio.hakutyhjennys"/>" id="resetoiHaku" href="#"><i class="material-icons">close</i></span>
<button id="hae">search</button>
<a class="kielivaihto" title="<spring:message code="kielivaihtonimi"/>" href="?lang=<spring:message code="kielivaihto"/>"><button id="account">language</button></a>
<sec:authorize access="!hasRole('ROLE_ADMIN')">
<a title="<spring:message code="navigaatio.sisaan"/>" href="/musiikkikokoelma/login"><button id="account">account_circle</button></a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a title="<spring:message code="navigaatio.ulos"/>" href="/musiikkikokoelma/logout"><button id="account">cancel</button></a>
</sec:authorize>
</div>
<div class="keski">
<a class="levyLista naytaLevy" href="/musiikkikokoelma/levyt/"><spring:message code="navigaatio.levyt"/></a>
<a class="artistiLista" href="/musiikkikokoelma/artistit/"><spring:message code="navigaatio.artistit"/></a>
<a class="uusiLevy" href="/musiikkikokoelma/levyt/uusi"><spring:message code="navigaatio.lisaa"/></a>
</div>
</div>
</div>
<div id="sis">