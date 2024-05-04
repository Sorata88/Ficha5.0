const sabiduria = document.getElementById('SAB');
const modSabiduria = document.getElementById('mod_sabiduria');

function calcularSabiduria(){
    if (sabiduria.value == 3){
        modSabiduria.value = -4;
    } else if (sabiduria.value == 4 || sabiduria.value == 5){
        modSabiduria.value = -3;
    } else if (sabiduria.value == 6 || sabiduria.value == 7){
        modSabiduria.value = -2;
    } else if (sabiduria.value == 8 || sabiduria.value == 9){
        modSabiduria.value = -1;
    } else if (sabiduria.value == 10 || sabiduria.value == 11){
        modSabiduria.value = 0;
    } else if (sabiduria.value == 12 || sabiduria.value == 13){
        modSabiduria.value = 1;
    } else if (sabiduria.value == 14 || sabiduria.value == 15){
        modSabiduria.value = 2;
    } else if (sabiduria.value == 16 || sabiduria.value == 17){
        modSabiduria.value = 3;
    } else if (sabiduria.value == 18 || sabiduria.value == 19){
        modSabiduria.value = 4;
    }  
};

sabiduria.addEventListener('change', calcularSabiduria);

const salvaSabiduria = document.getElementById('salva.sab');
const medicina = document.getElementById('Medicina');
const percepcion = document.getElementById('Percepción');
const perspicacia = document.getElementById('Perspicacia');
const supervivencia = document.getElementById('Supervivencia');
const tratoAnimales = document.getElementById('tratoanimales');
const sabPasiva = document.getElementById('sab.pasiva');

function modificadores(){
    salvaSabiduria.value = parseInt(modSabiduria.value);
    medicina.value = parseInt(modSabiduria.value);
    percepcion.value = parseInt(modSabiduria.value);
    perspicacia.value = parseInt(modSabiduria.value);
    supervivencia.value = parseInt(modSabiduria.value);
    tratoAnimales.value = parseInt(modSabiduria.value);
    sabPasiva.value = (10 + parseInt(modSabiduria.value));
};

sabiduria.addEventListener('change', modificadores);

const checkbox_sab = document.getElementById('checkbox_sab');
const checkbox_hab10 = document.getElementById('checkbox_hab10');
const checkbox_hab12 = document.getElementById('checkbox_hab12');
const checkbox_hab13 = document.getElementById('checkbox_hab13');
const checkbox_hab17 = document.getElementById('checkbox_hab17');
const checkbox_hab18 = document.getElementById('checkbox_hab18');

let isChecked13 = false;
    
checkbox_sab.addEventListener('change', ()=>{
    isChecked13 = !isChecked13;
    if (isChecked13){
        salvaSabiduria.value = (parseInt(modSabiduria.value) + parseInt(bonoCompetencia.value));
    } else {
        salvaSabiduria.value = parseInt(modSabiduria.value);
    }
});

let isChecked14 = false;
    
checkbox_hab10.addEventListener('change', ()=>{
    isChecked14 = !isChecked14;
    if (isChecked14){
        medicina.value = (parseInt(modSabiduria.value) + parseInt(bonoCompetencia.value));
    } else {
        medicina.value = parseInt(modSabiduria.value);
    }
});

let isChecked15 = false;
    
checkbox_hab12.addEventListener('change', ()=>{
    isChecked15 = !isChecked15;
    if (isChecked15){
        percepcion.value = (parseInt(modSabiduria.value) + parseInt(bonoCompetencia.value));
    } else {
        percepcion.value = parseInt(modSabiduria.value);
    }
});

let isChecked16 = false;
    
checkbox_hab13.addEventListener('change', ()=>{
    isChecked16 = !isChecked16;
    if (isChecked16){
        perspicacia.value = (parseInt(modSabiduria.value) + parseInt(bonoCompetencia.value));
    } else {
        perspicacia.value = parseInt(modSabiduria.value);
    }
});

let isChecked17 = false;
    
checkbox_hab17.addEventListener('change', ()=>{
    isChecked17 = !isChecked17;
    if (isChecked17){
        supervivencia.value = (parseInt(modSabiduria.value) + parseInt(bonoCompetencia.value));
    } else {
        supervivencia.value = parseInt(modSabiduria.value);
    }
});

let isChecked18 = false;
    
checkbox_hab18.addEventListener('change', ()=>{
    isChecked18 = !isChecked18;
    if (isChecked18){
        tratoAnimales.value = (parseInt(modSabiduria.value) + parseInt(bonoCompetencia.value));
    } else {
        tratoAnimales.value = parseInt(modSabiduria.value);
    }
});

