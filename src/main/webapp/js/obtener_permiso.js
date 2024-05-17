

function obtener_permiso(){
    fetch("Gestion_login")
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
    let elementoRegistro = document.getElementById("registro");
    let elementoLogOut = document.getElementById("logout");

    if (permiso == 1) {
        elementoRegistro.innerHTML = "ADMIN";
        elementoRegistro.href = "admin.html";
        elementoLogOut.style.display = "inline-block";
    } else if (permiso == 5) {
        elementoRegistro.style.display = "none";
        elementoLogOut.style.display = "inline-block";
    } else {
        elementoRegistro.innerHTML = "ACCESO/REGISTRO";
        elementoRegistro.href = "login-registro.html";
        elemetoLogOut.style.display = "none";
    }
}