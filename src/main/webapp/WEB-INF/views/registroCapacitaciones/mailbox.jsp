<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url
	value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"
	var="bootstrapCSS" />
<spring:url
	value="/resources/bower_components/jquery/dist/jquery.min.js"
	var="jquery" />
<spring:url
	value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"
	var="bootstrap" />
<link href="${bootstrapCSS}" rel="stylesheet" />
<title>UTTAB &#124; Centro de Atención al Sector Energético | Buzón</title>
</head>
<body>
	<!-- Cuerpo -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5>
					<a href="<c:url value='/' />">Back</a>
				</h5>
				<h2>UTTAB &#124; Centro de Atención al Sector Energético</h2>
				<h1>
					<span class="glyphicon glyphicon-user"></span>&nbsp;
					<!--  <s:property value="#session['nombre']" />-->
				</h1>
				<!--  <s:url id="logoutURL" action="logout" var="logoutURL"></s:url>
				<a href="<s:property value="#logoutURL"/>"><i
					class="glyphicon glyphicon-log-out"></i> CERRAR SESIÓN</a>-->
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="bs-example">
					<ul class="nav nav-tabs" id="myTab">
						<li class="active"><a href="#sectionA" data-toggle="tab"><span
								class="glyphicon glyphicon-certificate"></span> Nuevos</a></li>
						<li><a href="#sectionB" data-toggle="tab"><span
								class="glyphicon glyphicon-check"></span> Revisados</a></li>
						<li><a href="#sectionC" data-toggle="tab"><span
								class="glyphicon glyphicon glyphicon-education"></span>
								Inscritos</a></li>
						<li><a href="#sectionE" data-toggle="tab"><span
								class="glyphicon glyphicon-header"></span> No inscritos</a></li>
						<li><a href="#sectionD" data-toggle="tab"><span
								class="glyphicon glyphicon-hand-down"></span> Histórico</a></li>
					</ul>
					<div class="tab-content">
						<div id="sectionA" class="tab-pane fade in active"></div>
						<div id="sectionB" class="tab-pane fade"></div>
						<div id="sectionC" class="tab-pane fade"></div>
						<div id="sectionD" class="tab-pane fade"></div>
						<div id="sectionE" class="tab-pane fade"></div>
					</div>

				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<h3>Powered by Spring MVC 4 & Hibernate 5</h3>
			</div>
		</div>
	</div>
	<!-- Cuerpo -->
	<script src="${jquery}"></script>
	<script src="${bootstrap}"></script>
	<script>
		$(document).ready(function() {
			$.ajaxSetup({
				cache : false
			});

			getBuzon("#sectionA");

			$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
				var target = $(e.target).attr("href");
				getBuzon(target);
			});

			/* Limpiar la ventana modal para volver a usar*/
			$('body').on('hidden.bs.modal', '.modal', function() {
				$(this).removeData('bs.modal');
			});

		});

		function getBuzon(target) {
			var status = getStatus(target);
			$.ajax({
				url : "mailbox_ajax/" + status,
				error : function(data) {
					alert("There was a problem");
				},
				success : function(data) {
					$(target).html(data);
				}
			});
		}

		function changeStatus(status) {
			$("#cambiar_status_status").val(status);
			return true;
		}

		function getStatus(target) {
			var status = 0;
			switch (target) {
			case "#sectionA":
				status = 1;
				break;
			case "#sectionB":
				status = 2;
				break;
			case "#sectionC":
				status = 3;
				break;
			case "#sectionD":
				status = 4;
				break;
			case "#sectionE":
				status = 5;
				break;
			default:
				status = 0;

			}

			return status;

		}
	</script>
</body>
</html>