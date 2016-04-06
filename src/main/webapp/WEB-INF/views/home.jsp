<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url
	value="/resources/css/bootswatch/united/bootstrap.min.css"
	var="bootstrapCSS" />
<spring:url
	value="/resources/bower_components/jquery/dist/jquery.min.js"
	var="jquery" />
<spring:url
	value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"
	var="bootstrap" />
<!DOCTYPE html>
<html lang="es">
<head>
	<title>UTTAB &#124; Centro de Atención al Sector Energético</title>
	<link href="${bootstrapCSS}" rel="stylesheet" />
</head>
<body>
<h2>UTTAB &#124; Centro de Atención al Sector Energético</h2>
<p> The time on the server is ${serverTime}. </p>
<h2>Catálogos</h2>
<a href="<c:url value='/capacitaciones' />">Capacitaciones</a><br/>
<a href="<c:url value='/calendarioscapacitaciones' />">Calendario de Capacitaciones</a><br/>
<a href="<c:url value='/empresas' />">Empresas</a><br/>
<a href="<c:url value='/sectoresproductivos' />">Sectores Productivos</a><br/>
<a href="<c:url value='/status' />">Status</a><br/>
<a href="<c:url value='/tiposcapacitaciones' />">Tipo Capacitaciones</a><br/>
<a href="<c:url value='/tiposinscripciones' />">Tipos Inscripciones</a><br/>
<a href="<c:url value='/tiposmedioscomunicacion' />">Tipo Medios de Comunicación</a><br/>
<!--  <a href="<c:url value='/usuarios' />">Usuarios</a><br/>-->
<!--  <a href="<c:url value='/personas' />">Personas</a><br/>-->
<!--  <a href="<c:url value='/medioscomunicacion' />">Medios de comunicación</a><br/>-->
<!--  <a href="<c:url value='/registroscapacitaciones' />">Registro de capacitaciones</a><br/>-->
<h2>Procesos</h2>
<a href="<c:url value='/registroscapacitaciones/mailbox"' />">Ir a buzón</a><br/>
<h3>Powered by Spring MVC 4 & Hibernate 5</h3>
</body>
</html>
