<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Registro a capacitación | Create</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<spring:url value="/resources/bower_components/jquery-ui/themes/blitzer/jquery-ui.min.css" var="jqueryUICSS" />
<spring:url value="/resources/bower_components/jquery/dist/jquery.min.js" var="jquery" />
<spring:url value="/resources/bower_components/jquery-ui/jquery-ui.min.js" var="jqueryUI" />
<spring:url value="/resources/bower_components/jquery-ui/ui/i18n/datepicker-es.js" var="i18n" />
<spring:url value="/resources/bower_components/jqueryui-timepicker-addon/dist/jquery-ui-timepicker-addon.min.css" var="jqueryTimePickerCSS" />
<spring:url value="/resources/bower_components/jqueryui-timepicker-addon/dist/jquery-ui-timepicker-addon.min.js" var="jqueryTimePicker" />
<link href="${caseCSS}" rel="stylesheet" />
<link href="${jqueryUICSS}" rel="stylesheet" />
<link href="${jqueryTimePickerCSS}" rel="stylesheet" />
<script src="${jquery}"></script>
<script src="${jqueryUI}"></script>
<script src="${i18n}"></script>
<script src="${jqueryTimePicker}"></script>
</head>
<body>
	<h1>Add a Registro a capacitación</h1>

	<c:url var="addAction" value="/registroscapacitaciones/create"></c:url>

	<form:form action="${addAction}" commandName="registroCapacitacion">
		<table>
			<tr>
				<td><form:label path="calendario_capacitacion_id">
						<spring:message text="Capacitación" />
					</form:label></td>
				<td><form:select path="calendario_capacitacion_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listCalendarioCapacitacion}"
							var="calendarioCapacitacion">
							<option value="${calendarioCapacitacion.id}">${calendarioCapacitacion.capacitacion_id.nombre} | Fecha inicio: ${calendarioCapacitacion.fecha_inicio} | Fecha fin: ${calendarioCapacitacion.fecha_fin}</option>
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
							<option value="${tipoInscripcion.id}">${tipoInscripcion.nombre}</option>
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
							<option value="${persona.id}">${persona.nombre} ${persona.ap_paterno} ${persona.ap_materno}</option>
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
							<option value="${empresa.id}">${empresa.nombre}</option>
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
							<option value="${status.id}">${status.nombre}</option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="fecha_registro">
						<spring:message text="Fecha de registro" />
					</form:label></td>
				<td><form:hidden path="fecha_registro" value="${date}"/></td>
			</tr>
			<!--<tr>
				<td><form:label path="fecha_modificacion">
						<spring:message text="Fecha de modificacion" />
					</form:label></td>
				<td><form:hidden path="fecha_modificacion" value="${date}"/></td>
			</tr>-->
			<tr>
				<td><form:label path="activo">
						<spring:message text="Activo" />
					</form:label></td>
				<td><form:checkbox path="activo" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Add Registro capacitación"/>" /></td>
			</tr>
		</table>
	</form:form>
	<h5>
		<a href="<c:url value='/registroscapacitaciones' />">Back</a>
	</h5>
			<script>
		$(document).ready(function() {
			
			$(".date-picker").datetimepicker({
				timeFormat:"HH:mm:ss.cZ",
				yearRange : "-50:+0",
				changeMonth : true,
				changeYear : true,
				dateFormat : 'yy-mm-dd'
			});

		});
	</script>
</body>
</html>