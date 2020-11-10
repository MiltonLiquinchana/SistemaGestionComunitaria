<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilosRegistroConsumo.css">
        <title>REGISTRO DE CONSUMOS</title>
    </head>

    <body>
        <div class="div_contenedor">
            <header>
                <h1>Registro de Consumo</h1>
            </header>
            <form action="" method="post" class="form_cobro_actividades">
                <!--div busqueda y seleccion opciones de busqueda-->
                <div>
                    <label for="" class="label_busqueda"> <img src="./imagenes/magnifying-glass.png"
                                                               alt="">INGRESE PARA BUSCAR:
                        <input type="search" name="dato" id="dato" placeholder="INGRESE CEDULA/NOMBRES" class="input_cednom_socio">
                        <button type="button"class="btn_form_cobro_actividades" id="btn_buscar_Consumidor">BUSCAR</button></label>
                </div>

                <!--div datos cliente-->
                <div class="cont_forms">
                    <div class="cont_contenedores">

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">CEDULA:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese el numero de cedula" disabled value="${comunero.getCedula()}">
                        </div>
                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">NOMBRES Y APELLIDOS:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese los nombres y apellidos" disabled value="${comunero.getPrimer_nombre()} ${comunero.getSegundo_nombre()} ${comunero.getPrimer_apellido()} ${comunero.getSegundo_apellido()}">
                        </div>

                        <div class="cont_campos_form_registro">
                            <input type="text" name="temporal" id="valorp" value="${valuemedi}" style="visibility: hidden">
                            <label for="" class="label_campos_form_registro_socios" >NUMERO DE MEDIDOR:</label>                           
                            <select name="listaMedidor" id="listaMedidor" class="campo_form_registro_socios lista">
                                <option>Seleccione un medidor</option>  
                                <c:forEach var="list" items="${lista}">
                                    <option class="opcionlista" value="${list.getNumero_medidor()}">${list.getNumero_medidor()}</option>   
                                </c:forEach>             
                            </select>
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">LECTURA ANTERIOR:</label>
                            <input type="text" name="lecturaAnterior" id="lecturaAnterior" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese la lectura anterior" disabled value="${consumo.getLectura_anterior()}">
                        </div>

                        <div class="cont_campos_form_registro">

                            <label for="" class="label_campos_form_registro_socios">LECTURA ACTUAL:</label>
                            <input type="text" name="lecturaActual" id="lecturaActual" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese la lectura actual" minlength="2" maxlength="100" required pattern="[z0-9]+"
                                   title="Solo se pueden agregar Valores numericos" value="${valuelectura}">
                        </div>

                        <div class="cont_campos_form_registro">                           
                            <label for="" class="label_campos_form_registro_socios">CONSUMO TOTAL m3:</label>
                            <input type="text" name="conumomcubico" id="conumomcubico" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese el total de los metros cubicos consumidos" disabled value="${valorconsumido}">
                        </div>
                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">Tipo Consumo</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese los nombres y apellidos" disabled value="${tipoconsumo}">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">FECHA DEL REGISTRO</label>
                            <input type="date" name="fechaRegistroActual" id="fechaRegistroActual" class="campo_form_registro_socios bloques">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">FECHA LIMITE DE PAGO</label>
                            <input type="date" name="" id="" class="campo_form_registro_socios bloques" value="${fechalimitepago}">
                        </div>

                    </div>
                    <div class="cont_campos_form_registro">
                        <label for="" class="label_campos_form_registro_socios">TOTAL A PAGAR:</label>
                        <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                               placeholder="Ingrese el total a pagar" value="${total}">
                    </div>



                </div>

                <div class="botones">
                    <!--Botones para enviar informacion del formualrio-->
                    <button type="button" class="btn_form_cobro_actividades" id="guardar">GUARDAR</button>
                    <button type="button" class="btn_form_cobro_actividades">CANCELAR</button>
                    <button type="button" class="btn_form_cobro_actividades">NUEVO</button>
                    <button type="button" class="btn_form_cobro_actividades">LIMPIAR</button>
                </div>

        </div>
    </form>
</div>
<!--jquery-->
<script src="css/jquery.js"></script>
<!--mi archivo javascript-->
<script src="css/funcionesRegistroConsumo.js"></script>
</body>

</html>