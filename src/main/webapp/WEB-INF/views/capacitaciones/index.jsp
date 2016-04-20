<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:htmlEscape defaultHtmlEscape="false" />
<!DOCTYPE html>
<html lang="es">
<head>
<title>Capacitaciones | Index</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h3>Capacitaciones</h3>
    <h4>
		<a href="<c:url value='/capacitaciones/new' />">New Capacitaciones</a>
	</h4>
	<h5>
		<a href="<c:url value='/home' />">Back</a>
	</h5>
	<c:if test="${!empty listCapacitacion}">
		<table class="table tg">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Descripción</th>
				<th>Tipo Capacitación</th>
				<th>Activo</th>
				<th>Operaciones</th>
				<!--  <th colspan="2">Operaciones</th> -->
			</tr>
			<c:forEach items="${listCapacitacion}" var="capacitacion">
				<tr>
					<td>${capacitacion.id}</td>
					<td>${capacitacion.nombre}</td>
					<td>${capacitacion.descripcion}</td>
					<td>${capacitacion.tipo_capacitacion_id.nombre}</td>
					<td><c:choose>
							<c:when test="${capacitacion.activo}">Si</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</td>
					<td><a	href="<c:url value='/capacitaciones/${capacitacion.id}/edit' />">Edit</a></td>
					<!--  <td><a	href="<c:url value='/capacitaciones/${capacitacion.id}/destroy' />">Delete</a></td>-->
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="<c:url value='/capacitaciones/new' />">New Capacitaciones</a>
	</h4>
	<h5>
		<a href="<c:url value='/home' />">Back</a>
	</h5>
</body>
</html>