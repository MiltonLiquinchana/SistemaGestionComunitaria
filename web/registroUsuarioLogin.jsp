<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilosRegistroUsuarioLogin.css">
    <title>REGISTRO DE SOCIOS</title>
</head>

<body>
    <div class="div_contenedor">

        <header>
            <h1>Registro de Socios</h1>
        </header>
        <div class="cont_forms">
            <form action="" method="post" class="form_registro_socios">
                <div class="cont_contenedores">
                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">CEDULA:</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese el numero de cedula" minlength="10" maxlength="10" required
                            pattern="[0-9]{10,10}" title="Verifique el numero de cedula">
                    </div>
                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">PRIMER NOMBRE:</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese el primer nombre" required pattern="[a-zA-Z]*"
                            title="Agrege el primer nombre sin espacios ni caracteres especiales !,#,%,&">
                    </div>

                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">SEGUNDO NOMBRE:</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese el segundo nombre" required pattern="[a-zA-Z]*"
                            title="Agrege el segundo nombre sin espacios ni caracteres especiales !,#,%,&">
                    </div>

                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">PRIMER APELLIDO:</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese el primer apellido" required pattern="[a-zA-Z]*"
                            title="Agrege el primer apellido sin espacios ni caracteres especiales !,#,%,&">
                    </div>

                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">SEGUNDO APELLIDO</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese el segundo apellido" required pattern="[a-zA-Z]*"
                            title="Agrege el segundo apellido sin espacios ni caracteres especiales !,#,%,&">
                    </div>
                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">TELEFONO:</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese el numero de telefono" minlength="10" maxlength="10" required
                            pattern="[z0-9]{10,10}"
                            title="verifique el numero de telefono, si no dispone de un numero de telefono ingrese 10 veces 0">
                    </div>
                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">DIRECCION DE DOMICILIO:</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese la direccion del domicilio">
                    </div>

                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">REFERENCIA GEOGRAFICA:</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese una referencia geografica del domicilio" required>
                    </div>
                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">FECHA DE NACIMIENTO</label>
                        <input type="date" name="" id="" class="campo_form_registro_socios bloques">
                    </div>
                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">EDAD:</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese la edad en años" minlength="1" max="3" required required
                            pattern="[z0-9]{1-3}" title="verifique, la edad debe estar en un rango de 1 a 100">
                    </div>
                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">NOMBRE DE USUARIO:</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese el nombre de usuario" pattern="[a-zA-Z]*"
                            title="Agrege el usuario sin espacios ni caracteres especiales !,#,%,&">
                    </div>


                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">CONTRASEÑA:</label>
                        <input type="password" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Ingrese la contraseña" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                            title="La contraseña debe contener al menos un número y una letra mayúscula y minúscula, y al menos 8 o más caracteres">
                    </div>
                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">REPITA LA CONTRASEÑA:</label>
                        <input type="password" name="" id="" class="campo_form_registro_socios bloques"
                            placeholder="Repita la contraseña" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                            title="La contraseña debe contener al menos un número y una letra mayúscula y minúscula, y al menos 8 o más caracteres">
                    </div>
                </div>

                <div class="botones">
                    <!--Botones para enviar informacion del formualrio-->
                    <button type="submit" class="btn_form_reg_socio">Registrarse</button>
                    <button type="submit" class="btn_form_reg_socio">CANCELAR</button>
                </div>

            </form>
        </div>
    </div>
</body>

</html>