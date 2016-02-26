<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:htmlEscape defaultHtmlEscape="false" />
<!DOCTYPE html>
<html lang="es">
<head>
<title>Medios de comunicación | Index</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h3>Medios de comunicación</h3>
    <h4>
		<a href="<c:url value='/medioscomunicacion/new' />">New Medio de comunicación</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
	<c:if test="${!empty listMedioComunicacion}">
		<table class="table tg">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Persona</th>
				<th>Tipo medio de comunicación</th>
				<th>Activo</th>
				<th colspan="2">Operaciones</th>
			</tr>
			<c:forEach items="${listMedioComunicacion}" var="medioComunicacion">
				<tr>
					<td>${medioComunicacion.id}</td>
					<td>${medioComunicacion.persona_id.nombre}</td>
					<td>${medioComunicacion.tipo_medio_comunicacion_id.nombre}</td>
					<td>${medioComunicacion.valor}</td>
					<td><c:choose>
							<c:when test="${medioComunicacion.activo}">Si</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</td>
					<td><a
						href="<c:url value='/medioscomunicacion/${medioComunicacion.id}/edit' />">Edit</a></td>
					<td><a
						href="<c:url value='/medioscomunicacion/${medioComunicacion.id}/destroy' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="<c:url value='/medioscomunicacion/new' />">New Medio de comunicación</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
</body>
</html>