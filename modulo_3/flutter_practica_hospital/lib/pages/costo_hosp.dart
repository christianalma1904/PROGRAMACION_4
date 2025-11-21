import 'package:flutter/material.dart';

// Definiciones de tipos de habitación y seguro
enum TipoHabitacion { general, semiprivada, privada }
enum TipoSeguro { publico, privado, sinSeguro }

// Clase principal del widget
class HospitalCostCalculator extends StatefulWidget {
  const HospitalCostCalculator({super.key});

  @override
  State<HospitalCostCalculator> createState() => _HospitalCostCalculatorState();
}

class _HospitalCostCalculatorState extends State<HospitalCostCalculator> {
  // --- Estado del Widget ---
  TipoHabitacion _habitacionSeleccionada = TipoHabitacion.general;
  TipoSeguro _seguroSeleccionado = TipoSeguro.sinSeguro;
  
  // Controladores para los campos de texto
  final TextEditingController _diasController = TextEditingController(text: '');
  final TextEditingController _costoDiarioController = TextEditingController(text: '');
  
  // Resultado del cálculo y mensaje de error/validación
  String _resultadoTexto = 'Presione "Calcular" para obtener el costo.';
  double _costoTotal = 0.0;

  // --- Factores y Reducciones ---

  // Factor de multiplicación por tipo de habitación (x1, x1.4, x2)
  double _getFactorHabitacion(TipoHabitacion habitacion) {
    switch (habitacion) {
      case TipoHabitacion.general:
        return 1.0;
      case TipoHabitacion.semiprivada:
        return 1.4;
      case TipoHabitacion.privada:
        return 2.0;
    }
  }

  // Factor de reducción (el valor que queda después del descuento)
  double _getFactorSeguro(TipoSeguro seguro) {
    switch (seguro) {
      case TipoSeguro.publico:
        return 0.70; // 1 - 0.30 (30% de descuento)
      case TipoSeguro.privado:
        return 0.50; // 1 - 0.50 (50% de descuento)
      case TipoSeguro.sinSeguro:
        return 1.0; // 0% de descuento
    }
  }

  // --- Lógica de Cálculo (Se ejecuta solo al presionar el botón) ---
  void _calcularCosto() {
    // Obtener valores de los inputs
    final dias = double.tryParse(_diasController.text.replaceAll(',', '.')) ?? 0.0;
    final costoDiarioBase = double.tryParse(_costoDiarioController.text.replaceAll(',', '.')) ?? 0.0;

    // Validación similar al ejemplo de IMC
    if (dias <= 0 || costoDiarioBase <= 0) {
      setState(() {
        _resultadoTexto = 'Ingrese días y costo diario base válidos y mayores a cero.';
        _costoTotal = 0.0;
      });
      return;
    }

    // Obtener factores
    final factorHabitacion = _getFactorHabitacion(_habitacionSeleccionada);
    final factorSeguro = _getFactorSeguro(_seguroSeleccionado);

    // 1. Aplicar factor de habitación
    final costoDiarioModificado = costoDiarioBase * factorHabitacion;

    // 2. Calcular el total sin descuento por seguro
    final costoTotalSinDescuento = costoDiarioModificado * dias;
    
    // 3. Aplicar el factor de seguro (descuento)
    final costoFinal = costoTotalSinDescuento * factorSeguro;

    // Actualizar el estado para mostrar el resultado
    setState(() {
      _costoTotal = costoFinal;
      _resultadoTexto = 'Costo calculado con éxito.';
    });
  }
  
  // Limpiamos los controladores al destruir el widget
  @override
  void dispose() {
    _diasController.dispose();
    _costoDiarioController.dispose();
    super.dispose();
  }

