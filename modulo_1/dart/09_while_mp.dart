void main() {
  final int totalRegistros = 10;
  final int anioActual = 2025;

  print("1. ANÁLISIS DE RESTAURACIÓN");
  
  for (int i = 1; i <= totalRegistros; i++) {
    int anioDefuncion = anioActual - (i * 6);
    int antiguedad = anioActual - anioDefuncion;

    if (antiguedad > 50) {
      print("Tumba $i (Antigüedad: $antiguedad años): REQUIERE RESTAURACIÓN.");
    } else {
      print("Tumba $i (Antigüedad: $antiguedad años): Estado aceptable.");
    }
  }

  print("\n2. VERIFICACIÓN DE DEUDA");
  
  int j = 1; 
  while (j <= totalRegistros) {
    int deuda = j * 10;

    if (deuda > 70) {
      print("Registro $j (Deuda: \$$deuda): NOTIFICACIÓN URGENTE.");
    } else {
      print("Registro $j (Deuda: \$$deuda): Deuda menor o igual a \$70.");
    }
    
    j++;
  }

  print("\n3. CHEQUEO DE ESPACIOS");

  int k = 1;
  do {
    int capacidad = k + 2;
    
    if (capacidad % 2 == 0) {
      print("Nicho $k (Capacidad $capacidad): Tipo Estándar.");
    } else {
      print("Nicho $k (Capacidad $capacidad): Tipo Especial.");
    }
    
    k++;
  } while (k <= totalRegistros);
}