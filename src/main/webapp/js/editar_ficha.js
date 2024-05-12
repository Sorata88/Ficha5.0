document.addEventListener('DOMContentLoaded', function(){

    var urlParams = new URLSearchParams(window.location.search);
    const idficha = urlParams.get('idficha');
    const op = urlParams.get('op');
    ficha_editar(idficha, op);

    function ficha_editar(idficha, op){
        fetch('Gestion_ficha?idficha='+idficha+'&op='+op)
            .then(res => res.json())
            .then(data => mostrarForm(data));
    }


    function mostrarForm(datos){
        document.getElementById('idficha').value = datos.idficha;
        document.getElementById("nombrejugador").value = datos.nombre;
        document.getElementById("nombrepersonaje").value = datos.nombrepj;
        document.getElementById("raza").value = datos.raza;
        document.getElementById("clase").value = datos.clase;
        document.getElementById("nivel").value = datos.nivel;
        document.getElementById("trasfondo").value = datos.trasfondo;
        document.getElementById("alineamiento").value = datos.alineamiento;
        document.getElementById("px").value = datos.px;
        document.getElementById("bono_competencia").value = datos.bono_competencia;
    }



})