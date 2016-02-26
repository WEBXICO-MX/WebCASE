<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spring MVC 4 & Hibernate 5</title>
</head>
<body>
<h1>
	Spring MVC 4 & Hibernate 5
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="<c:url value='/tiposmedioscomunicacion' />">Tipo Medios de Comunicación</a><br/>
<a href="<c:url value='/tiposcapacitaciones' />">Tipo Capacitaciones</a><br/>
<a href="<c:url value='/sectoresproductivos' />">Sectores Productivos</a><br/>
<a href="<c:url value='/tiposinscripciones' />">Tipos Inscripciones</a><br/>
<a href="<c:url value='/usuarios' />">Usuarios</a><br/>
<a href="<c:url value='/status' />">Status</a><br/>
<a href="<c:url value='/capacitaciones' />">Capacitaciones</a><br/>
<a href="<c:url value='/empresas' />">Empresas</a><br/>
<a href="<c:url value='/calendarioscapacitaciones' />">Calendario de Capacitaciones</a><br/>
<a href="<c:url value='/personas' />">Personas</a><br/>
<a href="<c:url value='/medioscomunicacion' />">Medios de comunicación</a><br/>
<a href="<c:url value='/registroscapacitaciones' />">Registro de capacitaciones</a><br/>
</body>
</html>
