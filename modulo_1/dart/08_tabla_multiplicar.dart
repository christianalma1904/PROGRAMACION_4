void main() {
  int numero = 7;
  int n = 10;

  print('Tabla de multiplicar del $numero:\n');

  for (int i = 1; i <= n; i++) {
    print('$numero x $i = ${numero * i}');
  }
}