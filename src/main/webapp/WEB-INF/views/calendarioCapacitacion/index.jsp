<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url
	value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"
	var="bootstrapCSS" />
<!DOCTYPE html>
<html lang="es">
<head>
<title>UTTAB &#124; Centro de Atención al Sector Energético | Calendario de capacitaciones | Index</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${bootstrapCSS}" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h3 class="text-center">Calendario de capacitaciones</h3>
				<a href="<c:url value='/home' />" class="btn btn-primary"><span
					class="glyphicon glyphicon-chevron-left"></span> Back</a><br /> <br />
				<a href="<c:url value='/calendarioscapacitaciones/new' />"
					class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
					New Calendario de capacitaciones</a><br /> <br />

				<c:if test="${!empty listCalendarioCapacitacion}">
					<table
						class="table table-bordered table-striped table-hover table-responsive">
						<thead>
							<tr>
								<th>ID</th>
								<th>Capacitación</th>
								<th>Fecha inicio</th>
								<th>Fecha Fin</th>
								<th>Activo</th>
								<th>Operaciones</th>
								<!--  <th colspan="2">Operaciones</th>-->
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listCalendarioCapacitacion}"
								var="calendarioCapacitacion">
								<tr>
									<td>${calendarioCapacitacion.id}</td>
									<td>${calendarioCapacitacion.capacitacion_id.nombre}</td>
									<td>${calendarioCapacitacion.fecha_inicio}</td>
									<td>${calendarioCapacitacion.fecha_fin}</td>
									<td><c:choose>
											<c:when test="${calendarioCapacitacion.activo}">
												<span class="glyphicon glyphicon-check"></span>
											</c:when>
											<c:otherwise>
												<span class="glyphicon glyphicon-unchecked"></span>
											</c:otherwise>
										</c:choose></td>
									<td><a
										href="<c:url value='/calendarioscapacitaciones/${calendarioCapacitacion.id}/edit' />"
										class="btn btn-warning"><span
											class="glyphicon glyphicon-edit"></span> Editar</a></td>
									<!--  <td><a href="<c:url value='/calendarioscapacitaciones/${calendarioCapacitacion.id}/destroy' />">Delete</a></td>-->
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>

				<a href="<c:url value='/home' />" class="btn btn-primary"><span
					class="glyphicon glyphicon-chevron-left"></span> Back</a><br /> <br />
				<a href="<c:url value='/calendarioscapacitaciones/new' />"
					class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
					New Calendario de capacitaciones</a><br /> <br />
			</div>
		</div>
	</div>
</body>
</html>