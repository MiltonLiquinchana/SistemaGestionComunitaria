<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login </title>
    <link rel="stylesheet" href="./css/estilos_login.css">
</head>

<body>
    <div class="contenedor-form">
        <div class="toggle">
            <a class="span" href="paginas/registroUsuarioLogin.jsp"> Crear Usuarios</a>
        </div>

        <div class="formulario">
            <h2>Iniciar Sesión</h2>
            <form method="post" action="Validacion">
                <input type="text" placeholder="Usuario" name="user_name" minlength="5" maxlength="10" required
                    title="Letras y números. Tamaño mínimo: 5. Tamaño máximo: 10">
                <input type="password" placeholder="password" name="password" required
                    title="verifique la contraseña">
                <button type="submit" value="valor" name="login">Iniciar Sesión</button>
            </form>
        </div>
        <div class="reset-password">
            <a href="#">Olvide mi Contraseña?</a>
        </div>
    </div>
    <script src="css/jquery.js"></script>

</body>

</html>