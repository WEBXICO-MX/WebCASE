<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Empresas | Index</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h3>Empresas</h3>
	<c:if test="${!empty listEmpresa}">
		<h4>
			<a href="<c:url value='/empresas/new' />">New Empresa</a>
		</h4>
		<h5>
			<a href="<c:url value='/' />">Back</a>
		</h5>
		<table class="table tg">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Sector Productivo</th>
				<th>Activo</th>
				<th colspan="2">Operaciones</th>
			</tr>
			<c:forEach items="${listEmpresa}" var="empresa">
				<tr>
					<td>${empresa.id}</td>
					<td>${empresa.nombre}</td>
					<td>${empresa.sector_productivo_id.nombre}</td>
					<td><c:choose>
							<c:when test="${empresa.activo}">Si</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a href="<c:url value='/empresas/${empresa.id}/edit' />">Edit</a></td>
					<td><a
						href="<c:url value='/empresas/${empresa.id}/destroy' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="<c:url value='/empresas/new' />">New Empresas</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
</body>
</html>