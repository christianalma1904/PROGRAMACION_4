import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

// Esta página calcula el costo total de menús del día aplicando descuentos
// según el tipo de cliente.
class MenuCalculatorPage extends StatefulWidget {
  const MenuCalculatorPage({super.key});

  @override
  State<MenuCalculatorPage> createState() => _MenuCalculatorPageState();
}

class _MenuCalculatorPageState extends State<MenuCalculatorPage> {
  // Estado para los inputs y resultados
  String priceText = '';
  String quantityText = '';
  String clientType = 'Nuevo'; // Valor inicial del Dropdown
  String resultText = '';

  // Definición de los tipos de cliente y sus descuentos
  final Map<String, double> discountPercentages = {
    'Nuevo': 0.0,
    'Frecuente': 8.0,
    'Corporativo': 12.0,
  };

  void calculateTotal() {
    // 1. Parsear inputs y manejar errores de formato/vacío
    final basePrice = double.tryParse(priceText.replaceAll(',', '.')) ?? 0.0;
    final quantity = int.tryParse(quantityText) ?? 0;

    // 2. Validar valores
    if (basePrice <= 0 || quantity <= 0) {
      setState(() {
        resultText = 'Ingrese valores válidos para precio y cantidad (mayores a cero).';
      });
      return;
    }

    // 3. Obtener el porcentaje de descuento
    final discountPercentage = discountPercentages[clientType] ?? 0.0;

    // 4. Calcular Subtotal
    final subtotal = basePrice * quantity;

    // 5. Calcular Monto de Descuento
    final discountAmount = subtotal * (discountPercentage / 100);

    // 6. Calcular Total Final
    final total = subtotal - discountAmount;

    // 7. Actualizar el estado con los resultados formateados
    setState(() {
      resultText =
          '--- Detalle del Cálculo ---\n'
          'Subtotal: \$${subtotal.toStringAsFixed(2)}\n'
          'Tipo de Cliente: $clientType\n'
          'Porcentaje de Descuento: ${discountPercentage.toStringAsFixed(0)} %\n'
          'Monto de Descuento: -\$${discountAmount.toStringAsFixed(2)}\n'
          'Total Final a Pagar: \$${total.toStringAsFixed(2)}';
    });
  }

  @override
  Widget build(BuildContext context) {
    // Estilo para los campos de texto
    const inputDecoration = InputDecoration(
      border: OutlineInputBorder(
        borderRadius: BorderRadius.all(Radius.circular(10)),
      ),
      filled: true,
      fillColor: Color.fromARGB(5, 0, 0, 0),
    );

    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Menú del Día: Calculadora de Descuento',
          style: TextStyle(fontWeight: FontWeight.bold),
        ),
        // Ícono para volver (asumiendo que estás usando go_router como en el original)
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
        backgroundColor: const Color.fromARGB(188, 255, 0, 0),
        foregroundColor: Colors.white,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            // Título de la sección de Inputs
            const Text(
              'Información de la Compra',
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.w600,
                color: Color.fromARGB(255, 150, 0, 0),
              ),
            ),
            const Divider(height: 20, thickness: 2, color: Color.fromARGB(255, 255, 100, 100)),
            const SizedBox(height: 10),

            // 1. Input: Precio base del menú
            TextField(
              decoration: inputDecoration.copyWith(
                labelText: 'Precio base del menú (\$)',
                prefixIcon: const Icon(Icons.attach_money, color: Color.fromARGB(255, 150, 0, 0)),
              ),
              keyboardType: const TextInputType.numberWithOptions(decimal: true),
              onChanged: (value) {
                priceText = value;
              },
            ),

            const SizedBox(height: 15),

            // 2. Input: Cantidad de menús
            TextField(
              decoration: inputDecoration.copyWith(
                labelText: 'Cantidad de menús',
                prefixIcon: const Icon(Icons.numbers, color: Color.fromARGB(255, 150, 0, 0)),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                quantityText = value;
              },
            ),

            const SizedBox(height: 15),

            // 3. Dropdown: Tipo de Cliente
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 12.0),
              decoration: BoxDecoration(
                border: Border.all(color: Colors.grey.shade400),
                borderRadius: BorderRadius.circular(10),
                color: const Color.fromARGB(5, 0, 0, 0),
              ),
              child: DropdownButtonHideUnderline(
                child: DropdownButton<String>(
                  value: clientType,
                  isExpanded: true,
                  icon: const Icon(Icons.person, color: Color.fromARGB(255, 150, 0, 0)),
                  style: TextStyle(fontSize: 16, color: Colors.grey.shade800),
                  items: discountPercentages.keys.map((String value) {
                    return DropdownMenuItem<String>(
                      value: value,
                      child: Text(
                        '$value (${discountPercentages[value]?.toStringAsFixed(0)}% desc.)',
                      ),
                    );
                  }).toList(),
                  onChanged: (value) {
                    if (value == null) return;
                    setState(() {
                      clientType = value;
                    });
                  },
                ),
              ),
            ),

            const SizedBox(height: 30),

            // Botón de cálculo
            ElevatedButton.icon(
              onPressed: calculateTotal,
              icon: const Icon(Icons.calculate, size: 24),
              label: const Text(
                'Calcular Total',
                style: TextStyle(fontSize: 18),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color.fromARGB(255, 150, 0, 0),
                foregroundColor: Colors.white,
                padding: const EdgeInsets.symmetric(vertical: 15),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
                elevation: 5,
              ),
            ),

            const SizedBox(height: 30),

            // Sección de Resultados
            Container(
              padding: const EdgeInsets.all(20),
              decoration: BoxDecoration(
                color: Colors.teal.shade50,
                borderRadius: BorderRadius.circular(10),
                border: Border.all(color: const Color.fromARGB(255, 203, 128, 128)),
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  const Text(
                    'RESULTADO:',
                    style: TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.bold,
                      color: Color.fromARGB(255, 150, 0, 0),
                    ),
                  ),
                  const Divider(height: 10, thickness: 1, color: Color.fromARGB(255, 150, 0, 0)),
                  Text(
                    resultText.isEmpty ? 'Aún no se ha realizado un cálculo.' : resultText,
                    style: const TextStyle(
                      fontSize: 16,
                      height: 1.5, // Espaciado entre líneas para mejor lectura
                      color: Colors.black87,
                      fontWeight: FontWeight.w500
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}