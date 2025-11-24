import 'package:flutter/material.dart';

class LotesPage extends StatelessWidget {
  const LotesPage({super.key});

  @override
  Widget build(BuildContext context) {
    const List<String> lotes = ['A-101', 'B-205', 'C-310', 'D-400', 'E-550'];

    return Scaffold(
      appBar: AppBar(
        title: const Text('Inventario de Lotes', style: TextStyle(color: Color(0xFFFDD835))),
      ),
      body: ListView.builder(
        itemCount: lotes.length,
        itemBuilder: (context, index) {
          return Card(
            color: Theme.of(context).colorScheme.surface.withOpacity(0.5),
            margin: const EdgeInsets.symmetric(horizontal: 10.0, vertical: 6.0),
            child: ListTile(
              leading: Icon(Icons.grass, color: const Color(0xFF4CAF50)), // Verde pasto
              title: Text('Lote Asignado: ${lotes[index]}', style: const TextStyle(color: Colors.white)),
              subtitle: const Text('Estado: Ocupado', style: TextStyle(color: Colors.white70)),
              trailing: const Icon(Icons.arrow_forward_ios, size: 16.0, color: Colors.white54),
              onTap: () {
                // Acción al seleccionar un lote
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('Detalles del Lote ${lotes[index]}')),
                );
              },
            ),
          );
        },
      ),
    );
  }
}