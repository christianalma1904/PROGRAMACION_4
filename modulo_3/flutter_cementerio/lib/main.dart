import 'package:flutter/material.dart';
import 'app_router.dart';

void main() {
  runApp(const FlutterCementerioApp());
}

class FlutterCementerioApp extends StatelessWidget {
  const FlutterCementerioApp({super.key});

  @override
  Widget build(BuildContext context) {
    // Tema oscuro para reflejar la solemnidad del cementerio
    final ThemeData darkTheme = ThemeData.dark().copyWith(
      primaryColor: const Color(0xFF37474F), // Gris pizarra oscuro
      scaffoldBackgroundColor: const Color(0xFF263238), // Gris muy oscuro
      appBarTheme: const AppBarTheme(
        color: Color(0xFF263238),
        elevation: 0,
      ),
      colorScheme: ColorScheme.fromSeed(
        seedColor: const Color(0xFFFDD835), // Dorado/Amarillo para acentos
        brightness: Brightness.dark,
      ).copyWith(
        surface: const Color(0xFF37474F),
        onPrimary: Colors.white,
      ),
    );

    return MaterialApp(
      title: 'Cementerio App',
      theme: darkTheme,
      initialRoute: AppRouter.home,
      onGenerateRoute: AppRouter.generateRoute,
      debugShowCheckedModeBanner: false,
    );
  }
}