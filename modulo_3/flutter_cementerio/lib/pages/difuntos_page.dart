import 'package:flutter/material.dart';

class DifuntosPage extends StatelessWidget {
  const DifuntosPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Buscar Difunto', style: TextStyle(color: Color(0xFFFDD835))),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            TextField(
              decoration: InputDecoration(
                labelText: 'Nombre o Apellido',
                prefixIcon: const Icon(Icons.person_search, color: Color(0xFFFDD835)),
                border: const OutlineInputBorder(),
                filled: true,
                fillColor: Theme.of(context).colorScheme.surface,
              ),
              style: const TextStyle(color: Colors.white),
            ),
            const SizedBox(height: 20.0),
            Center(
              child: Text(
                'Use la barra de búsqueda para encontrar la ubicación de un ser querido.',
                textAlign: TextAlign.center,
                style: TextStyle(color: Colors.white70, fontSize: 16),
              ),
            ),
          ],
        ),
      ),
    );
  }
}