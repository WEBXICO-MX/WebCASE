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
	value="/resources/css/case.css"
	var="caseCSS" />	
<!DOCTYPE html>
<html lang="es">
<head>
<title>UTTAB &#124; Centro de Atención al Sector Energético |
	Sector(es) Productivo(s) | Create</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${bootstrapCSS}" rel="stylesheet" />
<link href="${caseCSS}" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<a href="<c:url value='/sectoresproductivos' />" class="btn btn-primary"><span
					class="glyphicon glyphicon-chevron-left"></span> Back</a><br />
				<h3 class="text-center">Sector Productivo</h3>

				<c:url var="addAction" value="/sectoresproductivos/create"></c:url>
				<form:form action="${addAction}" commandName="sectorProductivo"
					role="form">
					<div class="form-group">
						<form:label path="nombre">
							<spring:message text="Nombre" />
						</form:label>
						<form:input path="nombre" cssClass="form-control" />
					</div>
					<div class="checkbox">
						<label><form:checkbox path="activo" />¿Activo?</label>
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