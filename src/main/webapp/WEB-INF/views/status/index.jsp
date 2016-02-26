<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Status | Index</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h3>Status</h3>
	<h4>
		<a href="<c:url value='/status/new' />">New Status</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
	<c:if test="${!empty listStatus}">
		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Nombre</th>
				<th width="120">Activo</th>
				<th width="120" colspan="2">Operaciones</th>
			</tr>
			<c:forEach items="${listStatus}" var="status">
				<tr>
					<td>${status.id}</td>
					<td>${status.nombre}</td>
					<td><c:choose>
							<c:when test="${status.activo}">Si</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</td>
					<td><a href="<c:url value='/status/${status.id}/edit' />">Edit</a></td>
					<td><a href="<c:url value='/status/${status.id}/destroy' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h4>
		<a href="<c:url value='/status/new' />">New Status</a>
	</h4>
	<h5>
		<a href="<c:url value='/' />">Back</a>
	</h5>
</body>
</html>