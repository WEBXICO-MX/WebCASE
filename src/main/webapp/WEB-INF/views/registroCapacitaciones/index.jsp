<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:htmlEscape defaultHtmlEscape="false" />
<!DOCTYPE html>
<html lang="es">
<head>
<title>Registro a capacitaciones | Index</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h3>Registro a capacitaciones </h3>
    <h4>
		<a href="<c:url value='/registroscapacitaciones/new' />">New Registro a capacitaciones </a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
	<c:if test="${!empty listRegistroCapacitacion}">
		<table class="table tg">
			<tr>
				<th>ID</th>
				<th>Capacitación</th>
				<th>Tipo de inscripción</th>
				<th>Persona</th>
				<th>Empresa</th>
				<th>Status</th>
				<th>Fecha de registro</th>
				<th>Fecha de modificación</th>
				<th>Activo</th>
				<th colspan="2">Operaciones</th>
			</tr>
			<c:forEach items="${listRegistroCapacitacion}" var="registroCapacitacion">
				<tr>
					<td>${registroCapacitacion.id}</td>
					<td>${registroCapacitacion.calendario_capacitacion_id.capacitacion_id.nombre} | Fecha inicio: ${registroCapacitacion.calendario_capacitacion_id.fecha_inicio} | Fecha fin: ${registroCapacitacion.calendario_capacitacion_id.fecha_fin}</td>
					<td>${registroCapacitacion.tipo_inscripcion_id.nombre}</td>
					<td>${registroCapacitacion.persona_id.nombre} ${registroCapacitacion.persona_id.ap_paterno} ${registroCapacitacion.persona_id.ap_materno}</td>
					<td>${registroCapacitacion.empresa_id.nombre}</td>
					<td>${registroCapacitacion.status_id.nombre}</td>
					<td>${registroCapacitacion.fecha_registro}</td>
					<td>${registroCapacitacion.fecha_modificacion}</td>
					<td><c:choose>
							<c:when test="${registroCapacitacion.activo}">Si</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</td>
					<td><a
						href="<c:url value='/registroscapacitaciones/${registroCapacitacion.id}/edit' />">Edit</a></td>
					<td><a
						href="<c:url value='/registroscapacitaciones/${registroCapacitacion.id}/destroy' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="<c:url value='/registroscapacitaciones/new' />">New Registro a capacitaciones </a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
</body>
</html>