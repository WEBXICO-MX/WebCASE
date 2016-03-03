<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Persona(s) | Create</title>
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
</head>
<body>
	<h1>Add a Persona(s)</h1>

	<c:url var="addAction" value="/personas/create"></c:url>

	<form:form action="${addAction}" commandName="persona">
		<table>
			<c:if test="${!empty persona.nombre}">
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
				<td><form:input path="nombre" size="30" maxlength="50"/></td>
			</tr>
			<tr>
				<td><form:label path="ap_paterno">
						<spring:message text="Apellido paterno" />
					</form:label></td>
				<td><form:input path="ap_paterno" size="30" maxlength="50" /></td>
			</tr>
			<tr>
				<td><form:label path="ap_materno">
						<spring:message text="Apellido materno" />
					</form:label></td>
				<td><form:input path="ap_materno" size="30" maxlength="50" /></td>
			</tr>
			<tr>
				<td><form:label path="fecha_nacimiento">
						<spring:message text="Fecha de nacimiento" />
					</form:label></td>
				<td><form:input path="fecha_nacimiento" cssClass="date-picker" size="10" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="sexo">
						<spring:message text="Sexo" />
					</form:label>
				</td>
				<td>
				 <form:radiobutton path="sexo" value="M" />Masculino
				 <form:radiobutton path="sexo" value="F"/>Femenino
				</td>
			</tr>
			<tr>
				<td><form:label path="activo">
						<spring:message text="Activo" />
					</form:label></td>

				<td><form:checkbox path="activo" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty persona.nombre}">
						<input type="submit"
							value="<spring:message text="Edit Persona"/>" />
					</c:if> <c:if test="${empty persona.nombre}">
						<input type="submit"
							value="<spring:message text="Add Persona"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<h5>
		<a href="<c:url value='/personas' />">Back</a>
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