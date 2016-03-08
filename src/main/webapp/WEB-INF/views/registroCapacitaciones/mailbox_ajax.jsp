<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:choose>
	<c:when test="${!empty listRegistroCapacitacion}">
		<table class="table table-hover table-condensed table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre completo</th>
					<th>Capacitación</th>
					<th>Fechas de la capacitación</th>
					<th>Fecha de registro</th>
					<th>Fecha de modificación</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listRegistroCapacitacion}" var="registroCapacitacion" varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td><a data-toggle="modal" data-target="#myModal"
							data-remote="mailbox_id/${registroCapacitacion.id}"
							href="javascript:void(0);">
								${registroCapacitacion.persona_id.nombre}
								${registroCapacitacion.persona_id.ap_paterno}
								${registroCapacitacion.persona_id.ap_materno} </a></td>
						<td>${registroCapacitacion.calendario_capacitacion_id.capacitacion_id.nombre}</td>
						<td>Fecha inicio:
							${registroCapacitacion.calendario_capacitacion_id.fecha_inicio} |
							Fecha fin:
							${registroCapacitacion.calendario_capacitacion_id.fecha_fin}</td>
						<td>${registroCapacitacion.fecha_registro}</td>
						<td>${registroCapacitacion.fecha_modificacion}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<h4>No hay registros para mostrar</h4>
	</c:otherwise>
</c:choose>