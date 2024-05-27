<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<title>Caballeros</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<header class="d-flex justify-content-end h-16 m-2">
	<form method="get" id="buscarform">
    <fieldset>
        <input type="text" id="s" value="" placeholder="Buscar"/>
        <input class="button" type="submit" value="Buscar" />
        <i class="search"></i>
    </fieldset>
    </form>
		<button class=" btn btn-primary col-1" type="button"
			data-bs-toggle="offcanvas" data-bs-target="#offcanvasBottom"
			aria-controls="offcanvasBottom">Insertar</button>
		<div class="offcanvas offcanvas-start bg-light" tabindex="-1"
			id="offcanvasBottom" aria-labelledby="offcanvasBottomLabel">
			<div class="offcanvas-header">
				<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
					aria-label="Close"></button>
			</div>
			<div class="offcanvas-body small">
				<p class="h4">Insertar Caballero</p>
				<hr>
				<form action="StoreCaballero" method="post" class="bg-light">
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre</label> 
						<input type="text" class="form-control" id="nombre" name="nombre">
					</div>
					<div class="mb-3">
						<label for="fuerza" class="form-label">Fuerza</label> 
						<input type="text" class="form-control" id="fuerza" min="0" max="100" name="fuerza">
					</div>
					<div class="mb-3">
						<label for="experiencia" class="form-label">Experiencia</label> 
						<input type="text" class="form-control" id="experiencia" name="experiencia" >
					</div>
					<div class="mb-3">
						<label for="foto" class="form-label">Foto</label> 
						<input type="text" class="form-control" id="foto" name="foto">
					</div>
					<div class="mb-3">
						<select class="form-select" name="arma_id">
							<option value="0"></option>
							<c:forEach items="${armas}" var="arma">
								<option value="${arma.id}">${arma.nombre}</option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<select class="form-select" name="escudo_id">
							<option value="0"></option>
							<c:forEach items="${escudos}" var="escudo">
								<option value="${escudo.id}">${escudo.nombre}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" value="guardar" name="guardar" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</header>
	
	<main style="height: 90vh">
		<div class="container-fluid">
			      <%@ include file="/Validaciones.jsp" %>
		
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Fuerza</th>
						<th scope="col">Experiencia</th>
						<th scope="col">Foto</th>
						<th scope="col">Arma</th>
						<th scope="col">Escudo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${caballeros}" var="caballero">
						<tr>
							<td>${caballero.id}</td>
							<td>${caballero.nombre}</td>
							<td>${caballero.fuerza}</td>
							<td>${caballero.experiencia}</td>
							<td>${caballero.foto}</td>
							<td>${caballero.arma.nombre}</td>
							<td>${caballero.escudo.nombre}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>


