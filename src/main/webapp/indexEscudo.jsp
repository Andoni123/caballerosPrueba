<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Escudo</title>
</head>
<body>
<main>
<c:forEach items="${escudos}" var="escudo">
			<td>${escudo.id}</td>
			<td>${escudo.nombre}</td>
			<td>${escudo.capacidad_defensa}</td>
	</c:forEach>
</main>

</body>
</html>