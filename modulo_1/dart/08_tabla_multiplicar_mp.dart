void main() {
  final int anioActual = 2025;
  final int totalTumbasAInspeccionar = 20;

  print("INFORME DE INSPECCIÓN DE CEMENTERIO (20 Tumbas)");
  for (int i = 1; i <= totalTumbasAInspeccionar; i++) {
    int anioDefuncionSimulado = anioActual - (i * 3); 
    
    int antiguedad = anioActual - anioDefuncionSimulado;
    
    String estado;

    if (antiguedad > 50) {
      estado = "Ruinas (Muy Antigua)";
    } else if (antiguedad >= 21 && antiguedad <= 50) {
      estado = "Desatendida (Antigüedad Media)";
    } else {
      estado = "Cuidada (Reciente)";
    }
    
    print("Tumba #${i.toString().padLeft(2)} | Año Defunción: $anioDefuncionSimulado | Antigüedad: $antiguedad años | Estado: $estado");
  }
}