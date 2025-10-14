void main() {
  //Variables Fijas y Costantes
  print("Tumba Principal");

  final String nombreDifunto = "Eliza Graves";
  print("Nombre del difunto: $nombreDifunto");

  const int anioFundacionCementerio = 1888;
  print("Año de fundación del cementerio: $anioFundacionCementerio");

  final String fechaNacimiento = "01/01/1950";
  final String fechaMuerte = "15/10/2020";
  print("Nació: $fechaNacimiento");
  print("Murió: $fechaMuerte");
  
  final int edadAlMorir = 2020 - 1950;
  print("Edad al morir: $edadAlMorir años");

  //Variables Mutables y Booleanas
  print("Estado de la Tumba");
  
  String ubicacion = "Sección A, Fila 5, Lote 12";
  print("Ubicación inicial: $ubicacion");
  
  ubicacion = "Sección C, Fila 10, Lote 1"; 
  print("Nueva ubicación: $ubicacion");

  bool necesitaMantenimiento = true;
  print("¿Necesita mantenimiento?: $necesitaMantenimiento");
  
  necesitaMantenimiento = false;
  print("¿Necesita mantenimiento (después de la limpieza)?: $necesitaMantenimiento");

  //Listas
  print("Detalles Adicionales");

  List<String> epitafio = [
    "Aquí yace un alma en paz.",
    "Su recuerdo perdura.",
    "Amado esposo y padre."
  ];
  print("Epitafio completo: $epitafio");
  
  final ofrendas = <String>[
    "Flores (Lirios)", 
    "Vela consumida", 
    "Pequeña moneda antigua"
  ];
  print("Ofrendas encontradas: $ofrendas");
  
  ofrendas.add("Tarjeta escrita a mano");
  print("Ofrendas actualizadas: $ofrendas");
  
  print("\nImpresión del Epitafio");
  print("""
    El epitafio dice:
    ${epitafio[0]}
    ${epitafio[1]}
    ${epitafio[2]}
  """);
}