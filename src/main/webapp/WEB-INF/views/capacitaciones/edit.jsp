<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url
	value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"
	var="bootstrapCSS" />
<spring:url
	value="/resources/bower_components/jquery/dist/jquery.min.js"
	var="jquery" />
<spring:url
	value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"
	var="bootstrap" />
<!DOCTYPE html>
<html lang="es">
<head>
<title>UTTAB &#124; Centro de Atención al Sector Energético |	Capacitaciones | Editar</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${bootstrapCSS}" rel="stylesheet" />
<link href="${caseCSS}" rel="stylesheet" />
<style>
.icon-input-btn {
	display: inline-block;
	position: relative;
}

.icon-input-btn input[type="submit"] {
	padding-left: 2em;
}

.icon-input-btn .glyphicon {
	display: inline-block;
	position: absolute;
	left: 0.65em;
	top: 30%;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<a href="<c:url value='/home' />" class="btn btn-primary"><span
					class="glyphicon glyphicon-chevron-left"></span> Back</a><br />
				<h3 class="text-center">Capacitación</h3>
				<c:url var="addAction" value="/capacitaciones/create"></c:url>
				<form:form action="${addAction}" commandName="capacitacion"
					role="form" name="frmDocumentacion" id="frmDocumentacion">
					<div class="form-group">
							<form:label path="id">
								<spring:message text="ID" />
							</form:label>
							<form:input path="id" readonly="true" size="8" disabled="true"
								class="form-control" />
							<form:hidden path="id" />
						</div>
					<div class="form-group">
						<form:label path="nombre">
							<spring:message text="Nombre" />
						</form:label>
						<form:input path="nombre" size="70" maxlength="150"
							class="form-control" />
					</div>
					<div class="form-group">
						<form:label path="descripcion">
							<spring:message text="Descripción" />
						</form:label>
						<form:textarea path="descripcion" cols="70" rows="20"
							class="form-control" />
					</div>
					<div class="form-group">
						<form:label path="tipo_capacitacion_id">
							<spring:message text="Tipo capacitación" />
						</form:label>
						<form:select path="tipo_capacitacion_id.id">
						<option value="-1">----- SELECCIONE UNA OPCIÓN -----</option>
						<c:forEach items="${listTipoCapacitacion}" var="tipoCapacitacion">
							<c:choose>
								<c:when test="${tipoCapacitacion.id == capacitacion.getTipo_capacitacion_id().getId()}">
									<option value="${tipoCapacitacion.id}" selected="selected">${tipoCapacitacion.nombre}</option>
								</c:when>
								<c:otherwise>
									<option value="${tipoCapacitacion.id}">${tipoCapacitacion.nombre}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
					</div>
					<div class="checkbox">
						<label><form:checkbox path="activo" /> ¿Activo?:</label>
					</div>
					<span class="icon-input-btn"><span
							class="glyphicon glyphicon-floppy-disk"></span> 
						<input type="submit"
							value="<spring:message text="Guardar"/>"
							class="btn btn-lg btn-success"></input>	
							</span>

				</form:form>
			</div>
		</div>
	</div>
	<script src="${jquery}"></script>
	<script src="${bootstrap}"></script>
		<script>
		$(document).ready(function() {
			$(".icon-input-btn").each(function() {
				var btnFont = $(this).find(".btn").css("font-size");
				var btnColor = $(this).find(".btn").css("color");
				$(this).find(".glyphicon").css("font-size", btnFont);
				$(this).find(".glyphicon").css("color", btnColor);
				if ($(this).find(".btn-xs").length) {
					$(this).find(".glyphicon").css("top", "24%");
				}
			});
		});
	</script>
</body>
</html>