<%-- 
    Document   : clientes
    Created on : Jun 1, 2022, 5:31:21 PM
    Author     : gerar
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes registrados</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <!-- CSS only    -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body>
        <h1>Control de clientes</h1>


        <div class="container">
            <div class="row align-items-md-stretch">
                <div class="col-md-12">

                    <div class="d-grip gap-2 mt-4">
                        <a data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-primary" type="button"
                           >Nuevo cliente</a
                        >
                    </div>
                    <br/>   
                    <table class="table table-hover table-striped">
                        <thead class="bg-dark text-white">
                            <tr>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Email</th>
                                <th>Telefono</th>
                                <th>Saldo</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="listaClientes" items="${listado}">

                                <tr>
                                    <td>${listaClientes.nombre}</td>
                                    <td>${listaClientes.apellido}</td>
                                    <td>${listaClientes.email}</td>
                                    <td>${listaClientes.telefono}</td>
                                    <td>${listaClientes.saldo}</td>

                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletCliente?accion=obtener&idCliente=${listaClientes.idCliente}"><button data-bs-toggle="modal" data-bs-target="#modalEditar" class="btn btn-outline-secondary"><i class="fa-solid fa-pen"></i></button></a>
                                        <a href="${pageContext.request.contextPath}/ServletCliente?accion=eliminar&idCliente=${listaClientes.idCliente}""><button class="btn btn-outline-danger"><i class="fa-solid fa-trash"></i></button></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div>
                <div class="card text-white bg-success mb-3" style="max-width: 18rem; align-items: center">
                    <div class="card-header">Clientes registrados</div>
                    <div class="card-body">
                        <h1 class="card-title"><i class="fa-solid fa-users"></i> ${totalClientes}</h1>
                    </div>
                </div>
            </div>
            <div class="card text-white bg-danger mb-3" style="max-width: 18rem; align-items: center">
                <div class="card-header">Saldo total</div>
                <div class="card-body">
                    <h1 class="card-title">Q ${sumaSaldos}</h1>
                </div>

            </div>
        </div>

        <!-- Modal Agregar-->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Nuevo Cliente</h5>
                    </div>
                    <div class="modal-body">
                        <form method="POST" action="${pageContext.request.contextPath}/ServletCliente?accion=insertar">

                            <div class="mb-3">
                                <label class="form-label">Nombre</label>
                                <input name="nombre" type="text" class="form-control" placeholder="Nombres del cliente" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Apellido</label>
                                <input name="apellido" type="text" class="form-control" placeholder="Apellidos del cliente" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Email</label>
                                <input name="email" type="email" class="form-control" placeholder="Email del cliente" required was-validated>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Telefono</label>
                                <input name="telefono" type="text" class="form-control" placeholder="Numero telefonico del cliente" required>
                            </div>                            <div class="mb-3">
                                <label class="form-label">Saldo</label>
                                <input name="saldo" type="number" class="form-control" placeholder="Saldo del cliente" required>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>