<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <!--stilos css de jquery-->
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
  <!--mis estilos css-->
  <title>Hello, world!</title>
</head>

<body style="background-color: black;">
  <div class="container">
      <h1 style="text-align: center; color: white">Busqueda Socios</h1>
    <div class="cont-tabla">
      <table class="table table-hover" id="table-fix">
        <thead class="thead-dark">
          <tr>
            <th style="display: none;">id</th>
            <th scope="col">EDITAR</th>
            <th scope="col">ELIMINAR</th>
            <th scope="col">CEDULA</th>
            <th scope="col">NOMBRES Y APELLIDOS</th>
            <th scope="col">TELEFONO</th>
            <th scope="col">EDAD</th>
          </tr>
        </thead>
        <tbody>
          <!--aqui agregamos un foreach para recorer las filas, mientras
          se llenan la tabla con los datos de la bd-->
          <c:forEach var="co" items="${comunero}">
            <tr class="text-dark">
              <td style="display: none;">${co.getPk_comunero()}</td>
              <!--editar-->
              <th scope="row">
                <button id="editar" class="editar btn btn-warning"
                        role="button" aria-pressed="true">
                  <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg">
                    <path
                      d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                    <path fill-rule="evenodd"
                      d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                  </svg>
                </button>
              </th>
              <!--eliminar-->
              <th scope="row">
                <button id="eliminar" class="eliminar btn btn-danger" role="button" aria-pressed="true">
                  <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd"
                      d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z" />
                  </svg>
                </button>
              </th>
              <td>${co.getCedula()}</td>
              <td>${co.getPrimer_nombre()} ${co.getSegundo_nombre()} ${co.getPrimer_apellido()}
                ${co.getSegundo_apellido()}</td>
              <td>${co.getTelefono()}</td>
              <td>${co.getEdad()}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <caption>
      <button class="btn btn-primary">Agregar nuevo
        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-plus-square-fill" fill="currentColor"
          xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd"
            d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4a.5.5 0 0 0-1 0v3.5H4a.5.5 0 0 0 0 1h3.5V12a.5.5 0 0 0 1 0V8.5H12a.5.5 0 0 0 0-1H8.5V4z" />
        </svg>
      </button>
    </caption>
  </div>

  <!-- Modal -->
  <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog"
    aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          ...
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <a onclick="obid()" class="btn btn-primary" id="confirmar">confirmar</a>
        </div>
      </div>
    </div>
  </div>

  <!--jquery-->
  <script src="css/jquery.js"></script>
  <script src="http://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
  <!--mi archivo javascript-->
  <script src="css/scriptscroll.js"></script>
  <!--javascript de boostrap-->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
    integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
    crossorigin="anonymous"></script>
</body>

</html>