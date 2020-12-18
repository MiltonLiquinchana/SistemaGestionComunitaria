var ref_genera_input, ref_genera_buton, ref_genera_select;
ref_genera_input = document.querySelectorAll('input');
ref_genera_buton = document.querySelectorAll('button');
ref_genera_select = document.querySelectorAll('select');
window.addEventListener("load", inicio);
function inicio() {
    /*agregamos eventos a los componentes del formulario*/
    ref_genera_buton[0].addEventListener("click", buscar); /*al hacer click en el boton buscar*/
    ref_genera_select[0].addEventListener("change", listarConsumos); /*cuando detecte algun cambio en el valor del select*/
    ref_genera_select[1].addEventListener("change", listardatosConsumo);
    ref_genera_input[17].addEventListener("input", calcular);
    ref_genera_buton[1].addEventListener("click", guardar);//evento que se ejecuta al hacer click en el boton guardar

    if (ref_genera_input[3].value !== "") {/*comprobamos que el input que temporalmente tomara el valor de la opcion seleccionada no este vacio*/
        ref_genera_select[0].value = ref_genera_input[3].value; /*de ser el caso asignamos lo que tenga el input al select esto con el proposito de que
         * no se cambie el valor al recargar la pagina*/
    }
    if (ref_genera_input[4].value !== "") {
        ref_genera_select[1].value = ref_genera_input[4].value;
    }

    var fecha = new Date();
    var anio = fecha.getFullYear();
    var mes = fecha.getMonth() + 1;
    var dia = fecha.getDate();
    if (dia < 10) {
        dia = '0' + dia;
    } //agrega cero si el menor de 10
    if (mes < 10) {
        mes = '0' + mes;
    } //agrega cero si el menor de 10
    ref_genera_input[9].value = anio + "-" + mes + "-" + dia;
}
;

function buscar() {
    window.location.replace('Controles?menu=PAgua&accion=buscar&dato=' + ref_genera_input[0].value);
}
;

function listarConsumos() {
    if (ref_genera_select[0].value > 0) {
        window.location.replace('Controles?menu=PAgua&accion=buscarconsumoimpaga&dato=' + ref_genera_input[1].value + '&pk_medidor=' + ref_genera_select[0].value);
    }
}
;

function listardatosConsumo() {
    window.location.replace('Controles?menu=PAgua&accion=buscarDatosConsumoImpaga&dato=' + ref_genera_input[1].value + '&pk_medidor=' + ref_genera_select[0].value + "&pk_consumoimpaga=" + ref_genera_select[1].value);
}
;

/*esta funciones solo para calcular cuanto es el cambio que hay que entregar es obligarorio rellenar estos campos*/
function calcular() {
    if (ref_genera_input[17].value.length > 0) {
        ref_genera_input[18].value = (ref_genera_input[17].value - ref_genera_input[16].value).toFixed(2);
    }
}
;

//funcion para guardar el pago
function guardar() {
    if (ref_genera_input[17].value >= ref_genera_input[16].value) {
        window.location.replace('Controles?menu=PAgua&accion=guardarpago&diasretraso=' + ref_genera_input[12].value + '&fecha_limite=' + ref_genera_input[8].value + "&cedula=" + ref_genera_input[1].value + "&valor_mul=" + ref_genera_input[13].value + "&total_pag=" + ref_genera_input[16].value + "&fk_consumo=" + ref_genera_input[4].value);
    }
    if (ref_genera_input[17].value < ref_genera_input[16].value) {
        alert("Verificar campos vacios");
    }
}
;
