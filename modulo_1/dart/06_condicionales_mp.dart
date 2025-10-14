void main() {
  print("EVALUACIÓN DE MANTENIMIENTO DE LOTE");

  // La antigüedad de la tumba en años
  final int antiguedadAnos = 85; 
  final String nombreTumba = "Lote 33 - Familia Blackwell";

  print("Tumba a evaluar: $nombreTumba");
  print("Antigüedad actual: $antiguedadAnos años");
  
  if (antiguedadAnos > 100) {
    // Si la tumba tiene más de 100 años
    print("\nRESULTADO: ¡ALERTA! Requiere RESTAURACIÓN HISTÓRICA COMPLETA.");
    print("Acción: Asignar al equipo de patrimonio.");
  } else if (antiguedadAnos >= 50 && antiguedadAnos <= 100) {
    // Si la tumba está entre 50 y 100 años
    print("\nRESULTADO: Necesita MANTENIMIENTO PROFUNDO.");
    print("Acción: Programar limpieza química y reparación de fisuras.");
  } else if (antiguedadAnos >= 10 && antiguedadAnos < 50) {
    // Si la tumba está entre 10 y 49 años
    print("\nRESULTADO: Mantenimiento estándar necesario.");
    print("Acción: Programar limpieza básica y revisión de placa.");
  } else {
    // Si no cumple ninguna de las condiciones anteriores (menos de 10 años)
    print("\nRESULTADO: Condición ÓPTIMA.");
    print("Acción: Solo chequeo visual rápido. No se requiere intervención.");
  }

  print("\nFin de la Evaluación");
}