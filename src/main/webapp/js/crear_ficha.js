    var level = document.getElementById('nivel');
    var bonoCompetencia = document.getElementById('bono_competencia');

    function nivel_competencia(){
        if (level.value == 1 || level.value == 2 || level.value == 3 || level.value == 4){
            bonoCompetencia.value = 2;
        } else if (level.value == 5 || level.value == 6 || level.value == 7 || level.value == 8){
            bonoCompetencia.value = 3;
        } else if (level.value == 9 || level.value == 10 || level.value == 11 || level.value == 12){
            bonoCompetencia.value = 4;
        } else if (level.value == 13 || level.value == 14 || level.value == 15 || level.value == 16){
            bonoCompetencia.value = 5;
        } else if (level.value == 17 || level.value == 18 || level.value == 19 || level.value == 20){
            bonoCompetencia.value = 6;
        }
    }

    level.addEventListener('change', nivel_competencia);

    let boton_enviar = document.getElementById('boton_enviar');

    boton_enviar.addEventListener('click', function (){
        crear_ficha("Gestion_ficha");
    })

    function crear_ficha(url) {
        let data_send = new FormData(formulario);

        fetch(url, {method: 'POST', body: data_send})
            .then(response => {
                if (response.ok) {
                    window.history.back();
                } else {
                    throw new Error('Error al crear la ficha. Revisa los campos y vuelve a intentarlo.');
                }
            })

            .catch(error => {
                console.log(error.message);
            });




    }
