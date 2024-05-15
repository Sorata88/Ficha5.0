const carisma = document.getElementById('CAR');
const modCarisma = document.getElementById('mod_carisma');


function calcularCarisma(){
    if (carisma.value == 3){
        modCarisma.value = -4;
    } else if (carisma.value == 4 || carisma.value == 5){
        modCarisma.value = -3;
    } else if (carisma.value == 6 || carisma.value == 7){
        modCarisma.value = -2;
    } else if (carisma.value == 8 || carisma.value == 9){
        modCarisma.value = -1;
    } else if (carisma.value == 10 || carisma.value == 11){
        modCarisma.value = 0;
    } else if (carisma.value == 12 || carisma.value == 13){
        modCarisma.value = 1;
    } else if (carisma.value == 14 || carisma.value == 15){
        modCarisma.value = 2;
    } else if (carisma.value == 16 || carisma.value == 17){
        modCarisma.value = 3;
    } else if (carisma.value == 18 || carisma.value == 19){
        modCarisma.value = 4;
    }  
};

carisma.addEventListener('change', calcularCarisma);

const salvaCarisma = document.getElementById('salva.car');
const engano = document.getElementById('Engaño');
const interpretacion = document.getElementById('Interpretación');
const intimidacion = document.getElementById('Intimidación');
const persuasion = document.getElementById('Persuasión');

function modificadores(){
    salvaCarisma.value = parseInt(modCarisma.value);
    engano.value = parseInt(modCarisma.value);
    interpretacion.value = parseInt(modCarisma.value);
    intimidacion.value = parseInt(modCarisma.value);
    persuasion.value = parseInt(modCarisma.value);
};

carisma.addEventListener('change', modificadores);

const checkbox_car = document.getElementById('checkbox_car');
const checkbox_hab4 = document.getElementById('checkbox_hab4');
const checkbox_hab6 = document.getElementById('checkbox_hab6');
const checkbox_hab7 = document.getElementById('checkbox_hab7');
const checkbox_hab14 = document.getElementById('checkbox_hab14');

let isChecked19 = false;
    
checkbox_car.addEventListener('change', ()=>{
    isChecked19 = !isChecked19;
    if (isChecked19){
        salvaCarisma.value = (parseInt(modCarisma.value) + parseInt(bonoCompetencia.value));
    } else {
        salvaCarisma.value = parseInt(modCarisma.value);
    }
});

let isChecked20 = false;
    
checkbox_hab4.addEventListener('change', ()=>{
    isChecked20 = !isChecked20;
    if (isChecked20){
        engano.value = (parseInt(modCarisma.value) + parseInt(bonoCompetencia.value));
    } else {
        engano.value = parseInt(modCarisma.value);
    }
});

let isChecked21 = false;
    
checkbox_hab6.addEventListener('change', ()=>{
    isChecked21 = !isChecked21;
    if (isChecked21){
        interpretacion.value = (parseInt(modCarisma.value) + parseInt(bonoCompetencia.value));
    } else {
        interpretacion.value = parseInt(modCarisma.value);
    }
});

let isChecked22 = false;
    
checkbox_hab7.addEventListener('change', ()=>{
    isChecked22 = !isChecked22;
    if (isChecked22){
        intimidacion.value = (parseInt(modCarisma.value) + parseInt(bonoCompetencia.value));
    } else {
        intimidacion.value = parseInt(modCarisma.value);
    }
});

let isChecked23 = false;
    
checkbox_hab14.addEventListener('change', ()=>{
    isChecked23 = !isChecked23;
    if (isChecked23){
        persuasion.value = (parseInt(modCarisma.value) + parseInt(bonoCompetencia.value));
    } else {
        persuasion.value = parseInt(modCarisma.value);
    }
});