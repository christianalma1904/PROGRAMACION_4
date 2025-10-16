void main() {
  int numero = 7;
  int n = 10;
  int i = 0;
  print('Tabla de multiplicar del $numero:\n');

  while (i < n) {
    i++;
    print('$numero x $i = ${numero * i}');
  }

  i = 1;
  do{
    print('$numero x $i = ${numero * i}');
    i++;
  }while (i < n);
}