const constitucion = document.getElementById('CON');
const modConstitucion = document.getElementById('mod_constitucion');

function calcularConstitucion(){
    if (constitucion.value == 3){
        modConstitucion.value = -4;
    } else if (constitucion.value == 4 || constitucion.value == 5){
        modConstitucion.value = -3;
    } else if (constitucion.value == 6 || constitucion.value == 7){
        modConstitucion.value = -2;
    } else if (constitucion.value == 8 || constitucion.value == 9){
        modConstitucion.value = -1;
    } else if (constitucion.value == 10 || constitucion.value == 11){
        modConstitucion.value = 0;
    } else if (constitucion.value == 12 || constitucion.value == 13){
        modConstitucion.value = 1;
    } else if (constitucion.value == 14 || constitucion.value == 15){
        modConstitucion.value = 2;
    } else if (constitucion.value == 16 || constitucion.value == 17){
        modConstitucion.value = 3;
    } else if (constitucion.value == 18 || constitucion.value == 19){
        modConstitucion.value = 4;
    }  
};

constitucion.addEventListener('change', calcularConstitucion);

const salvaConstitucion = document.getElementById('salva.con');

function modificadores(){
    salvaConstitucion.value = parseInt(modConstitucion.value);
};

constitucion.addEventListener('change', modificadores);

const checkbox_con = document.getElementById('checkbox_con');
let isChecked2 = false;

checkbox_con.addEventListener('change', ()=>{
    isChecked2 = !isChecked2;
    if (isChecked2){
        salvaConstitucion.value = (parseInt(modConstitucion.value) + parseInt(bonoCompetencia.value));
    } else {
        salvaConstitucion.value = parseInt(modConstitucion.value);
    }
});