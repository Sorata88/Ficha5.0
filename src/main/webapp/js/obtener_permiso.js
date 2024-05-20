let elementoRegistro = document.getElementById("registro");
let boton_crear = document.getElementById("boton_enviar");
let barra_logout = document.getElementById("sesion_iniciada");
let check_sesion = document.getElementById("check_sesion");



let logout = document.getElementById("logout");
logout.addEventListener("click", function(){
    fetch("Gestion_login?opt=logout")
        .then(usuario = "");
        console.log(usuario);
})

    function obtener_permiso(){
        fetch("Gestion_login?opt=acceso")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Error de permisos.")
                }
                return response.text();
            })
            .then (permiso => {
                actualizarMenu(permiso);
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }

    let permiso = obtener_permiso();

function actualizarMenu(permiso){

    if (permiso == 1) {
        barra_logout.style.display = "block";
        check_sesion.style.display = "block";
        elementoRegistro.innerHTML = "ADMIN";
        elementoRegistro.href = "admin.html";
    } else if (permiso == 5) {
        barra_logout.style.display = "block";
        check_sesion.style.display = "block";
        elementoRegistro.style.display = "none";
    } else {
        barra_logout.style.display = "block";
        check_sesion.style.display = "none";
        boton_crear.style.display = "none";
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

        })
}
let dame_nombre = obtener_nickname();


