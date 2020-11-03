/**aqui le decimos que al cargar el documento
 * nos ejecute esta funcion
 */
var ideoma = {
    "decimal": "",
    "emptyTable": "No data available in table",
    "info": "Showing _START_ to _END_ of _TOTAL_ entries",
    "infoEmpty": "Showing 0 to 0 of 0 entries",
    "infoFiltered": "(filtered from _MAX_ total entries)",
    "infoPostFix": "",
    "thousands": ",",
    "lengthMenu": "Show _MENU_ entries",
    "loadingRecords": "Loading...",
    "processing": "Processing...",
    "search": "Filtrar:",
    "zeroRecords": "No matching records found",
    "paginate": {
        "first": "First",
        "last": "Last",
        "next": "Next",
        "previous": "Previous"
    },
    "aria": {
        "sortAscending": ": activate to sort column ascending",
        "sortDescending": ": activate to sort column descending"
    }
}
var identificador;
/*funcion para obtener datos de la tabla */
var obtener_data = function (tbody, table) {
    $(tbody).on("click", "button.eliminar", function () {
        var data = table.row($(this).parents("tr")).data();
        identificador = data[0];
        $('#staticBackdrop').modal();
        //$("#confirmar").val(data[0]);

    });
    $(tbody).on("click", "button.editar", function () {
        var data = table.row($(this).parents("tr")).data();
        identificador = data[0];
        window.location.replace('Controles?menu=Socios&accion=editar&id=' + identificador);

    });
};
/*funcion enviar id al confirmar en el modal si desea eliminar*/
var obid = function () {
    window.location.replace('Controles?menu=Socios&accion=eliminar&id=' + identificador);
};

$(document).ready(function () {
    /*agregamos nuestra tabla(el id de la tabla) */
    var table = $("#table-fix").DataTable({
        "scrollY": "200px",
        "scrollX": true,
        "scrollCollapse": true,
        "paging": false,
        "ordering": false,
        "language": ideoma,
        "info": false
    });
    obtener_data("#table-fix tbody", table);
});