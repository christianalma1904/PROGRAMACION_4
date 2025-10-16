void main(){
  final Hero Wolverine = Hero(name: 'Logan', power: 'Regeneracion');
  print(Wolverine);
  print(Wolverine.name);
  print(Wolverine.power);
}

class Hero{
  String name;
  String power;
  Hero({
    required this.name,
    this.power = "sin poder"
  });
  @override
  String toString()
  {
    return "$name - $power";
  }
}