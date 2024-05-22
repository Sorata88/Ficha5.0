function llamada(username){
    let opcion_gestion = 0;
    if(username == "admin"){
        opcion_gestion = 1
    } else if (username == "") {
        opcion_gestion = 0
    } else {
        opcion_gestion = 5
    }
    fetch('Gestion_ficha?op='+opcion_gestion)
        .then(res => res.json())
        .then(data => pintar(data));
}

function pintar(ficha) {
    let html = "<table style='margin: 0 auto'>";
    html += "<tr><th hidden=''>Idficha</th><th>Nombre del jugador</th><th>Nombre del personaje</th><th>Raza</th><th>Clase</th><th> Nivel </th><th>Trasfondo</th><th>Alineamiento</th><th>Puntos de experiencia</th><th>Bono de competencia</th></tr>"
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

function obtener_nickname(){
    fetch("Gestion_login?opt=username")
        .then(response => {
            if (!response.ok) {
                throw new Error("Error de usuario.")
            }
            return response.text();
        })
        .then (username => {
            llamada(username);
        })
}


window.onload = function (){
    obtener_nickname();
}