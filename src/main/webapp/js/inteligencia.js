const inteligencia = document.getElementById('INT');
const modInteligencia = document.getElementById('mod_inteligencia');

function calcularInteligencia(){
    if (inteligencia.value == 3){
        modInteligencia.value = -4;
    } else if (inteligencia.value == 4 || inteligencia.value == 5){
        modInteligencia.value = -3;
    } else if (inteligencia.value == 6 || inteligencia.value == 7){
        modInteligencia.value = -2;
    } else if (inteligencia.value == 8 || inteligencia.value == 9){
        modInteligencia.value = -1;
    } else if (inteligencia.value == 10 || inteligencia.value == 11){
        modInteligencia.value = 0;
    } else if (inteligencia.value == 12 || inteligencia.value == 13){
        modInteligencia.value = 1;
    } else if (inteligencia.value == 14 || inteligencia.value == 15){
        modInteligencia.value = 2;
    } else if (inteligencia.value == 16 || inteligencia.value == 17){
        modInteligencia.value = 3;
    } else if (inteligencia.value == 18 || inteligencia.value == 19){
        modInteligencia.value = 4;
    }  
};

inteligencia.addEventListener('change', calcularInteligencia);

const salvaInteligencia = document.getElementById('salva.int');
const arcanos = document.getElementById('Arcanos');
const historia = document.getElementById('Historia');
const investigacion = document.getElementById('Investigación');
const naturaleza = document.getElementById('Naturaleza');
const religion = document.getElementById('Religión');

function modificadores(){
    salvaInteligencia.value = parseInt(modInteligencia.value);
    arcanos.value = parseInt(modInteligencia.value);
    historia.value = parseInt(modInteligencia.value);
    investigacion.value = parseInt(modInteligencia.value);
    naturaleza.value = parseInt(modInteligencia.value);
    religion.value = parseInt(modInteligencia.value);
}

inteligencia.addEventListener('change', modificadores);

const checkbox_int = document.getElementById('checkbox_int');
const checkbox_hab2 = document.getElementById('checkbox_hab2');
const checkbox_hab5 = document.getElementById('checkbox_hab5');
const checkbox_hab8 = document.getElementById('checkbox_hab8');
const checkbox_hab11 = document.getElementById('checkbox_hab11'); 
const checkbox_hab15 = document.getElementById('checkbox_hab15');

let isChecked7 = false;
    
checkbox_int.addEventListener('change', ()=>{
    isChecked7 = !isChecked7;
    if (isChecked7){
        salvaInteligencia.value = (parseInt(modInteligencia.value) + parseInt(bonoCompetencia.value));
    } else {
        salvaInteligencia.value = parseInt(modInteligencia.value);
    }
});

let isChecked8 = false;
    
checkbox_hab2.addEventListener('change', ()=>{
    isChecked8 = !isChecked8;
    if (isChecked8){
        arcanos.value = (parseInt(modInteligencia.value) + parseInt(bonoCompetencia.value));
    } else {
        arcanos.value = parseInt(modInteligencia.value);
    }
});

let isChecked9 = false;
    
checkbox_hab5.addEventListener('change', ()=>{
    isChecked9 = !isChecked9;
    if (isChecked9){
        historia.value = (parseInt(modInteligencia.value) + parseInt(bonoCompetencia.value));
    } else {
        historia.value = parseInt(modInteligencia.value);
    }
});

let isChecked10 = false;
    
checkbox_hab8.addEventListener('change', ()=>{
    isChecked10 = !isChecked10;
    if (isChecked10){
        investigacion.value = (parseInt(modInteligencia.value) + parseInt(bonoCompetencia.value));
    } else {
        investigacion.value = parseInt(modInteligencia.value);
    }
});

let isChecked11 = false;
    
checkbox_hab11.addEventListener('change', ()=>{
    isChecked11 = !isChecked11;
    if (isChecked11){
        naturaleza.value = (parseInt(modInteligencia.value) + parseInt(bonoCompetencia.value));
    } else {
        naturaleza.value = parseInt(modInteligencia.value);
    }
});

let isChecked12 = false;
    
checkbox_hab15.addEventListener('change', ()=>{
    isChecked12 = !isChecked12;
    if (isChecked12){
        religion.value = (parseInt(modInteligencia.value) + parseInt(bonoCompetencia.value));
    } else {
        religion.value = parseInt(modInteligencia.value);
    }
});