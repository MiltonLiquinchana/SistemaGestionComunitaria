var ref_genera_input, ref_genera_buton, ref_genera_select;
ref_genera_input = document.querySelectorAll('input');
ref_genera_buton = document.querySelectorAll('button');
ref_genera_select = document.querySelectorAll('select');
window.addEventListener("load", inicio);
function inicio() {
    /*agregamos eventos a los componentes del formulario*/
    ref_genera_buton[0].addEventListener("click", buscar);/*al hacer click en el boton buscar*/
    ref_genera_select[0].addEventListener("change", listarConsumos);/*cuando detecte algun cambio en el valor del select*/
    ref_genera_select[1].addEventListener("change", listardatosConsumo);


    if (ref_genera_input[3].value !== "") {/*comprobamos que el input que temporalmente tomara el valor de la opcion seleccionada no este vacio*/
        ref_genera_select[0].value = ref_genera_input[3].value;/*de ser el caso asignamos lo que tenga el input al select esto con el proposito de que
         * no se cambie el valor al recargar la pagina*/
    }
    if (ref_genera_input[4].value !== "") {
        ref_genera_select[1].value = ref_genera_input[4].value;
    }


};
function buscar() {
    window.location.replace('Controles?menu=PAgua&accion=buscar&dato=' + ref_genera_input[0].value);
};
function listarConsumos() {
    if (ref_genera_select[0].value > 0) {
        window.location.replace('Controles?menu=PAgua&accion=buscarconsumoimpaga&dato=' + ref_genera_input[1].value + '&pk_medidor=' + ref_genera_select[0].value);
    }
};
function listardatosConsumo() {
    //window.location.replace('Controles?menu=PAgua&accion=buscarDatosConsumoImpaga&dato=' + ref_genera_input[3].value + '&pk_medidor=' + ref_genera_select[0].value + "&pk_consumoimpaga=" + ref_genera_select[1].value);

};