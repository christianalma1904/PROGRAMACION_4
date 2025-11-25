import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MiDiagnosticoApp());
}

class MiDiagnosticoApp extends StatelessWidget {
  const MiDiagnosticoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Diagnóstico Automotriz',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.redAccent),
        useMaterial3: true,
      ),
      home: const PantallaDiagnostico(),
    );
  }
}

class PantallaDiagnostico extends StatefulWidget {
  const PantallaDiagnostico({super.key});

  @override
  State<PantallaDiagnostico> createState() => _PantallaDiagnosticoState();
}

class _PantallaDiagnosticoState extends State<PantallaDiagnostico> {
  final TextEditingController _kmController = TextEditingController();
  String? _sintomaSeleccionado;
  bool _mostrarResultado = false;
  
  String _problemaProbable = '';
  String _recomendacion = '';
  Color _colorEstado = Colors.grey;
  String _textoEstado = '';

  final Map<String, String> _diagnosticosBase = {
    'Vibración al frenar': 'Discos de freno deformados o pastillas desgastadas.',
    'Humo azul del escape': 'Consumo de aceite (anillos de pistón o guías de válvulas gastadas).',
    'Ralentí inestable': 'Falla en bujías, inyectores sucios o sensor MAF defectuoso.',
    'Ruido metálico al arrancar': 'Problemas con el motor de arranque o falta de lubricación inicial.',
  };

  final List<String> _listaSintomas = [
    'Vibración al frenar',
    'Humo azul del escape',
    'Ralentí inestable',
    'Ruido metálico al arrancar',
  ];

  void _procesarDiagnostico() {
    if (_sintomaSeleccionado == null || _kmController.text.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Por favor seleccione un síntoma e ingrese el kilometraje.')),
      );
      return;
    }

    int kms = int.tryParse(_kmController.text) ?? 0;

    String problema = _diagnosticosBase[_sintomaSeleccionado]!;

    String recomendacionTexto;
    Color color;
    String estado;

    if (kms <= 5000) {
      estado = 'Moderado';
      color = Colors.orangeAccent;
      recomendacionTexto = "El mantenimiento es reciente. Es probable que sea una falla prematura de pieza o defecto de fábrica. Revisar garantía.";
    } else if (kms > 5000 && kms <= 15000) {
      estado = 'Importante';
      color = Colors.deepOrange;
      recomendacionTexto = "El vehículo está en el límite de su servicio. Se recomienda realizar el mantenimiento preventivo junto con la reparación.";
    } else {
      estado = 'Crítico';
      color = Colors.red.shade900;
      recomendacionTexto = "URGENTE: El vehículo ha excedido el periodo de servicio. El daño podría agravarse por falta de lubricación/mantenimiento general.";
    }

    setState(() {
      _problemaProbable = problema;
      _recomendacion = recomendacionTexto;
      _colorEstado = color;
      _textoEstado = estado;
      _mostrarResultado = true;
    });

    FocusScope.of(context).unfocus();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Asistente de Diagnóstico'),
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            const Text("1. Seleccione el Síntoma:", style: TextStyle(fontWeight: FontWeight.bold)),
            const SizedBox(height: 8),
            DropdownButtonFormField<String>(
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                prefixIcon: Icon(Icons.car_repair),
              ),
              hint: const Text("¿Qué falla presenta?"),
              value: _sintomaSeleccionado,
              items: _listaSintomas.map((String sintoma) {
                return DropdownMenuItem(
                  value: sintoma,
                  child: Text(sintoma, style: const TextStyle(fontSize: 14)),
                );
              }).toList(),
              onChanged: (valor) {
                setState(() {
                  _sintomaSeleccionado = valor;
                  _mostrarResultado = false;
                });
              },
            ),

            const SizedBox(height: 20),

            const Text("2. Kms desde último mantenimiento:", style: TextStyle(fontWeight: FontWeight.bold)),
            const SizedBox(height: 8),
            TextField(
              controller: _kmController,
              keyboardType: TextInputType.number,
              inputFormatters: [FilteringTextInputFormatter.digitsOnly],
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                prefixIcon: Icon(Icons.speed),
                suffixText: "km",
                hintText: "Ej: 8500",
              ),
              onChanged: (val) {
                if (_mostrarResultado) setState(() => _mostrarResultado = false);
              },
            ),

            const SizedBox(height: 30),

            ElevatedButton.icon(
              onPressed: _procesarDiagnostico,
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.black87,
                foregroundColor: Colors.white,
                padding: const EdgeInsets.symmetric(vertical: 15),
              ),
              icon: const Icon(Icons.search),
              label: const Text("VER DIAGNÓSTICO", style: TextStyle(fontSize: 16)),
            ),

            const SizedBox(height: 30),

            if (_mostrarResultado) ...[
              const Divider(thickness: 2),
              const SizedBox(height: 10),
              Center(
                child: Chip(
                  label: Text(
                    _textoEstado.toUpperCase(),
                    style: const TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
                  ),
                  backgroundColor: _colorEstado,
                  padding: const EdgeInsets.all(8),
                ),
              ),
              const SizedBox(height: 15),
              
              Container(
                padding: const EdgeInsets.all(15),
                decoration: BoxDecoration(
                  color: Colors.blue.shade50,
                  borderRadius: BorderRadius.circular(10),
                  border: Border.all(color: Colors.blue.shade200),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(children: const [
                      Icon(Icons.build_circle, color: Color.fromARGB(203, 0, 255, 64)),
                      SizedBox(width: 8),
                      Text("Causa Probable", style: TextStyle(fontWeight: FontWeight.bold, color: Colors.blue))
                    ]),
                    const SizedBox(height: 5),
                    Text(_problemaProbable, style: const TextStyle(fontSize: 16)),
                  ],
                ),
              ),

              const SizedBox(height: 15),

              Container(
                padding: const EdgeInsets.all(15),
                decoration: BoxDecoration(
                  color: Colors.grey.shade100,
                  borderRadius: BorderRadius.circular(10),
                  border: Border.all(color: Colors.grey.shade300),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(children: [
                      Icon(Icons.info, color: _colorEstado),
                      const SizedBox(width: 8),
                      Text("Recomendación del Taller", style: TextStyle(fontWeight: FontWeight.bold, color: _colorEstado))
                    ]),
                    const SizedBox(height: 5),
                    Text(_recomendacion, style: const TextStyle(fontSize: 15, fontStyle: FontStyle.italic)),
                  ],
                ),
              ),
            ],
          ],
        ),
      ),
    );
  }
}
