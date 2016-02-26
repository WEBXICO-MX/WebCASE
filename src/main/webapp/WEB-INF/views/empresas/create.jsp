<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Empresa | Create</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h1>Add a Empresa</h1>

	<c:url var="addAction" value="/empresas/create"></c:url>

	<form:form action="${addAction}" commandName="empresa">
		<table>
			<c:if test="${!empty empresa.nombre}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="nombre">
						<spring:message text="Nombre" />
					</form:label></td>
				<td><form:input path="nombre" size="70"  maxlength="150"/></td>
			</tr>
			<tr>
				<td><form:label path="sector_productivo_id">
						<spring:message text="Sector productivo" />
					</form:label>
				</td>
				<td><form:select path="sector_productivo_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listSectorProductivo}" var="sectorProductivo">
							<option value="${sectorProductivo.id}">${sectorProductivo.nombre}</option>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="activo">
						<spring:message text="Activo" />
					</form:label>
				</td>
				<td><form:checkbox path="activo" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty empresa.nombre}">
						<input type="submit"
							value="<spring:message text="Edit Empresa"/>" />
					</c:if> <c:if test="${empty empresa.nombre}">
						<input type="submit"
							value="<spring:message text="Add Empresa"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<h5>
		<a href="<c:url value='/empresas' />">Back</a>
	</h5>
</body>
</html>