import 'package:flutter/material.dart';

void main() {
  runApp(const MiTallerApp());
}

class MiTallerApp extends StatelessWidget {
  const MiTallerApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Cotizador de Taller',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: const Color.fromARGB(255, 0, 94, 255)),
        useMaterial3: true,
      ),
      home: const PantallaCotizacion(),
    );
  }
}

class PantallaCotizacion extends StatefulWidget {
  const PantallaCotizacion({super.key});

  @override
  State<PantallaCotizacion> createState() => _PantallaCotizacionState();
}

class _PantallaCotizacionState extends State<PantallaCotizacion> {
  String _tipoVehiculo = 'Auto';
  String _tipoServicio = 'Solo alineación';
  int _cantidadLlantas = 4;

  final Map<String, double> _tarifasBase = {
    'Auto': 10.0,
    'Camioneta': 15.0,
    'Camión': 25.0,
  };

  final Map<String, double> _costoPorLlanta = {
    'Solo alineación': 8.0,
    'Solo balanceo': 5.0,
    'Ambos': 12.0,
  };

  double _calcularTotal() {
    double base = _tarifasBase[_tipoVehiculo]!;
    double costoLlanta = _costoPorLlanta[_tipoServicio]!;
    return base + (costoLlanta * _cantidadLlantas);
  }

  Map<String, dynamic> _obtenerClasificacion(double total) {
    if (total < 50) {
      return {'texto': 'Trabajo Pequeño', 'color': Colors.green};
    } else if (total >= 50 && total <= 100) {
      return {'texto': 'Trabajo Medio', 'color': Colors.orange};
    } else {
      return {'texto': 'Trabajo Grande', 'color': Colors.redAccent};
    }
  }

  @override
  Widget build(BuildContext context) {
    double total = _calcularTotal();
    var clasificacion = _obtenerClasificacion(total);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Cotizador de Servicios'),
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            const Text('Tipo de Vehículo', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
            const SizedBox(height: 10),
            SegmentedButton<String>(
              segments: const [
                ButtonSegment(value: 'Auto', label: Text('Auto'), icon: Icon(Icons.directions_car)),
                ButtonSegment(value: 'Camioneta', label: Text('Camioneta'), icon: Icon(Icons.airport_shuttle)),
                ButtonSegment(value: 'Camión', label: Text('Camión'), icon: Icon(Icons.local_shipping)),
              ],
              selected: {_tipoVehiculo},
              onSelectionChanged: (Set<String> newSelection) {
                setState(() {
                  _tipoVehiculo = newSelection.first;
                });
              },
            ),

            const SizedBox(height: 25),

            const Text('Tipo de Servicio', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
            DropdownButtonFormField<String>(
              value: _tipoServicio,
              decoration: InputDecoration(
                border: OutlineInputBorder(borderRadius: BorderRadius.circular(10)),
                filled: true,
                fillColor: Colors.grey.shade100,
              ),
              items: _costoPorLlanta.keys.map((String servicio) {
                return DropdownMenuItem(
                  value: servicio,
                  child: Text(servicio),
                );
              }).toList(),
              onChanged: (String? newValue) {
                setState(() {
                  _tipoServicio = newValue!;
                });
              },
            ),

            const SizedBox(height: 25),

            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                const Text('Cantidad de Llantas:', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
                Text('$_cantidadLlantas', style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Color.fromARGB(255, 0, 58, 203))),
              ],
            ),
            Slider(
              value: _cantidadLlantas.toDouble(),
              min: 2,
              max: 6,
              divisions: 4,
              label: _cantidadLlantas.toString(),
              onChanged: (double value) {
                setState(() {
                  _cantidadLlantas = value.toInt();
                });
              },
            ),

            const Spacer(),

            Card(
              elevation: 5,
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
              color: Colors.white,
              child: Padding(
                padding: const EdgeInsets.all(20.0),
                child: Column(
                  children: [
                    const Text('Total Estimado', style: TextStyle(fontSize: 18, color: Colors.grey)),
                    Text(
                      '\$${total.toStringAsFixed(2)}',
                      style: const TextStyle(fontSize: 40, fontWeight: FontWeight.bold, color: Colors.black87),
                    ),
                    const Divider(),
                    Container(
                      padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                      decoration: BoxDecoration(
                        color: clasificacion['color'].withOpacity(0.2),
                        borderRadius: BorderRadius.circular(20),
                        border: Border.all(color: clasificacion['color']),
                      ),
                      child: Text(
                        clasificacion['texto'],
                        style: TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.bold,
                          color: clasificacion['color'],
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ),
            const SizedBox(height: 20),
          ],
        ),
      ),
    );
  }
}
