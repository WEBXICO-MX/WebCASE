<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>UTTAB &#124; Centro de Atenci�n al Sector Energ�tico</title>
</head>
<body>
<h2>UTTAB &#124; Centro de Atenci�n al Sector Energ�tico</h2>
<p> The time on the server is ${serverTime}. </p>
<h2>Cat�logos</h2>
<a href="<c:url value='/capacitaciones' />">Capacitaciones</a><br/>
<a href="<c:url value='/calendarioscapacitaciones' />">Calendario de Capacitaciones</a><br/>
<a href="<c:url value='/empresas' />">Empresas</a><br/>
<a href="<c:url value='/sectoresproductivos' />">Sectores Productivos</a><br/>
<a href="<c:url value='/status' />">Status</a><br/>
<a href="<c:url value='/tiposcapacitaciones' />">Tipo Capacitaciones</a><br/>
<a href="<c:url value='/tiposinscripciones' />">Tipos Inscripciones</a><br/>
<a href="<c:url value='/tiposmedioscomunicacion' />">Tipo Medios de Comunicaci�n</a><br/>
<!--  <a href="<c:url value='/usuarios' />">Usuarios</a><br/>-->
<!--  <a href="<c:url value='/personas' />">Personas</a><br/>-->
<!--  <a href="<c:url value='/medioscomunicacion' />">Medios de comunicaci�n</a><br/>-->
<!--  <a href="<c:url value='/registroscapacitaciones' />">Registro de capacitaciones</a><br/>-->
<h2>Procesos</h2>
<a href="<c:url value='/registroscapacitaciones/mailbox"' />">Ir a buz�n</a><br/>
<h3>Powered by Spring MVC 4 & Hibernate 5</h3>
</body>
</html>
