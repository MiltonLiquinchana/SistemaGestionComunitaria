<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/estilos.css">
        <title>Hello, world!</title>
    </head>

    <body>
        <div class="contenedor_menu bg-dark">
            <nav nav class="navbar sticky-top navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="icon-menu/user.png" width="50" height="50" class="d-inline-block align-top" alt="">
                    Bootstrap
                </a>
            </nav>
            <!-- As a heading -->
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#"> <img src="icon-menu/house.png" alt=""> Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"  href="Controles?menu=Socios&accion=listar" target="contenidos"> <img src="icon-menu/love.png" alt=""> Socios</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                       aria-expanded="false" onclick="desplegaruno()"> <img src="icon-menu/030-presentation.png" alt=""> Reportes</a>
                    <div class="sub-menu" id="subuno" style="display: none;">
                        <a class="dropdown-item" href="Controles?menu=RAnual" target="contenidos"> Reporte Anual</a>
                        <a class="dropdown-item" href="Controles?menu=RMensual" target="contenidos"> Reporte Mensual</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                       aria-expanded="false" onclick="desplegardos()"> <img src="icon-menu/019-writing-1.png" alt=""> Registrar</a>
                    <div class="sub-menu" id="subdos" style="display: none;">
                        <a class="dropdown-item" href="Controles?menu=RSocios&accion=mostrar" target="contenidos"> Registrar Socios</a>
                        <a class="dropdown-item" href="Controles?menu=RConsumos&accion=mostrar" target="contenidos"> Registrar Consumos</a>
                        <a class="dropdown-item" href="Controles?menu=RActividades" target="contenidos"> Registrar Actividades</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                       aria-expanded="false" onclick="desplegartres()"> <img src="icon-menu/pagos.png" alt=""> Pagos</a>
                    <div class="sub-menu" id="subtres" style="display: none;">
                        <a class="dropdown-item" href="Controles?menu=PAgua" target="contenidos"> Pago de Agua</a>
                        <a class="dropdown-item" href="Controles?menu=PCuotas" target="contenidos"> Pago de Cuotas</a>
                        <a class="dropdown-item" href="Controles?menu=PMultas" target="contenidos"> Pago de Multas</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                       aria-expanded="false" onclick="desplegarcuatro()"> <img src="icon-menu/006-content.png" alt=""> Configuracion</a>
                    <div class="sub-menu" id="subcuatro" style="display: none;">
                        <a class="dropdown-item" href="Controles?menu=RComunidad" target="contenidos"> Registrar Comunidad</a>
                        <a class="dropdown-item" href="Controles?menu=CDescuentos" target="contenidos"> Configurar Descuentos</a>
                        <a class="dropdown-item" href="Controles?menu=Something" target="contenidos">Something else here</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Controles?menu=Contactos" tabindex="-1" aria-disabled="true" target="contenidos"> <img src="icon-menu/love.png" alt=""> Contacto</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Controles?menu=LogOut" tabindex="-1" aria-disabled="true"> <img src="icon-menu/029-power-off.png" alt=""> Cerrar Sesión</a>
                </li>
            </ul>
        </div>
        <div class="contenidos">
            <iframe name="contenidos" src="" frameborder="0" style="width: 100%; height: 100vh;"></iframe>
        </div>
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/javascript_menu.js"></script>
    </body>

</html>