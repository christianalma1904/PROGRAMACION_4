void main() {
  print("Maps Iterables");
  final numbers = [1,2,3,3,5,5,5,7,7,8,9,10];
  print("Lista Original: $numbers");
  print("Tamaño de la Lista: ${numbers.length}");
  print("Indice 4: ${numbers[4]}");
  print("Primer Elemento: ${numbers.first}");
  final reversedNumbers = numbers.reversed;
  print("Lista en Reversa: ${reversedNumbers}");
  print("List: ${reversedNumbers.toList()}");
  print("Set: ${reversedNumbers.toSet()}");
}
