let boton_enviar = document.getElementById('boton_enviar');

boton_enviar.addEventListener('click', function (){
    crear_usuario("Gestion_usuario");
})

function crear_usuario(url) {
    let data_send = new FormData(registro_u);

    fetch(url, {method: 'POST', body: data_send})
        .then(response => {
            if (response.ok) {
                window.history.back();
            } else {
                throw new Error('Error al crear un nuevo usuario. Revisa los campos y vuelve a intentarlo.');
            }
        })

        .catch(error => {
            console.log(error.message);
        })
}