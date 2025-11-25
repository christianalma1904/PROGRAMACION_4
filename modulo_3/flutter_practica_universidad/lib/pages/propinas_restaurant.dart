import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(home: TipsCalculatorPage()));
}

class TipsCalculatorPage extends StatefulWidget {
  const TipsCalculatorPage({super.key});

  @override
  State<TipsCalculatorPage> createState() => _TipsCalculatorPageState();
}

class _TipsCalculatorPageState extends State<TipsCalculatorPage> {
  int _cantidadMesas = 1;
  double _porcentajePropina = 0.10;
  double _propinaTotal = 0.0;
  double _consumoTotal = 0.0;

  final List<TextEditingController> _controladoresMesas = [];

  @override
  void initState() {
    super.initState();
    _actualizarControladores();
  }

  void _actualizarControladores() {
    while (_controladoresMesas.length < _cantidadMesas) {
      _controladoresMesas.add(TextEditingController());
    }
    while (_controladoresMesas.length > _cantidadMesas) {
      _controladoresMesas.last.dispose();
      _controladoresMesas.removeLast();
    }
    setState(() {});
  }

  void _calcular() {
    double sumaConsumo = 0;
    double sumaPropinas = 0;
    bool hayError = false;

    for (int i = 0; i < _cantidadMesas; i++) {
      String texto = _controladoresMesas[i].text;
      
      if (texto.isEmpty) {
        hayError = true;
        break;
      }

      double consumoMesa = double.tryParse(texto) ?? 0.0;
      double propinaMesa = consumoMesa * _porcentajePropina;

      sumaConsumo += consumoMesa;
      sumaPropinas += propinaMesa;
    }

    if (hayError) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('Por favor ingrese el consumo de todas las mesas.'),
        ),
      );
      return;
    }

    setState(() {
      _consumoTotal = sumaConsumo;
      _propinaTotal = sumaPropinas;
    });

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text('Total propinas: \$${sumaPropinas.toStringAsFixed(2)}'),
      ),
    );
  }

  @override
  void dispose() {
    for (var controller in _controladoresMesas) {
      controller.dispose();
    }
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Calculadora de Propinas'),
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(16),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text("Mesas:"),
                    DropdownButton<int>(
                      value: _cantidadMesas,
                      items: List.generate(10, (index) => index + 1)
                          .map((num) => DropdownMenuItem(value: num, child: Text("$num")))
                          .toList(),
                      onChanged: (valor) {
                        setState(() {
                          _cantidadMesas = valor!;
                          _actualizarControladores();
                          _propinaTotal = 0;
                          _consumoTotal = 0;
                        });
                      },
                    ),
                  ],
                ),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text("% Propina:"),
                    DropdownButton<double>(
                      value: _porcentajePropina,
                      items: const [
                        DropdownMenuItem(value: 0.10, child: Text("10%")),
                        DropdownMenuItem(value: 0.12, child: Text("12%")),
                        DropdownMenuItem(value: 0.15, child: Text("15%")),
                      ],
                      onChanged: (valor) {
                        setState(() => _porcentajePropina = valor!);
                      },
                    ),
                  ],
                ),
              ],
            ),
          ),
          Expanded(
            child: ListView.builder(
              padding: const EdgeInsets.all(16),
              itemCount: _controladoresMesas.length,
              itemBuilder: (context, index) {
                return Card(
                  margin: const EdgeInsets.only(bottom: 10),
                  child: ListTile(
                    leading: Text('${index + 1}'),
                    title: Text('Mesa ${index + 1}'),
                    subtitle: Text('Propina: \$${(_controladoresMesas[index].text.isNotEmpty ? (double.tryParse(_controladoresMesas[index].text) ?? 0) * _porcentajePropina : 0).toStringAsFixed(2)}'),
                    trailing: SizedBox(
                      width: 100,
                      child: TextField(
                        controller: _controladoresMesas[index],
                        keyboardType: const TextInputType.numberWithOptions(decimal: true),
                        decoration: const InputDecoration(
                          hintText: '0.00',
                          border: OutlineInputBorder(),
                          isDense: true,
                        ),
                        onChanged: (_) => setState(() {}),
                      ),
                    ),
                  ),
                );
              },
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(20),
            child: Column(
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    const Text("Consumo Total:"),
                    Text("\$${_consumoTotal.toStringAsFixed(2)}"),
                  ],
                ),
                const SizedBox(height: 5),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    const Text("TOTAL PROPINAS:"),
                    Text("\$${_propinaTotal.toStringAsFixed(2)}"),
                  ],
                ),
                const SizedBox(height: 15),
                SizedBox(
                  width: double.infinity,
                  child: ElevatedButton(
                    onPressed: _calcular,
                    child: const Text("CALCULAR TOTAL"),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
