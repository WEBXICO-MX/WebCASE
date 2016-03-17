<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Usuario(s) | Index</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h3>Usuario(s)</h3>
		<h4>
		<a href="<c:url value='/usuarios/new' />">New Usuario</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
	<c:if test="${!empty listUsuario}">
		<table class="table tg">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Login</th>
				<th>Password</th>
				<th>Activo</th>
				<!-- <th colspan="2">Operaciones</th> -->
				<th colspan="2">Operaciones</th>
			</tr>
			<c:forEach items="${listUsuario}" var="usuario">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nombre}</td>
					<td>${usuario.login}</td>
					<td>${usuario.password}</td>
					<td><c:choose>
							<c:when test="${usuario.activo}">Si</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</td>
					<td><a href="<c:url value='/usuarios/${usuario.id}/edit' />">Edit</a></td>
					<!--  <td><a	href="<c:url value='/usuarios/${usuario.id}/destroy' />">Delete</a></td>-->
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="<c:url value='/usuarios/new' />">New Usuario</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
</body>
</html>