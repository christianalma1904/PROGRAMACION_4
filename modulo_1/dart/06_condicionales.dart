void main() {
  print("Condicional If - Else");
  //If
  int a = 2;
  if (a > 2) {
    print("a > 2 is True");
  }
  if (a < 2) {
    print("a < 2 is True");
  }
  if (a == 2) {
    print("a == 2 is True");
  }
  
  //If - Else
  if (a > 2) {
    print("a > 2 is True");
  } else {
    print("a <= 2 is true");
  }
  if (a < 2) {
    print("a < 2 is True");
  } else {
    print("a >= 2 is true");
  }
  if (a == 2) {
    print("a == 2 is True");
  } else {
    print("a != 2 is true");
  }
  
  // If - Else If - Else
  
  int b = 2;
  if (b > 2) {
    print("a > 2 is True");
  } else if (b < 2) {
    print("a < 2 is true");
  } else {
    print("a == 2 is True");
  }
  
  int age = 18;
  String ageDescription = age >= 18 ? 'adult' : 'child';
  print(ageDescription);
}
