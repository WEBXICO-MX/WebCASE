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
<spring:url
	value="/resources/bower_components/jquery-ui/themes/blitzer/jquery-ui.min.css"
	var="jqueryUICSS" />
<spring:url
	value="/resources/bower_components/jquery-ui/jquery-ui.min.js"
	var="jqueryUI" />
<spring:url
	value="/resources/bower_components/jquery-ui/ui/i18n/datepicker-es.js"
	var="i18n" />
<spring:url
	value="/resources/css/case.css"
	var="caseCSS" />
<!DOCTYPE html>
<html lang="es">
<head>
<title>UTTAB &#124; Centro de Atención al Sector Energético |
	Calendario de capacitaciones| Editar</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${bootstrapCSS}" rel="stylesheet" />
<link href="${jqueryUICSS}" rel="stylesheet" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<a href="<c:url value='/calendarioscapacitaciones' />"
					class="btn btn-primary"><span
					class="glyphicon glyphicon-chevron-left"></span> Back</a><br />
				<h3 class="text-center">Calendario de capacitaciones</h3>

				<c:url var="addAction" value="/calendarioscapacitaciones/create"></c:url>
				<form:form action="${addAction}"
					commandName="calendarioCapacitacion" role="form">
					<div class="form-group">
					     <form:label path="id">	<spring:message text="ID" /></form:label>
					     <form:input path="id" readonly="true" size="8"	disabled="true" cssClass="form-control" /> <form:hidden path="id" />
					</div>
					<div class="form-group">
						<form:label path="capacitacion_id">
							<spring:message text="Capacitación" />
						</form:label>
						<form:select path="capacitacion_id.id" cssClass="form-control" >
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
						</form:select>
					</div>
					<div class="form-group">
						<div class="date-form">
							<div class="form-horizontal">
								<div class="control-group">
									<form:label path="fecha_inicio">
										<spring:message text="Fecha inicio" />
									</form:label>
									<div class="controls">
										<div class="input-group">
											<form:input path="fecha_inicio"
												cssClass="date-picker form-control" size="10"
												readonly="true" />
											<label class="input-group-addon btn"><span
												class="glyphicon glyphicon-calendar"></span></label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="date-form">
							<div class="form-horizontal">
								<div class="control-group">
									<form:label path="fecha_fin">
										<spring:message text="Fecha fin" />
									</form:label>
									<div class="controls">
										<div class="input-group">
											<form:input path="fecha_fin"
												cssClass="date-picker form-control" size="10"
												readonly="true" />
											<label class="input-group-addon btn"><span
												class="glyphicon glyphicon-calendar"></span></label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="checkbox">
						<label><form:checkbox path="activo" /> ¿Activo?</label>
					</div>
					<span class="icon-input-btn"><span
						class="glyphicon glyphicon-floppy-disk"></span> <input
						type="submit" value="<spring:message text="Guardar"/>"
						class="btn btn-lg btn-success"></input> </span>
				</form:form>
			</div>
		</div>
	</div>
	<script src="${jquery}"></script>
	<script src="${bootstrap}"></script>
	<script src="${jqueryUI}"></script>
	<script src="${i18n}"></script>
	<script src="${ckeditor}"></script>
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