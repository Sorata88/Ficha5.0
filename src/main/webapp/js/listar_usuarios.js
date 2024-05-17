function llamada() {
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
    xhr.open("GET", "Gestion_usuario?op=1", false);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
    pintar(resultados);

}

function pintar(datos) {

    let html = "<table>";
    html += "<tr><th>Idusuario</th><th>Nombre de usuario</th><th>Correo</th><th>Contraseña</th><th>Permiso</th></tr>"
    for (let i = 0; i < datos.length; i++) {
        html +=
            "<tr><td>" + datos[i].idusuario +
            "</td><td>" + datos[i].nickname +
            "</td><td>" + datos[i].correo +
            "</td><td>" + datos[i].password +
            "</td><td>" + datos[i].permiso +
            "</td><td><a href='editar_usuario.html?id="+datos[i].idusuario+"&op=2'>Editar</a>" +
            "</td><td><a href='javascript:borrarUsuario("+datos[i].idusuario+")'>Borrar</a>" +
            "</td></tr>";
    }
    html += "</table>";
    document.getElementById("listado_usuarios").innerHTML = html;
}

function borrarUsuario(idusuario) {
    if(confirm("¿Estás seguro de que deseas eliminar a este usuario? (esta acción será irreversible)")){
        fetch('Gestion_usuario?id='+idusuario+'&op=3')
            .then(res => res.json())
            .then(data => pintar(data))
    }
}

window.onload = function (){
    llamada();
}