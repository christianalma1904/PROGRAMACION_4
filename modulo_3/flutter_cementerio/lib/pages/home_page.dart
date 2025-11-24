import 'package:flutter/material.dart';
import '../app_router.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    final List<Map<String, dynamic>> menuItems = [
      {'title': 'Ver Lotes', 'icon': Icons.map, 'route': AppRouter.lotes},
      {'title': 'Buscar Difunto', 'icon': Icons.search, 'route': AppRouter.difuntos},
      {'title': 'Mapa General', 'icon': Icons.location_on, 'route': AppRouter.mapa},
      {'title': 'Ajustes', 'icon': Icons.settings, 'route': AppRouter.ajustes},
    ];

    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Cementerio Digital',
          style: TextStyle(fontWeight: FontWeight.bold, color: Color(0xFFFDD835)),
        ),
        centerTitle: true,
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: GridView.builder(
            shrinkWrap: true,
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 2,
              crossAxisSpacing: 16.0,
              mainAxisSpacing: 16.0,
              childAspectRatio: 1.0,
            ),
            itemCount: menuItems.length,
            itemBuilder: (context, index) {
              final item = menuItems[index];
              return Card(
                color: Theme.of(context).colorScheme.surface,
                elevation: 4,
                child: InkWell(
                  onTap: () {
                    Navigator.pushNamed(context, item['route']);
                  },
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      Icon(
                        item['icon'],
                        size: 50.0,
                        color: const Color(0xFFFDD835),
                      ),
                      const SizedBox(height: 10.0),
                      Text(
                        item['title'],
                        style: const TextStyle(fontSize: 16.0, color: Colors.white70),
                        textAlign: TextAlign.center,
                      ),
                    ],
                  ),
                ),
              );
            },
          ),
        ),
      ),
    );
  }
}