<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url
	value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"
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
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-center">UTTAB &#124; Centro de Atención al Sector Energético</h2>
				<h1>
					<span class="glyphicon glyphicon-user"></span>&nbsp;
					${sessionScope.nombre}
				</h1>
				<a href="<c:url value='/logout' />"><span
					class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;CERRAR
					SESIÓN</a><br />
				<p class="text-center">The time on the server is ${serverTime}.</p>
				<br />
			</div>
			<div class="col-md-12">
				<table style="width: 50%; margin: 0 auto; text-align: center">
					<thead>
						<tr>
							<td><h2>Catálogos</h2></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a href="<c:url value='/capacitaciones' />">Capacitaciones</a></td>
						</tr>
						<tr>
							<td><a href="<c:url value='/calendarioscapacitaciones' />">Calendario
									de Capacitaciones</a></td>
						</tr>
						<tr>
							<td><a href="<c:url value='/empresas' />">Empresas</a></td>
						</tr>
						<tr>
							<td><a href="<c:url value='/sectoresproductivos' />">Sectores
									Productivos</a></td>
						</tr>
						<tr>
							<td><a href="<c:url value='/status' />">Status</a></td>
						</tr>
						<tr>
							<td><a href="<c:url value='/tiposcapacitaciones' />">Tipo
									Capacitaciones</a></td>
						</tr>
						<tr>
							<td><a href="<c:url value='/tiposinscripciones' />">Tipos
									Inscripciones</a></td>
						</tr>
						<tr>
							<td><a href="<c:url value='/tiposmedioscomunicacion' />">
									Tipo Medios de Comunicación</a></td>
						</tr>
					</tbody>
				</table>
				<br />

				<table style="width: 50%; margin: 0 auto; text-align: center">
					<thead>
						<tr>
							<td><h2>Procesos</h2></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a
								href="<c:url value='/registroscapacitaciones/mailbox"' />">Ir
									a buzón</a>&nbsp;&nbsp; <span class="glyphicon glyphicon-envelope"
								style="font-size: 35px;"></span></td>
						</tr>
					</tbody>
				</table>
				<h3 class="text-center">Powered by Spring MVC 4 & Hibernate 5</h3>
			</div>
		</div>
	</div>
</body>
</html>
