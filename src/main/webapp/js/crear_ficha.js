document.addEventListener('DOMContentLoaded', () => {

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

    /*let select_raza = document.getElementById('raza');
    let select_subraza = document.getElementById('subraza');
    select_raza.addEventListener('change', ()=>{
        if(select_raza.value == "Enano"){
            select_subraza = "Enano de las colinas"
        } else if (select_raza.value == "Elfo"){
            select_subraza == "Alto elfo" || select_subraza == "Elfo de los bosques" || select_subraza == "Elfo oscuro (drow)"
        }
    });*/


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
})