void main() {
  print("Lotes con Mantenimiento Pendiente");
  
  final lotesPendientes = [12, 5, 45, 8, 12, 101, 8, 5, 90];
  
  print("Lista de Lotes Original: $lotesPendientes");
  
  print("Total de Tareas de Mantenimiento (incluye duplicados): ${lotesPendientes.length}");
  
  print("El primer lote en la cola es el: ${lotesPendientes.first}");
  
  print("El lote en la posición 3 (índice 3) es el: ${lotesPendientes[3]}");
  
  print("El último lote en la lista es el: ${lotesPendientes.last}"); 

  print("\nProcesamiento de Ofrendas");
  
  final ofrendasRecogidas = [
    "Vela", "Rosa", "Moneda", "Vela", "Tarjeta", "Rosa", "Tarjeta", "Lirio"
  ];
  print("Ofrendas recogidas (con duplicados): $ofrendasRecogidas");
  
  final ofrendasInvertidas = ofrendasRecogidas.reversed;
  
  print("Orden Inverso (las más antiguas al final): ${ofrendasInvertidas}"); 
  
  print("Lista Invertida (para ver la secuencia de recolección): ${ofrendasInvertidas.toList()}");
  
  final ofrendasUnicas = ofrendasRecogidas.toSet();
  print("Tipos de Ofrendas Únicas (Set): $ofrendasUnicas");
  
  print("Total de Tipos de Ofrendas Únicas: ${ofrendasUnicas.length}");
}