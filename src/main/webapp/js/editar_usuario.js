document.addEventListener('DOMContentLoaded', () => {
    var urlParams = new URLSearchParams(window.location.search);
    const idusuario = urlParams.get('id');
    const op = urlParams.get('op');
    editar_usuario(idusuario, op);
})

function editar_usuario(idusuario, op){
    fetch('Gestion_usuario?id='+idusuario+'&op='+op)
        .then(res => res.json())
        .then(data => mostrarForm(data));
}


function mostrarForm(datos) {
    document.getElementById('id_usuario').value = datos.idusuario;
    document.getElementById("nickname").value = datos.nickname;
    document.getElementById("password").value = datos.password;
    document.getElementById("correo").value = datos.correo;
    document.getElementById("permiso").value = datos.nivel_permiso;
}