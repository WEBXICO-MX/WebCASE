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
<title>UTTAB &#124; Centro de Atención al Sector Energético |
	Tipo(s) Inscripcion(es) | Index</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${bootstrapCSS}" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<h3 class="text-center">Tipo(s) Inscripcion(es)</h3>
				<a href="<c:url value='/home' />" class="btn btn-primary"><span
					class="glyphicon glyphicon-chevron-left"></span> Back</a><br /> <br />
				<a href="<c:url value='/tiposinscripciones/new' />"
					class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
					New Tipo Inscripcion</a><br /> <br />
				<c:if test="${!empty listTipoInscripcion}">
					<table
						class="table table-bordered table-striped table-hover table-responsive">
						<thead>
							<tr>
								<th>ID</th>
								<th>Nombre</th>
								<th>Activo</th>
								<!--  <th colspan="2">Operaciones</th> -->
								<th colspan="2">Operaciones</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listTipoInscripcion}" var="tipoInscripcion">
								<tr>
									<td>${tipoInscripcion.id}</td>
									<td>${tipoInscripcion.nombre}</td>
									<td><c:choose>
											<c:when test="${tipoInscripcion.activo}">
												<span class="glyphicon glyphicon-check"></span>
											</c:when>
											<c:otherwise>
												<span class="glyphicon glyphicon-unchecked"></span>
											</c:otherwise>
										</c:choose></td>
									<td><a
										href="<c:url value='/tiposinscripciones/${tipoInscripcion.id}/edit' />"
										class="btn btn-warning"><span
											class="glyphicon glyphicon-edit"></span> Editar</a></td>
									<!--  <td><a	href="<c:url value='/tiposinscripciones/${tipoInscripcion.id}/destroy' />">Delete</a></td>-->
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>

				<a href="<c:url value='/home' />" class="btn btn-primary"><span
					class="glyphicon glyphicon-chevron-left"></span> Back</a><br /> <br />
				<a href="<c:url value='/tiposinscripciones/new' />"
					class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
					New Tipo Inscripcion</a><br /> <br />
			</div>
		</div>
	</div>
</body>
</html>