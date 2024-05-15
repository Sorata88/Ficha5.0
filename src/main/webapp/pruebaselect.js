function cargarSubrazas() {
    // Objeto de razas con subrazas
    var listaSubrazas = {
      enano: ["Enano de las colinas", "Enano de las montañas"],
      elfo: ["Alto elfo", "Elfo de los bosques", "Elfo oscuro (drow)"],
      mediano: ["Piesligeros", "Fornido"],
      gnomo: ["Gnomo de los bosques", "Gnomo de las rocas"]
    }
    
    var razas = document.getElementById('raza')
    var subrazas = document.getElementById('subraza')
    var razaSeleccionada = razas.value
    
    // Se limpian las subrazas
    subrazas.innerHTML = '<option value="" selected disabled></option>'
    
    if(razaSeleccionada !== ''){
      // Se seleccionan las subrazas y se ordenan
      razaSeleccionada = listaSubrazas[razaSeleccionada]
    
      // Insertamos las subrazas
      razaSeleccionada.forEach(function(subraza){
        let opcion = document.createElement('option')
        opcion.value = subraza
        opcion.text = subraza
        subrazas.add(opcion)
      });
    }
    
  }