  // --- Construcción de la Interfaz (UI) ---

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Cálculo de Hospitalización', style: TextStyle(color: Colors.white)), 
        backgroundColor: Colors.teal,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            const Text(
              'Configuración de Costos',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.teal),
            ),
            const SizedBox(height: 16),
            
            // --- Select 1: Tipo de Habitación ---
            const Text('1. Tipo de Habitación:', style: TextStyle(fontSize: 14, fontWeight: FontWeight.w600)),
            _buildDropdownHabitacion(),
            const SizedBox(height: 16),

            // --- Select 2: Seguro Médico ---
            const Text('2. Seguro Médico:', style: TextStyle(fontSize: 14, fontWeight: FontWeight.w600)),
            _buildDropdownSeguro(),
            const SizedBox(height: 24),

            // --- Input 1: Días de Hospitalización ---
            _buildInputField(
              controller: _diasController,
              label: 'Días de Hospitalización',
              hint: 'Ingrese la cantidad de días',
              icon: Icons.calendar_today,
            ),
            const SizedBox(height: 16),

            // --- Input 2: Costo Diario Base ---
            _buildInputField(
              controller: _costoDiarioController,
              label: 'Costo Diario Base (\$)',
              hint: 'Costo base antes de factores',
              icon: Icons.attach_money,
            ),
            const SizedBox(height: 24),
            
            // --- Botón de Cálculo (Patrón de IMC) ---
            ElevatedButton(
              onPressed: _calcularCosto,
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.teal,
                foregroundColor: Colors.white,
                padding: const EdgeInsets.symmetric(vertical: 15),
                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
              ),
              child: const Text('Calcular Costo Total', style: TextStyle(fontSize: 18)),
            ),

            const SizedBox(height: 32),

            // --- Resultado del Cálculo (Similar a la salida del IMC) ---
            _buildResultadoCard(),
          ],
        ),
      ),
    );
  }

  // Widget para el Dropdown de Tipo de Habitación
  Widget _buildDropdownHabitacion() {
    return DropdownButtonFormField<TipoHabitacion>(
      value: _habitacionSeleccionada,
      decoration: const InputDecoration(
        border: OutlineInputBorder(borderRadius: BorderRadius.all(Radius.circular(10))),
        contentPadding: EdgeInsets.symmetric(horizontal: 15, vertical: 5),
      ),
      items: TipoHabitacion.values.map((TipoHabitacion habitacion) {
        return DropdownMenuItem<TipoHabitacion>(
          value: habitacion,
          child: Text(_habitacionToString(habitacion)),
        );
      }).toList(),
      onChanged: (TipoHabitacion? newValue) {
        if (newValue != null) {
          setState(() {
            _habitacionSeleccionada = newValue;
          });
          // Ya no se calcula aquí, solo se actualiza la selección
        }
      },
    );
  }

  // Helper para convertir Enum a String legible
  String _habitacionToString(TipoHabitacion habitacion) {
    switch (habitacion) {
      case TipoHabitacion.general:
        return 'General (Factor x1.0)';
      case TipoHabitacion.semiprivada:
        return 'Semi-Privada (Factor x1.4)';
      case TipoHabitacion.privada:
        return 'Privada (Factor x2.0)';
    }
  }

  // Widget para el Dropdown de Tipo de Seguro
  Widget _buildDropdownSeguro() {
    return DropdownButtonFormField<TipoSeguro>(
      value: _seguroSeleccionado,
      decoration: const InputDecoration(
        border: OutlineInputBorder(borderRadius: BorderRadius.all(Radius.circular(10))),
        contentPadding: EdgeInsets.symmetric(horizontal: 15, vertical: 5),
      ),
      items: TipoSeguro.values.map((TipoSeguro seguro) {
        return DropdownMenuItem<TipoSeguro>(
          value: seguro,
          child: Text(_seguroToString(seguro)),
        );
      }).toList(),
      onChanged: (TipoSeguro? newValue) {
        if (newValue != null) {
          setState(() {
            _seguroSeleccionado = newValue;
          });
          // Ya no se calcula aquí, solo se actualiza la selección
        }
      },
    );
  }

  // Helper para convertir Enum a String legible
  String _seguroToString(TipoSeguro seguro) {
    switch (seguro) {
      case TipoSeguro.publico:
        return 'Público (Descuento: 30%)';
      case TipoSeguro.privado:
        return 'Privado (Descuento: 50%)';
      case TipoSeguro.sinSeguro:
        return 'Sin Seguro (Descuento: 0%)';
    }
  }

  // Widget genérico para los campos de entrada de texto
  Widget _buildInputField({
    required TextEditingController controller,
    required String label,
    required String hint,
    required IconData icon,
  }) {
    return TextField(
      controller: controller,
      keyboardType: TextInputType.number,
      decoration: InputDecoration(
        labelText: label,
        hintText: hint,
        prefixIcon: Icon(icon, color: Colors.teal),
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(10.0),
        ),
      ),
      // No usamos onChanged ni listeners para seguir el patrón del botón explícito
    );
  }

  // Widget para mostrar el resultado
  Widget _buildResultadoCard() {
    return Card(
      elevation: 8,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
      color: _costoTotal > 0 ? Colors.teal.shade50 : Colors.blueGrey.shade50,
      child: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'Resultado:',
              style: TextStyle(
                fontSize: 16,
                fontWeight: FontWeight.w600,
                color: Colors.black54,
              ),
            ),
            const SizedBox(height: 10),
            if (_costoTotal > 0) 
              Text(
                'Costo Total: \$${_costoTotal.toStringAsFixed(2)}',
                style: TextStyle(
                  fontSize: 28,
                  fontWeight: FontWeight.w900,
                  color: Colors.teal.shade800,
                ),
              )
            else
              Text(
                _resultadoTexto,
                style: TextStyle(
                  fontSize: 16,
                  fontStyle: FontStyle.italic,
                  color: _resultadoTexto.contains('válidos') ? Colors.red.shade700 : Colors.black54,
                ),
              ),
          ],
        ),
      ),
    );
  }
}