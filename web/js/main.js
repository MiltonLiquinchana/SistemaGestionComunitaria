var submenuno = document.getElementById("subuno");
var submendos = document.getElementById("subdos");
var submentres = document.getElementById("subtres");
var submencuatro= document.getElementById("subcuatro");
var menu = document.getElementById("navegacion");
// MOSTRANDO SUBMENU
function retroceso() {
	submenuno.style.left = "-100%";
	submendos.style.left = "-100%";
	submentres.style.left="-100%";
	submencuatro.style.left="-100%";
}
function mostrarsubuno() {
	submenuno.style.left = "0%";
	submendos.style.left = "-100%";
	
}
function mostrarsubdos() {
	submenuno.style.left = "-100%";
	submendos.style.left = "0%";
}

function mostrarsubtres(){
	submenuno.style.left = "-100%";
	submendos.style.left = "-100%";
	submentres.style.left="0%";
}
function mostrarsubcuatro(){
	submenuno.style.left = "-100%";
	submendos.style.left = "-100%";
	submentres.style.left="-100%";
	submencuatro.style.left="0%";
}
function ocultar() {
	if (menu.style.left === "-100%") {
		menu.style.left = "0%";
	} else {
		menu.style.left="-100%";
	}

}





