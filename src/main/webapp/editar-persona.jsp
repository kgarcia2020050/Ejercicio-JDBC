<%-- 
    Document   : editar-persona
    Created on : Jun 2, 2022, 5:01:56 PM
    Author     : gerar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <!-- CSS only    -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

    </head>
    <body>

        <div class="container">
                    <h1>Editar la informacion de ${idObtenido.nombre} ${idObtenido.apellido}</h1>

            <div class="row align-items-md-stretch">
                <div class="col-md-12">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-body">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletCliente?accion=modificar&idCliente=${idObtenido.idCliente}">

                                    <div class="mb-3">
                                        <label class="form-label">Nombre</label>
                                        <input name="nombre" type="text" class="form-control" value="${idObtenido.nombre}"  required>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Apellido</label>
                                        <input name="apellido" type="text" class="form-control" value="${idObtenido.apellido}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Email</label>
                                        <input name="email" type="email" class="form-control" value="${idObtenido.email}" required was-validated>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Telefono</label>
                                        <input name="telefono" type="text" class="form-control" value="${idObtenido.telefono}" required>
                                    </div>                            <div class="mb-3">
                                        <label class="form-label">Saldo</label>
                                        <input name="saldo" type="number" class="form-control" value="${idObtenido.saldo}" required>
                                    </div>
                            </div>
                            <div class="modal-footer">

                                <a href="${pageContext.request.contextPath}/ServletCliente">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                </a>
                                <button type="submit" class="btn btn-primary">Guardar cambios</button>
                            </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
