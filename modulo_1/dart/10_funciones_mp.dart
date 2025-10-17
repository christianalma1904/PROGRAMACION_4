void main() {
  final int anioActual = 2025;
  final int antiguedadLimite = 100; 
  
  List<String> nombresDifuntos = [
    "Jane Doe",
    "John Smith",
    "El Desconocido",
    "Anna B."
  ];
  List<int> aniosFallecimiento = [
    1930, 
    1850, 
    1980, 
    1910  
  ];
  
  print("VERIFICACIÓN DE LÁPIDAS CENTENARIAS (>$antiguedadLimite años)");

  for (int i = 0; i < nombresDifuntos.length; i++) {
    
    String nombre = nombresDifuntos[i];
    int anio = aniosFallecimiento[i];
    
    int antiguedad = anioActual - anio;
    
    if (antiguedad > antiguedadLimite) {
      print("$nombre | Año: $anio | Antigüedad: $antiguedad años | ¡CENTENARIA!");
    } else {
      print("$nombre | Año: $anio | Antigüedad: $antiguedad años | Reciente.");
    }
  }
}