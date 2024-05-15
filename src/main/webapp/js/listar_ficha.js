    function llamada() {
        /*fetch('Gestion_ficha?op=1')
        .then(res => res.json())
        .then (data => pintar(data))*/
        let resultados;
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    try {
                        resultados = JSON.parse(xhr.responseText);
                    } catch (e) {
                        console.log('Error parsing JSON', e, xhr.status, xhr.responseText);
                    }
                }
            }

        };
        xhr.open("GET", "Gestion_ficha?op=1", false);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send();
        pintar(resultados);

    }

    function pintar(ficha) {

        let html = "<table>";
        html += "<tr><th hidden=''>Idficha</th><th>Nombre del jugador</th><th>Nombre del personaje</th><th>Raza</th><th>Clase</th><th>Nivel</th><th>Trasfondo</th><th>Alineamiento</th><th>Puntos de experiencia</th><th>Bono de competencia</th></tr>"
        for (let i = 0; i < ficha.length; i++) {
            html +=
                "<tr><td hidden>" + ficha[i].idficha +
                "</td><td>" + ficha[i].nombre +
                "</td><td>" + ficha[i].nombrepj +
                "</td><td>" + ficha[i].raza +
                "</td><td>" + ficha[i].clase +
                "</td><td>" + ficha[i].nivel +
                "</td><td>" + ficha[i].trasfondo +
                "</td><td>" + ficha[i].alineamiento +
                "</td><td>" + ficha[i].px +
                "</td><td>+" + ficha[i].bono_competencia +
                "</td><td><a href='ficha_readonly.html?idficha="+ficha[i].idficha+"&op=4'>Ver ficha</a>" +
                "</td><td><a href='ficha.html?idficha="+ficha[i].idficha+"&op=2'>Editar</a>" +
                "</td><td><a href='javascript:borrarFicha("+ficha[i].idficha+")'>Borrar</a>" +
                "</td></tr>";
        }
        html += "</table>";
        document.getElementById("listado").innerHTML = html;
    }

    function borrarFicha(idficha) {
        if(confirm("¿Estás seguro de que deseas eliminar esta ficha? (esta acción será irreversible)")){
            fetch('Gestion_ficha?idficha='+idficha+'&op=3')
                .then(res => res.json())
                .then(data => pintar(data))
        }
    }

    window.onload = function (){
        llamada();
    }

