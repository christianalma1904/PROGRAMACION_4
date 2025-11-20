import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

const Map<String, double> platePrices = {
  'Pollo': 6.0,
  'Carne': 7.0,
  'Vegetariano': 5.0,
};

const Map<String, double> drinkPrices = {
  'Gaseosa': 2.0,
  'Jugo': 3.0,
  'Agua': 1.0,
};

const Map<String, double> sidePrices = {
  'Papas': 2.0,
  'Ensalada': 2.5,
  'Pan': 1.5,
};

class ComboCalculatorPage extends StatefulWidget {
  const ComboCalculatorPage({super.key});

  @override
  State<ComboCalculatorPage> createState() => _ComboCalculatorPageState();
}

class _ComboCalculatorPageState extends State<ComboCalculatorPage> {
  String selectedPlate = platePrices.keys.first;
  String selectedDrink = drinkPrices.keys.first;
  String selectedSide = sidePrices.keys.first;
  final TextEditingController plateQuantityController = TextEditingController(text: '1');
  final TextEditingController drinkQuantityController = TextEditingController(text: '1');
  final TextEditingController sideQuantityController = TextEditingController(text: '1');

  String resultText = '';

  void calculateTotal() {
    final platePrice = platePrices[selectedPlate] ?? 0.0;
    final drinkPrice = drinkPrices[selectedDrink] ?? 0.0;
    final sidePrice = sidePrices[selectedSide] ?? 0.0;

    final plateQuantity = int.tryParse(plateQuantityController.text) ?? 0;
    final drinkQuantity = int.tryParse(drinkQuantityController.text) ?? 0;
    final sideQuantity = int.tryParse(sideQuantityController.text) ?? 0;

    if (plateQuantity <= 0 || drinkQuantity <= 0 || sideQuantity <= 0) {
      setState(() {
        resultText = 'ERROR: TODAS LAS CANTIDADES DEBEN SER MAYORES A 0.';
      });
      return;
    }

    final plateSubtotal = platePrice * plateQuantity;
    final drinkSubtotal = drinkPrice * drinkQuantity;
    final sideSubtotal = sidePrice * sideQuantity;

    final total = plateSubtotal + drinkSubtotal + sideSubtotal;

    setState(() {
      resultText =
          'DETALLE DE LA ORDEN\n'
          'PLATO ($selectedPlate): $plateQuantity x \$${platePrice.toStringAsFixed(2)} = \$${plateSubtotal.toStringAsFixed(2)}\n'
          'BEBIDA ($selectedDrink): $drinkQuantity x \$${drinkPrice.toStringAsFixed(2)} = \$${drinkSubtotal.toStringAsFixed(2)}\n'
          'ACOMPAÑADOS ($selectedSide): $sideQuantity x \$${sidePrice.toStringAsFixed(2)} = \$${sideSubtotal.toStringAsFixed(2)}\n\n'
          '\n'
          'TOTAL GENERAL: \$${total.toStringAsFixed(2)}';
    });
  }

  @override
  void dispose() {
    plateQuantityController.dispose();
    drinkQuantityController.dispose();
    sideQuantityController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    Widget buildDropdown(
        String label,
        String value,
        Map<String, double> items,
        ValueChanged<String?> onChanged,
      ) {
      return Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(label, style: const TextStyle(fontSize: 14, color: Colors.grey)),
          DropdownButton<String>(
            value: value,
            isExpanded: true,
            items: items.entries.map((entry) {
              return DropdownMenuItem(
                value: entry.key,
                child: Text('${entry.key} (\$${entry.value.toStringAsFixed(2)})'),
              );
            }).toList(),
            onChanged: onChanged,
          ),
        ],
      );
    }

    Widget buildQuantityField(
      String label,
      TextEditingController controller,
    ) {
      return TextField(
        controller: controller,
        decoration: InputDecoration(
          labelText: label,
          border: const OutlineInputBorder(),
        ),
        keyboardType: TextInputType.number,
        onChanged: (value) {

          if (value.isNotEmpty) {
            final parsedValue = int.tryParse(value) ?? 0;
            if (parsedValue < 0) controller.text = '0';
          }
        },
      );
    }

    return Scaffold(
      appBar: AppBar(
        title: const Text('Calculadora de Combos'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              const Text(
                'Selección de Ítems del Combo',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 16),

              buildDropdown(
                'Tipo de plato:',
                selectedPlate,
                platePrices,
                (value) {
                  if (value != null) {
                    setState(() {
                      selectedPlate = value;
                    });
                  }
                },
              ),
              const SizedBox(height: 8),
              buildQuantityField('Cantidad de proteina a adquirir', plateQuantityController),

              const SizedBox(height: 16),

              buildDropdown(
                'Bebida:',
                selectedDrink,
                drinkPrices,
                (value) {
                  if (value != null) {
                    setState(() {
                      selectedDrink = value;
                    });
                  }
                },
              ),
              const SizedBox(height: 8),
              buildQuantityField('Cantidad de bebidas a adquirir', drinkQuantityController),

              const SizedBox(height: 16),

              buildDropdown(
                'Acompañamiento:',
                selectedSide,
                sidePrices,
                (value) {
                  if (value != null) {
                    setState(() {
                      selectedSide = value;
                    });
                  }
                },
              ),
              const SizedBox(height: 8),
              buildQuantityField('Cantidad de acompañamientos que adquirira', sideQuantityController),

              const SizedBox(height: 30),

              ElevatedButton(
                onPressed: calculateTotal,
                child: const Text('Calcular Total'),
              ),

              const SizedBox(height: 30),

              Text(resultText),
            ],
          ),
        ),
      ),
    );
  }
}