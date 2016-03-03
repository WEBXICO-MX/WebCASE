<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Calendario de capacitaciones| Edit</title>
<meta charset="UTF-8">
<spring:url value="/resources/css/case.css" var="caseCSS" />
<spring:url value="/resources/bower_components/jquery-ui/themes/blitzer/jquery-ui.min.css" var="jqueryUICSS" />
<spring:url value="/resources/bower_components/jquery/dist/jquery.min.js" var="jquery" />
<spring:url value="/resources/bower_components/jquery-ui/jquery-ui.min.js" var="jqueryUI" />
<spring:url value="/resources/bower_components/jquery-ui/ui/i18n/datepicker-es.js" var="i18n" />
<link href="${caseCSS}" rel="stylesheet" />
<link href="${jqueryUICSS}" rel="stylesheet" />
<script src="${jquery}"></script>
<script src="${jqueryUI}"></script>
<script src="${i18n}"></script>
<body>
	<h1>Edit a Calendario de capacitaciones</h1>

	<c:url var="addAction" value="/calendarioscapacitaciones/create"></c:url>

	<form:form action="${addAction}" commandName="calendarioCapacitacion">
		<table>
			<tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="id" readonly="true" size="8"
						disabled="true" /> <form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="capacitacion_id">
						<spring:message text="Capacitación" />
					</form:label></td>
				<td><form:select path="capacitacion_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listCapacitacion}" var="capacitacion">
							<c:choose>
								<c:when
									test="${capacitacion.id == calendarioCapacitacion.getCapacitacion_id().getId()}">
									<option value="${capacitacion.id}" selected="selected">${capacitacion.nombre}</option>
								</c:when>
								<c:otherwise>
									<option value="${capacitacion.id}">${capacitacion.nombre}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="fecha_inicio">
						<spring:message text="Fecha inicio" />
					</form:label></td>
				<td><form:input path="fecha_inicio" cssClass="date-picker" size="10" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="fecha_fin">
						<spring:message text="Fecha fin"/>
					</form:label></td>
				<td><form:input path="fecha_fin" cssClass="date-picker" size="10" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="activo">
						<spring:message text="Activo" />
					</form:label></td>
				<td><form:checkbox path="activo" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Edit Capacitacion"/>" /></td>
			</tr>
		</table>
	</form:form>
	<h5>
		<a href="<c:url value='/calendarioscapacitaciones' />">Back</a>
	</h5>
	<script>
		$(document).ready(function() {

			$(".date-picker").datepicker({
				yearRange : "-0:+10",
				changeMonth : true,
				changeYear : true,
				dateFormat : 'yy-mm-dd'
			});

		});
	</script>
</body>
</html>