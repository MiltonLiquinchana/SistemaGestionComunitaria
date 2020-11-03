window.addEventListener("load", inicio);
var referencia_btn_guardar,referencia_cedula,referencia_pnombre,referencia_snombre,referencia_papellido,referencia_sapellido,referencia_telefono,referencia_direcciond
,referencia_listacomunaRsocios,referencia_referenciaG,referencia_fechan,referencia_edad,referencia_nombreus,referencia_listatipoRsocios,referencia_contraseniaus,referencia_rcontraseniaus;

referencia_btn_guardar = document.getElementById("btn_guardar");
referencia_cedula=document.getElementById("cedula");
referencia_pnombre=document.getElementById("pnombre");
referencia_snombre=document.getElementById("snombre");
referencia_papellido=document.getElementById("papellido");
referencia_sapellido=document.getElementById("sapellido");
referencia_telefono=document.getElementById("telefono");
referencia_direcciond=document.getElementById("direcciond");
referencia_listacomunaRsocios=document.getElementById("listacomunaRsocios");
referencia_referenciaG=document.getElementById("referenciaG");
referencia_fechan=document.getElementById("fechan");
referencia_edad=document.getElementById("edad");
referencia_nombreus=document.getElementById("nombreus");
referencia_listatipoRsocios=document.getElementById("listatipoRsocios");
referencia_contraseniaus=document.getElementById("contraseniaus");
referencia_rcontraseniaus=document.getElementById("rcontraseniaus");
function inicio() {
    referencia_btn_guardar.addEventListener("click", guardar);
}

function guardar() {
    window.location.replace('Controles?menu=RSocios&accion=guardar&cedula='+referencia_cedula.value+'&pnombre='+referencia_pnombre.value+'&snombre='+referencia_snombre.value
            +'&papellido='+referencia_papellido.value+'&sapellido='+referencia_sapellido.value+'&telefono='+referencia_telefono.value+'&direccion='+referencia_direcciond.value
            +'&listacomunaRsocios='+referencia_listacomunaRsocios.value+'&referenciaG='+referencia_referenciaG.value+'&fechan='+referencia_fechan.value+'&edad='+referencia_edad.value
            +'&nombreus='+referencia_nombreus.value+'&listatipoRsocios='+referencia_listatipoRsocios.value+'&contraseniaus='+referencia_contraseniaus.value+'&rcontraseniaus='+referencia_rcontraseniaus.value);
}