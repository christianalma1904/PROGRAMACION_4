void main(){
  greetEveryone();
  suma(2, 5);
  print(suma);
  print(addTwoNumbersOptional(8));
  print(addTwoNumbersOptional(6, 8));
  print(greetPerson(name: "Alcocer", message: "Hasta la vista"));
  print(greetPerson(name: "Juan"));

}

String greetEveryone() => 'Hello Everyone';
int suma(int a, int b) => a + b;

int addTwoNumbersOptional(int a, [int b = 0]){
  return a + b;
}

String greetPerson({required String name, String message = "Hola"}){
  return '$message $name';
}