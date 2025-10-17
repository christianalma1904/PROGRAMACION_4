class CuentaParcela {
  String nombreCliente;
  double deuda;

  CuentaParcela(this.nombreCliente, this.deuda);
}

void main() {
  final double LIMITE_DEUDA = 50.0;
  final double MULTA = 20.0;
  
  List<CuentaParcela> cuentas = [
    CuentaParcela("J. Smith", 65.50),
    CuentaParcela("M. Curie", 30.00),
    CuentaParcela("V. Hugo", 50.00),
  ];
  
  print("REGISTRO DE PAGOS DE MANTENIMIENTO");

  for (var cuenta in cuentas) {
    
    double totalAPagar;
    String estado;

    if (cuenta.deuda > LIMITE_DEUDA) {
      totalAPagar = cuenta.deuda + MULTA;
      estado = "¡Con Multa!";
    } else {
      totalAPagar = cuenta.deuda;
      estado = "Sin Multa.";
    }
    
    print("\nCliente: ${cuenta.nombreCliente}");
    print("Deuda Base: \$${cuenta.deuda.toStringAsFixed(2)}");
    print("Estado: $estado");
    print("TOTAL FINAL: \$${totalAPagar.toStringAsFixed(2)}");
  }
}