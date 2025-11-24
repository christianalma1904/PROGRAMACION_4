import 'package:flutter/material.dart';

class AjustesPage extends StatelessWidget {
  const AjustesPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Ajustes y Configuración', style: TextStyle(color: Color(0xFFFDD835))),
      ),
      body: ListView(
        children: <Widget>[
          ListTile(
            leading: const Icon(Icons.notifications_active, color: Colors.redAccent),
            title: const Text('Notificaciones de Mantenimiento'),
            trailing: Switch(value: true, onChanged: (bool value) {}),
          ),
          ListTile(
            leading: const Icon(Icons.info_outline, color: Color(0xFFFDD835)),
            title: const Text('Acerca de la App'),
            onTap: () {
              ScaffoldMessenger.of(context).showSnackBar(
                const SnackBar(content: Text('Desarrollado con Flutter para fines educativos.')),
              );
            },
          ),
          ListTile(
            leading: const Icon(Icons.lock, color: Colors.blueGrey),
            title: const Text('Política de Privacidad'),
            onTap: () {},
          ),
        ],
      ),
    );
  }
}