<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Medio de comunicación | Edit</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h1>Edit a Medio de comunicación </h1>

	<c:url var="addAction" value="/medioscomunicacion/create"></c:url>

	<form:form action="${addAction}" commandName="medioComunicacion">
		<table>
			<c:if test="${!empty medioComunicacion.valor}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="persona_id">
						<spring:message text="Persona" />
					</form:label></td>
				<td><form:select path="persona_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listPersona}" var="persona">
							<c:choose>
								<c:when test="${persona.id == medioComunicacion.getPersona_id().getId()}">
									<option value="${persona.id}" selected="selected">${persona.nombre}
										${persona.ap_paterno} ${persona.ap_materno}</option>
								</c:when>
								<c:otherwise>
									<option value="${persona.id}">${persona.nombre} ${persona.ap_paterno} ${persona.ap_materno}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="tipo_medio_comunicacion_id">
						<spring:message text="Tipo medio de comunicación" />
					</form:label></td>
				<td><form:select path="tipo_medio_comunicacion_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listTipoMedioComunicacion}" var="tipoMedioComunicacion">
							<c:choose>
							<c:when test="${tipoMedioComunicacion.id == medioComunicacion.getTipo_medio_comunicacion_id().getId()}">
							  <option value="${tipoMedioComunicacion.id}" selected="selected">${tipoMedioComunicacion.nombre}</option>
							</c:when>
							<c:otherwise>
							<option value="${tipoMedioComunicacion.id}">${tipoMedioComunicacion.nombre}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
			   </td>
			</tr>
			<tr>
				<td><form:label path="valor">
						<spring:message text="Valor" />
					</form:label></td>
				<td><form:input path="valor" size="30" maxlength="50" /></td>
			</tr>
			<tr>
				<td><form:label path="activo">
						<spring:message text="Activo" />
					</form:label></td>
				<td><form:checkbox path="activo" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty medioComunicacion.valor}">
						<input type="submit"
							value="<spring:message text="Edit Medio de comunición"/>" />
					</c:if> <c:if test="${empty medioComunicacion.valor}">
						<input type="submit"
							value="<spring:message text="Add Medio de comunición"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<h5>
		<a href="<c:url value='/medioscomunicacion' />">Back</a>
	</h5>
</body>
</html>