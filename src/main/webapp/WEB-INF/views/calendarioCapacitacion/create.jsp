<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Calendario de capacitaciones| Create</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h1>Add a Calendario de capacitaciones</h1>

	<c:url var="addAction" value="/calendarioscapacitaciones/create"></c:url>

	<form:form action="${addAction}" commandName="calendarioCapacitacion">
		<table>
			<tr>
				<td><form:label path="capacitacion_id">
						<spring:message text="Capacitación" />
					</form:label></td>
				<td><form:select path="capacitacion_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listCapacitacion}" var="capacitacion">
							<option value="${capacitacion.id}">${capacitacion.nombre}</option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="fecha_inicio">
						<spring:message text="Fecha inicio" />
					</form:label></td>
				<td><form:input type="date" path="fecha_inicio" /></td>
			</tr>
			<tr>
				<td><form:label path="fecha_fin">
						<spring:message text="Fecha fin" />
					</form:label></td>
				<td><form:input type="date" path="fecha_fin" /></td>
			</tr>
			<tr>
				<td><form:label path="activo">
						<spring:message text="Activo" />
					</form:label></td>
				<td><form:checkbox path="activo" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="<spring:message text="Add Calendario capacitacion"/>" />
				</td>
			</tr>
		</table>
	</form:form>
	<h5>
		<a href="<c:url value='/calendarioscapacitaciones' />">Back</a>
	</h5>
</body>
</html>