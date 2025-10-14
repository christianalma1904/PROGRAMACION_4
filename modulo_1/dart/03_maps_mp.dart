void main() {
  print("Registro de Tumba Avanzado");
  final Map<String, dynamic> registroTumba = {
    'nombreDifunto': 'Casper Milquetoast', // String
    'fechaDefuncion': '1968-10-31', // String
    'tieneEpitafio': true, // bool
    
    // 1. Lista de Ofrendas
    'ofrendasActuales': <String>['Rosa marchita', 'Tarjeta de aniversario', 'Moneda de cobre'],
    
    // 2. Map Anidado para Coordenadas
    'ubicacionGPS': {
      'seccion': 'A-4',
      'fila': 15,
      'lote': 7,
    }
  };

  print("Registro completo:");
  print(registroTumba);

  //Accedemos a los datos
  
  print("\nAcceso a Elementos Específicos");

  print("Difunto: ${registroTumba['nombreDifunto']}");
  print("¿Tiene epitafio?: ${registroTumba['tieneEpitafio']}");

  final List<String> ofrendas = registroTumba['ofrendasActuales'];
  print("Ofrenda más reciente: ${ofrendas[0]}");
  
  final Map<String, dynamic> ubicacion = registroTumba['ubicacionGPS'];
  print("Sección de la Tumba: ${ubicacion['seccion']}");
  
  print("Lote exacto (acceso directo): ${registroTumba['ubicacionGPS']['lote']}");

  print("\nResumen de Ubicación");
  print("""
    Tumba de ${registroTumba['nombreDifunto']}
    Se encuentra en: ${registroTumba['ubicacionGPS']['seccion']}
    Fila: ${registroTumba['ubicacionGPS']['fila']}
    Lote: ${registroTumba['ubicacionGPS']['lote']}
  """);
}