<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<title>Caballeros</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<header
		class="d-flex justify-content-evenly align-items-center h-16 m-2">
		<form method="POST" id="buscarform" action="IndexCaballero">
			<div class="mb-3">
				<label for="nombre" class="form-label">Buscar caballero por nombre</label> <input type="text" class="form-control" id="nombre"
					name="nombre">
			</div>
			<button type="submit" value="guardar" name="guardar"
				class="btn btn-success">Buscar</button>
		</form>
		<form method="POST" id="buscarform" action="IndexCaballero">
			<div class="mb-3">
				<label for="nombre" class="form-label">Eliminar</label>
				 <input type="text" class="form-control" id="nombre"name="nombre">
			</div>
			<button type="submit" value="guardar" name="guardar"
				class="btn btn-danger">Eliminar</button>
		</form>
		<button style="height: 50px;" class=" btn btn-primary col-1"
			type="button" data-bs-toggle="offcanvas"
			data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom">Insertar</button>
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
						<label for="nombre" class="form-label">Nombre</label> <input
							type="text" class="form-control" id="nombre" name="nombre">
					</div>
					<div class="mb-3">
						<label for="fuerza" class="form-label">Fuerza</label> <input
							type="text" class="form-control" id="fuerza" min="0" max="100"
							name="fuerza">
					</div>
					<div class="mb-3">
						<label for="experiencia" class="form-label">Experiencia</label> <input
							type="text" class="form-control" id="experiencia"
							name="experiencia">
					</div>
					<div class="mb-3">
						<label for="foto" class="form-label">Foto</label> <input
							type="text" class="form-control" id="foto" name="foto">
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
					<button type="submit" value="guardar" name="guardar"
						class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</header>

	<main style="height: 90vh">
		<div class="container-fluid">
			<%@ include file="/Validaciones.jsp"%>

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
							<td>
							<button type="button" class="btn btn-danger" data-bs-toggle="modal"	data-bs-target="#modal${caballero.id }">
													<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
														<path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325" />
													</svg>
												</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<c:forEach items="${caballeros}" var="caballero">
					<div class="modal fade" id="modal${caballero.id }" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-5" id="label${caballero.id }">Modificacion</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"	aria-label="Close"></button>
								</div>

								<div class="modal-body">
									<form action="UpdateCaballero" method="post">

										<input type="hidden" value="${caballero.id }" name="idMod"
											aria-describedby="nombreMod">
										<div class="mb-3">
											<label for="exampleInputEmail1" class="form-label">Nombre</label>
											<input type="text" class="form-control" id="nombreMod" name="nombreMod"
												aria-describedby="nombreMod" value="${caballero.nombre}"
												placeholder="${caballero.nombre}">
										</div>

										<div class="mb-3">
											<label for="exampleInputPassword1" class="form-label">Fuerza</label>
											<input type="text" class="form-control" id="apellidoMod" name="fuerzaMod"
												value="${caballero.fuerza}" placeholder="${caballero.fuerza}">
										</div>
										<div class="mb-3">
											<label for="exampleInputPassword1" class="form-label">Experiencia</label>
											<input type="text" class="form-control" id="apellidoMod" name="experienciaMod"
												value="${caballero.experiencia}" placeholder="${caballero.experiencia}">
										</div>
										<div class="mb-3">
											<label for="exampleInputPassword1" class="form-label">Foto</label>
											<input type="text" class="form-control" id="apellidoMod" name="fotoMod"
												value="${caballero.foto}" placeholder="${foto.experiencia}">
										</div>
										<div class="mb-3">
											<label for="exampleInputPassword1" class="form-label">Arma</label>
											<select class="form-select" name="arma_idMod">
											<option value="0"></option>
											<c:forEach items="${armas}" var="arma">
												<option value="${arma.id}">${arma.nombre}</option>
											</c:forEach>
											</select>
										</div>
										<div class="mb-3">
											<label for="exampleInputPassword1" class="form-label">Escudo</label>
											<select class="form-select" name="escudo_idMod">
											<option value="0"></option>
											<c:forEach items="${escudos}" var="escudo">
												<option value="${escudo.id}">${escudo.nombre}</option>
											</c:forEach>
											</select>
										</div>

										<button type="submit" class="btn btn-danger"
											data-bs-dismiss="modal">Guardar</button>
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Cancelar</button>
									</form>

								</div>
							</div>
						</div>
					</div>
				</c:forEach>
	</main>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>


