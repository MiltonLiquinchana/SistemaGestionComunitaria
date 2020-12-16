window.addEventListener("load", inicio);
/*variables de referencia de objetos*/
var referencia_btn_buscar_Consumidor, referencia_listaMedidor, referencia_lecturaActual, referencia_lecturaAnterior, referencia_valorp, referencia_dato, referencia_conumomcubico, referencia_temporald, referencia_fechaRegistroActual, ref_genera_input
        , referencia_btn_guardar, ref_cam_cedula;
referencia_btn_buscar_Consumidor = document.getElementById("btn_buscar_Consumidor");
referencia_listaMedidor = document.getElementById("listaMedidor");
referencia_lecturaActual = document.getElementById("lecturaActual");
referencia_valorp = document.getElementById("valorp");
referencia_dato = document.getElementById("dato");
ref_cam_cedula = document.getElementById("camcedula");
referencia_lecturaAnterior = document.getElementById("lecturaAnterior");
referencia_conumomcubico = document.getElementById("conumomcubico");
referencia_temporald = document.getElementById("temporald");
referencia_fechaRegistroActual = document.getElementById("fechaRegistroActual");
referencia_btn_guardar = document.getElementById("guardar");
ref_genera_input = document.querySelectorAll('input');
/*variables globales*/
var lecturaAnteriorValue;
var lecturaActualValue;
var total;
function inicio() {
    referencia_btn_buscar_Consumidor.addEventListener("click", buscar_Consumidor);
    referencia_listaMedidor.addEventListener("change", buscar_consumo);
    referencia_lecturaActual.addEventListener("input", actulizarValores);
    referencia_lecturaActual.addEventListener("blur", verificacionIngreso);
    referencia_lecturaActual.addEventListener("keypress", cambiocampo);
    referencia_btn_guardar.addEventListener("click", guardardatos);
    /*agregamos nuestra tabla(el id de la tabla) */
    if (referencia_valorp.value !== "") {
        referencia_listaMedidor.value = referencia_valorp.value;
    }
    var fecha = new Date();
    var anio = fecha.getFullYear();
    var mes = fecha.getMonth() + 1;
    var dia = fecha.getDate();
    referencia_fechaRegistroActual.value = anio + "-" + mes + "-" + dia;
}
;
function buscar_Consumidor() {
    window.location.replace('Controles?menu=RConsumos&accion=buscar&dato=' + referencia_dato.value);
}
;
function buscar_consumo() {
    window.location.replace('Controles?menu=RConsumos&accion=select_medidor&dato=' + ref_cam_cedula.value + '&num_medidor=' + referencia_listaMedidor.value);
}
;

function actulizarValores() {
    lecturaAnteriorValue = Number(referencia_lecturaAnterior.value);//tambien se puede convertir con parseInt()
    lecturaActualValue = Number(referencia_lecturaActual.value);
    if (lecturaActualValue > lecturaAnteriorValue) {
        total = lecturaActualValue - lecturaAnteriorValue;
        referencia_lecturaActual.style = "border: 2px black solid";
        referencia_conumomcubico.value = total;
    } else if (lecturaActualValue <= lecturaAnteriorValue) {
        referencia_lecturaActual.style = "border: 3px red solid";
        referencia_conumomcubico.value = "";
        ref_genera_input[9].value = "";
    }

}
;
function verificacionIngreso() {
    if (lecturaActualValue <= lecturaAnteriorValue) {
        alert("la lectura no coincide");
        referencia_lecturaActual.focus();
    }
    if (lecturaActualValue > lecturaAnteriorValue) {
        window.location.replace('Controles?menu=RConsumos&accion=buscarTipoConsumo&dato=' + ref_cam_cedula.value + '&num_medidor=' + referencia_listaMedidor.value + '&lecturaActual=' + lecturaActualValue + '&valorConsumido=' + total);
    }
}
;

function cambiocampo(event) {

    if (event.keyCode === 13) {
        ref_genera_input[9].focus();
    }

}

/*funcion para guardar los datos en la base de datos*/
function guardardatos() {
    if (ref_genera_input[1].value !== "" && ref_genera_input[2].value !== "" && ref_genera_input[3].value !== "" && ref_genera_input[4].value !== "" && ref_genera_input[5].value !== "" && ref_genera_input[6].value !== "" && ref_genera_input[7].value !== "" && ref_genera_input[8].value !== "" && ref_genera_input[9].value !== "" && ref_genera_input[10].value !== "") {
        window.location.replace('Controles?menu=RConsumos&accion=guardar&nummedidor=' + referencia_listaMedidor.value + '&lecturaAnterior=' + referencia_lecturaAnterior.value + '&lecturaActual=' + referencia_lecturaActual.value + '&fechalectura=' + referencia_fechaRegistroActual.value + '&fechalimite=' + ref_genera_input[9].value + '&totalconsumo=' + referencia_conumomcubico.value + '&totalpagar=' + ref_genera_input[10].value + '&tipoconsumo=' + ref_genera_input[7].value);
    } else {
        alert("hola si estan vacios");
    }

}
