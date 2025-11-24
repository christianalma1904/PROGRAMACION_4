import 'package:flutter/material.dart';

class MapaPage extends StatelessWidget {
  const MapaPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mapa Interactivo', style: TextStyle(color: Color(0xFFFDD835))),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Icon(
              Icons.map_outlined,
              size: 100.0,
              color: Theme.of(context).colorScheme.secondary,
            ),
            const SizedBox(height: 20.0),
            const Text(
              'Aquí se cargaría el croquis del cementerio.',
              style: TextStyle(fontSize: 18.0, color: Colors.white70),
            ),
            const SizedBox(height: 10.0),
            const Text(
              'Versión Beta: Sin datos de ubicación en tiempo real.',
              style: TextStyle(fontSize: 14.0, color: Colors.grey),
            ),
          ],
        ),
      ),
    );
  }
}