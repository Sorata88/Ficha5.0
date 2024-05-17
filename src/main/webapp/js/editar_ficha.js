document.addEventListener('DOMContentLoaded', () => {
    var urlParams = new URLSearchParams(window.location.search);
    const idficha = urlParams.get('idficha');
    const op = urlParams.get('op');
    if(op==2){
        ficha_editar(idficha, op);
    }
})

    function ficha_editar(idficha, op){
        fetch('Gestion_ficha?idficha='+idficha+'&op='+op)
            .then(res => res.json())
            .then(data => mostrarForm(data));
    }

    function mostrarForm(datos){
        document.getElementById('idficha').value = datos.idficha;
        document.getElementById("nombrejugador").value = datos.nombre;
        document.getElementById("nombrepersonaje").value = datos.nombrepj;
        document.getElementById("raza").value = datos.raza;
        document.getElementById("clase").value = datos.clase;
        document.getElementById("nivel").value = datos.nivel;
        document.getElementById("trasfondo").value = datos.trasfondo;
        document.getElementById("alineamiento").value = datos.alineamiento;
        document.getElementById("px").value = datos.px;
        document.getElementById("bono_competencia").value = datos.bono_competencia;

        var array_caract = datos.Caract;
        var iter = new Iterator(array_caract);
        for (var item = iter.first(); iter.hasNext(); item = iter.next()) {
            switch (item.idCaract) {
                case 1:
                    document.getElementById("FUE").value = item.puntuacion;
                    document.getElementById("mod_fuerza").value = item.modificador;
                    break;
                case 2:
                    document.getElementById("DES").value = item.puntuacion;
                    document.getElementById("mod_destreza").value = item.modificador;
                    break;
                case 3:
                    document.getElementById("CON").value = item.puntuacion;
                    document.getElementById("mod_constitucion").value = item.modificador;
                    break;
                case 4:
                    document.getElementById("INT").value = item.puntuacion;
                    document.getElementById("mod_inteligencia").value = item.modificador;
                    break;
                case 5:
                    document.getElementById("SAB").value = item.puntuacion;
                    document.getElementById("mod_sabiduria").value = item.modificador;
                    break;
                case 6:
                    document.getElementById("CAR").value = item.puntuacion;
                    document.getElementById("mod_carisma").value = item.modificador;
                    break;
            }
        }
    }

    function Iterator (items){
        this.index = 0;
        this.items = items;
    }

    Iterator.prototype = {
        first: function (){
            this.reset();
            return this.next();
        },
        next: function (){
            return this.items[this.index++];
        },
        hasNext: function (){
            return this.index <= this.items.length;
        },
        reset: function (){
            this.index = 0;
        }
    }




