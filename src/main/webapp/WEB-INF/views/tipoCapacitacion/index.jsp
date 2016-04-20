<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Tipo(s) Capacitacion(es) | Index</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h3>Tipo(s) Capacitacion(es)</h3>
    <h4>
		<a href="<c:url value='/tiposcapacitaciones/new' />">New Tipo
			Capacitación</a>
	</h4>
	<h5>
		<a href="<c:url value='/home' />">Back</a>
	</h5>
	<c:if test="${!empty listTipoCapacitacion}">
		<table class="table tg">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Activo</th>
				<!-- <th colspan="2">Operaciones</th> -->
				<th colspan="2">Operaciones</th>
			</tr>
			<c:forEach items="${listTipoCapacitacion}" var="tipoCapacitacion">
				<tr>
					<td>${tipoCapacitacion.id}</td>
					<td>${tipoCapacitacion.nombre}</td>
					<td><c:choose>
							<c:when test="${tipoCapacitacion.activo}">Si</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
				    </td>
					<td><a	href="<c:url value='/tiposcapacitaciones/${tipoCapacitacion.id}/edit' />">Edit</a></td>
					<!--  <td><a	href="<c:url value='/tiposcapacitaciones/${tipoCapacitacion.id}/destroy' />">Delete</a></td>-->
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="<c:url value='/tiposcapacitaciones/new' />">New Tipo
			Capacitación</a>
	</h4>
	<h5>
		<a href="<c:url value='/home' />">Back</a>
	</h5>
</body>
</html>