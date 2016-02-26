<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Tipo(s) Medio(s) de Comunicación | Index</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h3>Tipo(s) Medio(s) de Comunicación</h3>
    <h4>
		<a href="<c:url value='/tiposmedioscomunicacion/new' />">New Tipo Medio de Comunicación</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
	<c:if test="${!empty listTipoMedioComunicacion}">
		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Nombre</th>
				<th width="120">Imagen</th>
				<th width="120">Activo</th>
				<th width="120" colspan="2">Operaciones</th>
			</tr>
			<c:forEach items="${listTipoMedioComunicacion}" var="tipoMedioComunicacion">
				<tr>
					<td>${tipoMedioComunicacion.id}</td>
					<td>${tipoMedioComunicacion.nombre}</td>
					<td><img alt="${tipoMedioComunicacion.nombre}" src="${tipoMedioComunicacion.img} "></td>
					<td><c:choose>
							<c:when test="${tipoMedioComunicacion.activo}">Si</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a
						href="<c:url value='/tiposmedioscomunicacion/${tipoMedioComunicacion.id}/edit' />">Edit</a></td>
					<td><a
						href="<c:url value='/tiposmedioscomunicacion/${tipoMedioComunicacion.id}/destroy' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="<c:url value='/tiposmedioscomunicacion/new' />">New Tipo Medio de Comunicación</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
</body>
</html>