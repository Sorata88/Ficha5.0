document.addEventListener('DOMContentLoaded', function(){

    var urlParams = new URLSearchParams(window.location.search);
    const idficha = urlParams.get('idficha');
    const op = urlParams.get('op');
    ficha_editar(idficha, op);


    const nivel = document.getElementById('nivel');
    const bonoCompetencia = document.getElementById('bono_competencia');

    function nivel_competencia(){
        if (nivel.value == 1 || nivel.value == 2 || nivel.value == 3 || nivel.value == 4){
            bonoCompetencia.value = 2;
        } else if (nivel.value == 5 || nivel.value == 6 || nivel.value == 7 || nivel.value == 8){
            bonoCompetencia.value = 3;
        } else if (nivel.value == 9 || nivel.value == 10 || nivel.value == 11 || nivel.value == 12){
            bonoCompetencia.value = 4;
        } else if (nivel.value == 13 || nivel.value == 14 || nivel.value == 15 || nivel.value == 16){
            bonoCompetencia.value = 5;
        } else if (nivel.value == 17 || nivel.value == 18 || nivel.value == 19 || nivel.value == 20){
            bonoCompetencia.value = 6;
        }
    }
    nivel.addEventListener('change', nivel_competencia);



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

    let form_ficha = document.getElementById('form_ficha');
    form_ficha.addEventListener('submit', function(e){
        e.preventDefault();
    })




})