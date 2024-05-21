<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Caballeros</title>
</head>
<body>
<main>
	<c:forEach items="${caballeros}" var="caballero">
			<td>${caballero.id}</td>
			<td>${caballero.nombre}</td>
			<td>${caballero.fuerza}</td>
			<td>${caballero.experiencia}</td>
			<td>${caballero.foto}</td>
			<td>${caballero.arma_id}</td>
			
	</c:forEach>
	</main>
</body>
