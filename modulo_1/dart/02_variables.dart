void main() {
  print("Tipos de Variables");
  
  final String pokemon = "Ditto";
  print(pokemon);
  
  String myName = "Christian";
  myName = "Alcocer";
  print(myName);
  
  const String elemento = "Fuego";
  print("Elemento: $elemento");
  
  bool active = false;
  print("Es activo: $active");
  
  int hp = 1000;
  print("Caballos de Fuerza: $hp");
  
  List<String> abilities = ["Impostor", "Correlon"];
  print("Habilidades $abilities");
  
  final sprites = <String>["src/imagen1.jpg", "imagen2"];
  print("Imagenes $sprites");
  
  print("Impresion en varias lineas");
  print("""
  $pokemon
  $hp
  $sprites
  $abilities
  """);
}
