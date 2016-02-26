<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Calendario de capacitaciones | Index</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h3>Calendario de capacitaciones</h3>
    <h4>
		<a href="<c:url value='/calendarioscapacitaciones/new' />">New Calendario de capacitaciones</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
	<c:if test="${!empty listCalendarioCapacitacion}">
		<table class="table tg">
			<tr>
				<th>ID</th>
				<th>Capacitación</th>
				<th>Fecha inicio</th>
				<th>Fecha Fin</th>
				<th>Activo</th>
				<th colspan="2">Operaciones</th>
			</tr>
			<c:forEach items="${listCalendarioCapacitacion}" var="calendarioCapacitacion">
				<tr>
					<td>${calendarioCapacitacion.id}</td>
					<td>${calendarioCapacitacion.capacitacion_id.nombre}</td>
					<td>${calendarioCapacitacion.fecha_inicio}</td>
					<td>${calendarioCapacitacion.fecha_fin}</td>
					<td><c:choose>
							<c:when test="${calendarioCapacitacion.activo}">Si</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</td>
					<td><a
						href="<c:url value='/calendarioscapacitaciones/${calendarioCapacitacion.id}/edit' />">Edit</a></td>
					<td><a
						href="<c:url value='/calendarioscapacitaciones/${calendarioCapacitacion.id}/destroy' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="<c:url value='/calendarioscapacitaciones/new' />">New Calendario de capacitaciones</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
</body>
</html>