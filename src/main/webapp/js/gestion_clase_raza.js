window.onload = function() {
    raza.addEventListener('change', function () {
        listar_raza(raza.value);
    })

    clase.addEventListener('change', function () {
        listar_clase(clase.value);

    });

}
    let raza = document.getElementById('raza');
    let descripcion = document.getElementById('descripcion');
    let descrip_raza = "";
    //let level = document.getElementById('nivel');
    let descrip_clase = "";
    let clase = document.getElementById('clase');
    let idiomas = "";
    let arma_armadura = "";
    let bloque_idiomas = document.getElementById("idiomas");
    let dado_de_golpe = "";

    function listar_raza(valor) {
        fetch('Gestion_raza?raza='+valor)
            .then(res => res.json())
            .then(data => mostrarRaza(data));
    }

    function mostrarRaza(datos) {
        descrip_raza = "";
        if(datos.mejora_leve !== "" && datos.mejora_leve !== undefined){
            descrip_raza = datos.mejora_leve+". ";
        }
        if(datos.mejora_moderada !== "" && datos.mejora_moderada !== undefined){
            descrip_raza += datos.mejora_moderada+". ";
        }
        descrip_raza += "Tamaño: "+datos.size+". ";

        descripcion.value = descrip_clase
        if(descrip_clase!==""){
            descripcion.value += " "
        }
        descripcion.value += descrip_raza;

        idiomas = "Idiomas: "+datos.idiomas+".";
        bloque_idiomas.value = arma_armadura;
        if(arma_armadura!==""){
            bloque_idiomas.value += " ";
        }
        bloque_idiomas.value += idiomas;

        document.getElementById("velocidad").value = datos.velocidad;

        document.getElementById("rasgos").value = datos.atributo_racial;

    }

    function listar_clase(valor) {
        fetch('Gestion_clase?clase=' + valor)
            .then(res => res.json())
            .then(data => mostrarClase(data));
    }


    function mostrarClase(datos) {
        descrip_clase = datos.descripcion;

        descripcion.value = descrip_clase
        if(descrip_clase!==""){
            descripcion.value += " "
        }
        descripcion.value += descrip_raza;
        dado_de_golpe = datos.dado_de_golpe;

        document.getElementById("dados_de_golpe").value = level.value + dado_de_golpe;

        arma_armadura = datos.comp_armas_armadura;
        bloque_idiomas.value = arma_armadura;
        if(arma_armadura!==""){
            bloque_idiomas.value += " ";
        }
        bloque_idiomas.value += idiomas;

    }

    level.addEventListener('change', ()=>{
        document.getElementById("dados_de_golpe").value = level.value+dado_de_golpe;
    })

