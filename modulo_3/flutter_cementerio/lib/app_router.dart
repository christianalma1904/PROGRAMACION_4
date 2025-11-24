import 'package:flutter/material.dart';
import 'pages/home_page.dart';
import 'pages/lotes_page.dart';
import 'pages/difuntos_page.dart';
import 'pages/mapa_page.dart';
import 'pages/ajustes_page.dart';

class AppRouter {
  static const String home = '/';
  static const String lotes = '/lotes';
  static const String difuntos = '/difuntos';
  static const String mapa = '/mapa';
  static const String ajustes = '/ajustes';

  static Route<dynamic> generateRoute(RouteSettings settings) {
    switch (settings.name) {
      case home:
        return MaterialPageRoute(builder: (_) => HomePage());
      case lotes:
        return MaterialPageRoute(builder: (_) => LotesPage());
      case difuntos:
        return MaterialPageRoute(builder: (_) => DifuntosPage());
      case mapa:
        return MaterialPageRoute(builder: (_) => MapaPage());
      case ajustes:
        return MaterialPageRoute(builder: (_) => AjustesPage());
      default:
        return MaterialPageRoute(
          builder: (_) => Scaffold(
            appBar: AppBar(title: const Text('Error')),
            body: Center(
              child: Text('Ruta no definida para ${settings.name}'),
            ),
          ),
        );
    }
  }
}