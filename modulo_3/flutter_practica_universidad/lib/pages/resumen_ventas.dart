import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(home: DailyIncomePage()));
}

class DailyIncomePage extends StatefulWidget {
  const DailyIncomePage({super.key});

  @override
  State<DailyIncomePage> createState() => _DailyIncomePageState();
}

class _DailyIncomePageState extends State<DailyIncomePage> {
  int _cantidadServicios = 1;
  double _totalDia = 0.0;
  String _mensajeDia = "";

  final List<TextEditingController> _controladoresMonto = [];

  @override
  void initState() {
    super.initState();
    _actualizarLista();
  }

  void _actualizarLista() {
    while (_controladoresMonto.length < _cantidadServicios) {
      _controladoresMonto.add(TextEditingController());
    }
    while (_controladoresMonto.length > _cantidadServicios) {
      _controladoresMonto.last.dispose();
      _controladoresMonto.removeLast();
    }
    setState(() {});
  }

  void _calcularTotal() {
    double suma = 0.0;
    bool error = false;

    for (var controller in _controladoresMonto) {
      String texto = controller.text;
      if (texto.isEmpty) {
        error = true;
        break;
      }
      suma += double.tryParse(texto) ?? 0.0;
    }

    if (error) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Por favor ingrese todos los montos.')),
      );
      return;
    }

    String mensaje = "";
    if (suma < 200) {
      mensaje = "Día flojo";
    } else if (suma >= 200 && suma <= 500) {
      mensaje = "Día aceptable";
    } else {
      mensaje = "Día excelente";
    }

    setState(() {
      _totalDia = suma;
      _mensajeDia = mensaje;
    });
  }

  @override
  void dispose() {
    for (var c in _controladoresMonto) {
      c.dispose();
    }
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Resumen de Ventas Diarias')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            Row(
              children: [
                const Text("Servicios hoy: "),
                const SizedBox(width: 10),
                DropdownButton<int>(
                  value: _cantidadServicios,
                  items: List.generate(20, (index) => index + 1)
                      .map((e) => DropdownMenuItem(value: e, child: Text("$e")))
                      .toList(),
                  onChanged: (val) {
                    setState(() {
                      _cantidadServicios = val!;
                      _actualizarLista();
                      _totalDia = 0;
                      _mensajeDia = "";
                    });
                  },
                ),
              ],
            ),
            const SizedBox(height: 10),
            Expanded(
              child: ListView.builder(
                itemCount: _controladoresMonto.length,
                itemBuilder: (context, index) {
                  return Card(
                    child: ListTile(
                      leading: Text("#${index + 1}"),
                      title: Text("Servicio ${index + 1}"),
                      trailing: SizedBox(
                        width: 120,
                        child: TextField(
                          controller: _controladoresMonto[index],
                          keyboardType: TextInputType.number,
                          decoration: const InputDecoration(
                            labelText: "Monto",
                            border: OutlineInputBorder(),
                          ),
                        ),
                      ),
                    ),
                  );
                },
              ),
            ),
            const SizedBox(height: 20),
            SizedBox(
              width: double.infinity,
              child: ElevatedButton(
                onPressed: _calcularTotal,
                child: const Text("CALCULAR TOTAL"),
              ),
            ),
            const SizedBox(height: 20),
            Text(
              "Total: \$${_totalDia.toStringAsFixed(2)}",
              style: const TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            Text(
              _mensajeDia,
              style: const TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
