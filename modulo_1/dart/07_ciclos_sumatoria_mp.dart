void main() {
  List<int> aniosDefuncion = [1905, 1988, 1890, 2010, 1945, 1970, 1850, 2020];
  int lapidasAntiguas = 0;
  int anioLimite = 1950;

  print("Conteo de Lápidas Antiguas (<= $anioLimite)");

  for (int anio in aniosDefuncion) {
    if (anio <= anioLimite) {
      lapidasAntiguas++;
      print("Antigua encontrada: $anio");
    }
  }

  print("\nTotal de lápidas antiguas: $lapidasAntiguas");
}