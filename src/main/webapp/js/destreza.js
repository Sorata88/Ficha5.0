const destreza = document.getElementById('DES');
const modDestreza = document.getElementById('mod_destreza');

function calcularDestreza(){
    if (destreza.value == 3){
        modDestreza.value = -4;
    } else if (destreza.value == 4 || destreza.value == 5){
        modDestreza.value = -3;
    } else if (destreza.value == 6 || destreza.value == 7){
        modDestreza.value = -2;
    } else if (destreza.value == 8 || destreza.value == 9){
        modDestreza.value = -1;
    } else if (destreza.value == 10 || destreza.value == 11){
        modDestreza.value = 0;
    } else if (destreza.value == 12 || destreza.value == 13){
        modDestreza.value = 1;
    } else if (destreza.value == 14 || destreza.value == 15){
        modDestreza.value = 2;
    } else if (destreza.value == 16 || destreza.value == 17){
        modDestreza.value = 3;
    } else if (destreza.value == 18 || destreza.value == 19){
        modDestreza.value = 4;
    }  
};

destreza.addEventListener('change', calcularDestreza);

const salvaDestreza = document.getElementById('salva.des');
const acrobacias = document.getElementById('Acrobacias');
const juegoManos = document.getElementById('Juego de manos');
const sigilo = document.getElementById('Sigilo');

function modificadores(){
    salvaDestreza.value = parseInt(modDestreza.value);
    acrobacias.value = parseInt(modDestreza.value);
    juegoManos.value = parseInt(modDestreza.value);
    sigilo.value = parseInt(modDestreza.value);
};

destreza.addEventListener('change', modificadores);

const checkbox_des = document.getElementById('checkbox_des');
const checkbox_hab1 = document.getElementById('checkbox_hab1');
const checkbox_hab9 = document.getElementById('checkbox_hab9');
const checkbox_hab16 = document.getElementById('checkbox_hab16');

let isChecked3 = false;
    
checkbox_des.addEventListener('change', ()=>{
    isChecked3 = !isChecked3;
    if (isChecked3){
        salvaDestreza.value = (parseInt(modDestreza.value) + parseInt(bonoCompetencia.value));
    } else {
        salvaDestreza.value = parseInt(modDestreza.value);
    }
});

let isChecked4 = false;

checkbox_hab1.addEventListener('change', ()=>{
    isChecked4 = !isChecked4;
    if (isChecked4){
        acrobacias.value = (parseInt(modDestreza.value) + parseInt(bonoCompetencia.value));
    } else {
        acrobacias.value = parseInt(modDestreza.value);
    }
});

let isChecked5 = false;

checkbox_hab9.addEventListener('change', ()=>{
    isChecked5 = !isChecked5;
    if (isChecked5){
        juegoManos.value = (parseInt(modDestreza.value) + parseInt(bonoCompetencia.value));
    } else {
        juegoManos.value = parseInt(modDestreza.value);
    }
});

let isChecked6 = false;

checkbox_hab16.addEventListener('change', ()=>{
    isChecked6 = !isChecked6;
    if (isChecked6){
        sigilo.value = (parseInt(modDestreza.value) + parseInt(bonoCompetencia.value));
    } else {
        sigilo.value = parseInt(modDestreza.value);
    }
});



