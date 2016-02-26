<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Registro a capacitación | Edit</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<h1>Edit a Registro a capacitación</h1>

	<c:url var="addAction" value="/registroscapacitaciones/create"></c:url>

	<form:form action="${addAction}" commandName="registroCapacitacion">
		<table>
			<tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="id" readonly="true" size="8"
						disabled="true" /> <form:hidden path="id" /></td>
			</tr>
			<tr>

				<td><form:label path="calendario_capacitacion_id">
						<spring:message text="Capacitación" />
					</form:label></td>
				<td><form:select path="calendario_capacitacion_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listCalendarioCapacitacion}"
							var="calendarioCapacitacion">
							<c:choose>
								<c:when
									test="${calendarioCapacitacion.id == registroCapacitacion.getCalendario_capacitacion_id().getId()}">
									<option value="${calendarioCapacitacion.id}" selected="selected">${calendarioCapacitacion.capacitacion_id.nombre}| Fecha inicio: ${calendarioCapacitacion.fecha_inicio} | Fecha fin: ${calendarioCapacitacion.fecha_fin}</option>
								</c:when>
								<c:otherwise>
									<option value="${calendarioCapacitacion.id}">${calendarioCapacitacion.capacitacion_id.nombre}| Fecha inicio: ${calendarioCapacitacion.fecha_inicio} | Fecha fin: ${calendarioCapacitacion.fecha_fin}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>

			<tr>
				<td><form:label path="tipo_inscripcion_id">
						<spring:message text="Tipo de inscripción" />
					</form:label></td>
				<td><form:select path="tipo_inscripcion_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listTipoInscripcion}" var="tipoInscripcion">
							<c:choose>
								<c:when
									test="${tipoInscripcion.id == registroCapacitacion.getTipo_inscripcion_id().getId() }">
									<option value="${tipoInscripcion.id}" selected="selected">${tipoInscripcion.nombre}</option>
								</c:when>
								<c:otherwise>
									<option value="${tipoInscripcion.id}">${tipoInscripcion.nombre}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="persona_id">
						<spring:message text="Persona" />
					</form:label></td>
				<td><form:select path="persona_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listPersona}" var="persona">
							<c:choose>
								<c:when
									test="${persona.id == registroCapacitacion.getPersona_id().getId() }">
									<option value="${persona.id}" selected="selected">${persona.nombre} ${persona.ap_paterno} ${persona.ap_materno}</option>
								</c:when>
								<c:otherwise>
									<option value="${persona.id}">${persona.nombre} ${persona.ap_paterno} ${persona.ap_materno}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="empresa_id">
						<spring:message text="Empresa" />
					</form:label></td>
				<td><form:select path="empresa_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listEmpresa}" var="empresa">
							<c:choose>
							<c:when test="${empresa.id == registroCapacitacion.getEmpresa_id().getId() }">
							<option value="${empresa.id}" selected="selected">${empresa.nombre}</option>
							</c:when>
							<c:otherwise>
							<option value="${empresa.id}">${empresa.nombre}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="status_id">
						<spring:message text="Status" />
					</form:label></td>
				<td><form:select path="status_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listStatus}" var="status">
							<c:choose>
							<c:when test="${status.id == registroCapacitacion.getStatus_id().getId() }">
							<option value="${status.id}" selected="selected">${status.nombre}</option>
							</c:when>
							<c:otherwise>
							<option value="${status.id}">${status.nombre}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="fecha_registro">
						<spring:message text="Fecha de registro" />
					</form:label></td>
				<td><form:input path="fecha_registro" size="10" maxlength="10"
						type="date" /></td>
			</tr>
			<tr>
				<td><form:label path="fecha_modificacion">
						<spring:message text="Fecha de modificacion" />
					</form:label></td>
				<td><form:input path="fecha_modificacion" size="10"
						maxlength="10" type="date" /></td>
			</tr>
			<tr>
				<td><form:label path="activo">
						<spring:message text="Activo" />
					</form:label></td>
				<td><form:checkbox path="activo" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Edit Registro capacitación"/>" /></td>
			</tr>
		</table>
	</form:form>
	<h5>
		<a href="<c:url value='/registroscapacitaciones' />">Back</a>
	</h5>
</body>
</html>