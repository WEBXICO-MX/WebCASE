<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Persona(s) | Index</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h3>Persona(s)</h3>
	<h4>
		<a href="<c:url value='/personas/new' />">New Persona(s)</a>
	</h4>
	<h5>
		<a href="<c:url value='/home' />">Back</a>
	</h5>
	<c:if test="${!empty listPersona}">
		<table class="table tg">
			<tr>
				<th>ID</th>
				<th>Nombre completo</th>
				<th>Fecha de nacimiento</th>
				<th>Sexo</th>
				<th>Activo</th>
				<th>Operaciones</th>
				<!--  <th colspan="2">Operaciones</th>-->				
			</tr>
			<c:forEach items="${listPersona}" var="persona">
				<tr>
					<td>${persona.id}</td>
					<td>${persona.nombre} ${persona.ap_paterno} ${persona.ap_materno}</td>
					<td>${persona.fecha_nacimiento}</td>
					<td>${persona.sexo}</td>
					<td><c:choose>
							<c:when test="${persona.activo}">Si</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a href="<c:url value='/personas/${persona.id}/edit' />">Edit</a></td>
					<!--  <td><ahref="<c:url value='/personas/${persona.id}/destroy' />">Delete</a></td>-->
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="<c:url value='/personas/new' />">New Persona(s)</a>
	</h4>
	<h5>
		<a href="<c:url value='/home' />">Back</a>
	</h5>
</body>
</html>