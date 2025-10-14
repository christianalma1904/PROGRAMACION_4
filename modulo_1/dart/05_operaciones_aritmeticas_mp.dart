void main() {
  print("CÁLCULOS ARITMÉTICOS BÁSICOS DEL CEMENTERIO");
  
  // 1. Variables para Cálculos de Área y Costo
  // Medidas de la parcela en metros
  final double largoParcela = 3.75;
  final double anchoParcela = 2.5;
  // Costo por metro cuadrado del terreno
  final double costoPorMetroCuadrado = 920.50; 
  
  // 2. Variables para Cálculos de Tiempo (Usando int)
  final int anioActual = 2025;
  final int anioNacimiento = 1935;
  final int anioDefuncion = 2010;
  
  // 3. Variables para Tareas y Recursos (Usando int)
  final int totalTumbasAMantener = 85;
  final int trabajadoresDisponibles = 4;
  
  print("\n### 1. Cálculos de Terreno");
  
  // Multiplicación: Calcula el área total
  final double areaTotal = largoParcela * anchoParcela;
  print("Área Total (Multiplicación): $largoParcela m * $anchoParcela m = ${areaTotal} m²"); 
  
  // Multiplicación: Calcula el costo total de la parcela
  final double costoTotal = areaTotal * costoPorMetroCuadrado;
  print("Costo Total (Multiplicación): $areaTotal m² * \$${costoPorMetroCuadrado} = \$${costoTotal}");
  
  // División: Costo base por trabajador
  final double costoPorTrabajador = costoTotal / trabajadoresDisponibles;
  print("Costo Total / Trabajadores (División): \$${costoTotal} / $trabajadoresDisponibles = \$${costoPorTrabajador}");
  
  print("\n### 2. Cálculos de Edad y Tiempo");
  
  // Resta: Calcula la edad al momento del fallecimiento
  final int edadAlMorir = anioDefuncion - anioNacimiento;
  print("Edad al Morir (Resta): $anioDefuncion - $anioNacimiento = $edadAlMorir años");
  
  // Resta: Calcula los años desde el fallecimiento hasta hoy
  final int anosDesdeDefuncion = anioActual - anioDefuncion;
  print("Años desde Defunción (Resta): $anioActual - $anioDefuncion = $anosDesdeDefuncion años");
  
  print("\n### 3. Asignación de Tareas 🧹");

  // Suma: Tumbas que se añaden al total
  final int nuevasTumbas = 15;
  final int totalDespuesDeAumento = totalTumbasAMantener + nuevasTumbas;
  print("Total después de aumento (Suma): $totalTumbasAMantener + $nuevasTumbas = $totalDespuesDeAumento tumbas");
  
  // División: Tumbas promedio que le tocan a cada trabajador
  final double promedioTumbasPorTrabajador = totalDespuesDeAumento / trabajadoresDisponibles;
  print("Promedio Tumbas por Trabajador (División): $totalDespuesDeAumento / $trabajadoresDisponibles = $promedioTumbasPorTrabajador");
}