const fuerza = document.getElementById('FUE');
const modFuerza = document.getElementById('mod_fuerza');

function calcularFuerza() {
    if (fuerza.value == 3){
        modFuerza.value = -4;
    } else if (fuerza.value == 4 || fuerza.value == 5){
        modFuerza.value = -3;
    } else if (fuerza.value == 6 || fuerza.value == 7){
        modFuerza.value = -2;
    } else if (fuerza.value == 8 || fuerza.value == 9){
        modFuerza.value = -1;
    } else if (fuerza.value == 10 || fuerza.value == 11){
        modFuerza.value = 0;
    } else if (fuerza.value == 12 || fuerza.value == 13){
        modFuerza.value = 1;
    } else if (fuerza.value == 14 || fuerza.value == 15){
        modFuerza.value = 2;
    } else if (fuerza.value == 16 || fuerza.value == 17){
        modFuerza.value = 3;
    } else if (fuerza.value == 18 || fuerza.value == 19){
        modFuerza.value = 4;
    }      
};
  
fuerza.addEventListener('change', calcularFuerza);

const salvaFuerza = document.getElementById('salva.fue');
const atletismo = document.getElementById('Atletismo');

function modificadores(){
    salvaFuerza.value = parseInt(modFuerza.value);
    atletismo.value = parseInt(modFuerza.value);
};

fuerza.addEventListener('change', modificadores);

const checkbox_fue = document.getElementById('checkbox_fue');
const checkbox_hab3 = document.getElementById('checkbox_hab3')
let isChecked = false;
    
checkbox_fue.addEventListener('change', ()=>{
    isChecked = !isChecked;
    if (isChecked){
        salvaFuerza.value = (parseInt(modFuerza.value) + parseInt(bonoCompetencia.value));
    } else {
        salvaFuerza.value = parseInt(modFuerza.value);
    }
});

let isChecked1 = false;

checkbox_hab3.addEventListener('change', ()=>{
    isChecked1 = !isChecked1;
    if (isChecked1){
        atletismo.value = (parseInt(modFuerza.value) + parseInt(bonoCompetencia.value));
    } else {
        atletismo.value = parseInt(modFuerza.value);
    }
});
