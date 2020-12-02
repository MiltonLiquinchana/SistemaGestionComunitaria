<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilosCobroAgua.css">
        <title>COBRO DE AGUA</title>
    </head>

    <body>
        <div class="div_contenedor">
            <header>
                <h1>Cobro de Consumos</h1>
            </header>
            <form action="" method="post" class="form_cobro_actividades">
                <!--div busqueda y seleccion opciones de busqueda-->
                <div>
                    <label for="" class="label_busqueda"> <img src="./imagenes/magnifying-glass.png" alt="">BUSCAR POR:
                        <input type="search" name="" id="txtBusqueda" placeholder="CEDULA/NOMBRES Y APELLIDOS"
                               class="input_cednom_socio">
                        <button type="button" class="btn_form_cobro_actividades">BUSCAR</button></label>
                </div>

                <!--div datos cliente-->
                <div class="cont_forms">
                    <div class="cont_contenedores">
                        <div class="anticipo">
                            <label for=""> TOTAL DE LA DEUDA GENERAL<input type="text" name="" id=""
                                                                           class="static_input_form_cobro_cuotas"> TOTAL DE ANTICIPOS <input type="text" name=""
                                                                           id="" class="static_input_form_cobro_cuotas"></label>
                        </div>
                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">CEDULA:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese el numero de cedula" value="${comunero.getCedula()}">
                        </div>
                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">NOMBRES Y APELLIDOS:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese los nombres y apellidos" value="${comunero.getPrimer_nombre()} ${comunero.getSegundo_nombre()} ${comunero.getPrimer_apellido()} ${comunero.getSegundo_apellido()}">
                        </div>

                        <div class="cont_campos_form_registro">
                            <input type="text" name="temporal" id="" value="${valuepkmedidor}">
                            <label for="" class="label_campos_form_registro_socios" >NUMERO DE MEDIDOR:</label>                           
                            <select name="listaMedidor" id="listaMedidor" class="campo_form_registro_socios lista">
                                <option>Seleccione un medidor</option>  
                                <c:forEach var="list" items="${lista}">
                                    <option class="opcionlista" value="${list.getPk_medidor()}">${list.getNumero_medidor()}</option>   
                                </c:forEach>             
                            </select>
                        </div>

                        <div class="cont_campos_form_registro">
                            <input type="text" name="temporal" id="" value="${pkconsumoimpaga}">
                            <label for="" class="label_campos_form_registro_socios" >SELECCIONE EL CONSUMO:</label>                           
                            <select name="listaConsumo" id="listaConsumo" class="campo_form_registro_socios lista">
                                <option value="">Seleccione un consumo</option>  
                                <c:forEach var="listc" items="${listacosnumoimpaga}">
                                    <option class="opcionlista" value="${listc.getPk_consumo()}">${listc.getFecha_lectura()}</option>   
                                </c:forEach>             
                            </select>
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">TOTAL CONSUMO:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese el el nombre de la cuota">
                        </div>


                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">TIPO DE CONSUMO:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese los nombres y apellidos" value="">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">FECHA DE LECTURA</label>
                            <input type="date" name="" id="" class="campo_form_registro_socios bloques">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">FECHA LIMITE DE CANCELACION</label>
                            <input type="date" name="" id="" class="campo_form_registro_socios bloques">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">FECHA DE CANCELACION</label>
                            <input type="date" name="" id="" class="campo_form_registro_socios bloques">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">SUBTOTAL A PAGAR</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese el subtotal a pagar">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">Tipo Multa</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese tipo multa" disabled value="${tipoMulta}">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">DIAS DE RETRASO</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese los dias de retraso">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">TOTAL MULTA:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese el el nombre de la cuota">
                        </div>
                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">TARIFA AMBIENTE:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese el valor de la tarifa ambiente">
                        </div>
                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">TARIFA ALCANTARILLADO:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese el valor de la tarifa de alcantarillado">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">TOTAL A PAGAR:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="TOTAL A PAGAR=VALOR CONSUMO + (TIEMPO DE RETRASO * MULTA) ">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">DEPOSITO EN EFECTIVO:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="Ingrese el deposito en efectivo">
                        </div>

                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">CAMBIO:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="El total de cambio a entregar">
                        </div>
                        <div class="cont_campos_form_registro">
                            <label for="" class="label_campos_form_registro_socios">SALDO PENDIENTE:</label>
                            <input type="text" name="" id="" class="campo_form_registro_socios bloques"
                                   placeholder="El saldo total del saldo pendiente">
                        </div>
                    </div>


                    <div class="botones">
                        <!--Botones para enviar informacion del formualrio-->
                        <button type="submit" class="btn_form_cobro_actividades">COBRAR</button>
                        <button type="submit" class="btn_form_cobro_actividades">CANCELAR</button>
                        <button type="submit" class="btn_form_cobro_actividades">NUEVO</button>
                        <button type="submit" class="btn_form_cobro_actividades">LIMPIAR</button>
                        <button type="submit" class="btn_form_cobro_actividades">REGISTROS</button>
                    </div>
                </div>
            </form>
        </div>
        <script src="js/cobroAgua.js"></script>
    </body>

</html>