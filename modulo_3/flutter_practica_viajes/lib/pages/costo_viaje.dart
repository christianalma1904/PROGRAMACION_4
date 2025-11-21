import 'package:flutter/material.dart';
import 'dart:math'; // Para la función max

// --- Definiciones de Enums ---

enum Destino { playa, montana, ciudad }
enum Alojamiento { hostal, hotel3, hotel5 }

// --- Widget Principal ---

class VacationCostCalculator extends StatefulWidget {
  const VacationCostCalculator({super.key});

  @override
  State<VacationCostCalculator> createState() => _VacationCostCalculatorState();
}

class _VacationCostCalculatorState extends State<VacationCostCalculator> {
  // --- Estados y Controladores ---

  // Controladores de Texto
  final TextEditingController _diasController = TextEditingController();
  final TextEditingController _personasController = TextEditingController();
  final TextEditingController _precioBaseController = TextEditingController();

  // Estados para Dropdown y Radio Buttons
  Destino _destinoSeleccionado = Destino.playa;
  Alojamiento _alojamientoSeleccionado = Alojamiento.hostal;

  // Estados para Checkboxes
  bool _incluirTours = false;
  bool _incluirSeguro = false;

  // Resultados del Cálculo
  double _subtotal = 0.0;
  double _recargosAdicionales = 0.0;
  double _precioTotal = 0.0;
  double _precioPorPersona = 0.0;
  String _mensajeError = '';

  // --- Factores de Recargo ---

  // Recargo por Destino (al precio base)
  double _getRecargoDestino(Destino destino) {
    switch (destino) {
      case Destino.playa:
        return 0.20; // +20%
      case Destino.montana:
        return 0.10; // +10%
      case Destino.ciudad:
        return 0.05; // +5%
    }
  }

  // Recargo por Alojamiento (al precio base)
  double _getRecargoAlojamiento(Alojamiento alojamiento) {
    switch (alojamiento) {
      case Alojamiento.hostal:
        return 0.0; // +0%
      case Alojamiento.hotel3:
        return 0.15; // +15%
      case Alojamiento.hotel5:
        return 0.30; // +30%
    }
  }

  // --- Lógica de Cálculo ---

  void _calcularCosto() {
    // 1. Obtener y validar Inputs
    final dias = int.tryParse(_diasController.text) ?? 0;
    final personas = int.tryParse(_personasController.text) ?? 0;
    final precioBaseDiario = double.tryParse(_precioBaseController.text.replaceAll(',', '.')) ?? 0.0;

    if (dias <= 0 || personas <= 0 || precioBaseDiario <= 0) {
      setState(() {
        _mensajeError = 'Ingrese valores válidos y mayores a cero para Días, Personas y Precio Base.';
        _precioTotal = 0.0;
        _subtotal = 0.0;
        _recargosAdicionales = 0.0;
        _precioPorPersona = 0.0;
      });
      return;
    }

    // Limpiar mensaje de error si la validación es exitosa
    _mensajeError = '';

    // 2. Aplicar Recargos Fijos (Destino y Alojamiento)
    final recargoDestino = _getRecargoDestino(_destinoSeleccionado);
    final recargoAlojamiento = _getRecargoAlojamiento(_alojamientoSeleccionado);
    
    // Total de recargos fijos (se suman al precio base)
    final factorRecargoFijo = 1.0 + recargoDestino + recargoAlojamiento;
    
    // Costo diario modificado
    final costoDiarioModificado = precioBaseDiario * factorRecargoFijo;

    // Subtotal: Costo Diario Modificado * Días * Personas
    double subtotalCalculado = costoDiarioModificado * dias * personas;

    // 3. Aplicar Recargos Adicionales (Tours y Seguro)
    double recargoTours = 0.0;
    double recargoSeguro = 0.0;
    double recargosAdicionalesTotal = 0.0;

    if (_incluirTours) {
      recargoTours = subtotalCalculado * 0.10; // +10% al subtotal
    }
    if (_incluirSeguro) {
      recargoSeguro = subtotalCalculado * 0.05; // +5% al subtotal
    }
    
    recargosAdicionalesTotal = recargoTours + recargoSeguro;

    // 4. Calcular Precio Total
    double precioTotalCalculado = subtotalCalculado + recargosAdicionalesTotal;

    // 5. Calcular Precio por Persona
    double precioPorPersonaCalculado = precioTotalCalculado / personas;

    // 6. Actualizar Estado
    setState(() {
      _subtotal = subtotalCalculado;
      _recargosAdicionales = recargosAdicionalesTotal;
      _precioTotal = precioTotalCalculado;
      _precioPorPersona = precioPorPersonaCalculado;
    });
  }
  
  // Limpiamos los controladores al destruir el widget
  @override
  void dispose() {
    _diasController.dispose();
    _personasController.dispose();
    _precioBaseController.dispose();
    super.dispose();
  }

  // --- Construcción de la Interfaz (UI) ---

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Calculadora de Viajes', style: TextStyle(color: Colors.white)), 
        backgroundColor: Colors.indigo,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            const Text(
              'Detalles del Viaje',
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.indigo),
            ),
            const SizedBox(height: 16),
            
            // --- Inputs de Datos ---
            _buildInputField(controller: _diasController, label: 'Días de Viaje', icon: Icons.calendar_today),
            const SizedBox(height: 16),
            _buildInputField(controller: _personasController, label: 'Número de Personas', icon: Icons.people),
            const SizedBox(height: 16),
            _buildInputField(controller: _precioBaseController, label: 'Precio Base Diario (\$)', icon: Icons.attach_money),
            const SizedBox(height: 24),

            // --- Dropdown (Destino) ---
            const Text('Destino:', style: TextStyle(fontSize: 16, fontWeight: FontWeight.w600)),
            _buildDropdownDestino(),
            const SizedBox(height: 24),

            // --- Radio Buttons (Alojamiento) ---
            const Text('Alojamiento:', style: TextStyle(fontSize: 16, fontWeight: FontWeight.w600)),
            _buildRadioAlojamiento(),
            const SizedBox(height: 24),

            // --- Checkboxes (Adicionales) ---
            _buildCheckboxTours(),
            _buildCheckboxSeguro(),
            const SizedBox(height: 32),
            
            // --- Botón de Cálculo ---
            ElevatedButton(
              onPressed: _calcularCosto,
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.indigo,
                foregroundColor: Colors.white,
                padding: const EdgeInsets.symmetric(vertical: 15),
                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
              ),
              child: const Text('Calcular Costos', style: TextStyle(fontSize: 18)),
            ),

            const SizedBox(height: 32),

            // --- Resultados ---
            _buildResultadoCard(),
          ],
        ),
      ),
    );
  }

  // Widget genérico para los campos de entrada de texto
  Widget _buildInputField({
    required TextEditingController controller,
    required String label,
    required IconData icon,
  }) {
    return TextField(
      controller: controller,
      keyboardType: TextInputType.number,
      decoration: InputDecoration(
        labelText: label,
        prefixIcon: Icon(icon, color: Colors.indigo),
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(10.0),
        ),
      ),
    );
  }

  // Widget para el Dropdown de Destino
  Widget _buildDropdownDestino() {
    return DropdownButtonFormField<Destino>(
      value: _destinoSeleccionado,
      decoration: const InputDecoration(
        border: OutlineInputBorder(borderRadius: BorderRadius.all(Radius.circular(10))),
        contentPadding: EdgeInsets.symmetric(horizontal: 15, vertical: 5),
      ),
      items: Destino.values.map((Destino destino) {
        return DropdownMenuItem<Destino>(
          value: destino,
          child: Text(_destinoToString(destino)),
        );
      }).toList(),
      onChanged: (Destino? newValue) {
        if (newValue != null) {
          setState(() {
            _destinoSeleccionado = newValue;
          });
        }
      },
    );
  }

  // Helper para convertir Enum a String legible
  String _destinoToString(Destino destino) {
    switch (destino) {
      case Destino.playa:
        return 'Playa (+20%)';
      case Destino.montana:
        return 'Montaña (+10%)';
      case Destino.ciudad:
        return 'Ciudad (+5%)';
    }
  }
  
  // Widget para los Radio Buttons de Alojamiento
  Widget _buildRadioAlojamiento() {
    return Column(
      children: Alojamiento.values.map((Alojamiento alojamiento) {
        return RadioListTile<Alojamiento>(
          title: Text(_alojamientoToString(alojamiento)),
          value: alojamiento,
          groupValue: _alojamientoSeleccionado,
          onChanged: (Alojamiento? newValue) {
            if (newValue != null) {
              setState(() {
                _alojamientoSeleccionado = newValue;
              });
            }
          },
          dense: true,
          contentPadding: EdgeInsets.zero,
        );
      }).toList(),
    );
  }

  // Helper para convertir Enum a String legible
  String _alojamientoToString(Alojamiento alojamiento) {
    switch (alojamiento) {
      case Alojamiento.hostal:
        return 'Hostal (+0%)';
      case Alojamiento.hotel3:
        return 'Hotel 3 estrellas (+15%)';
      case Alojamiento.hotel5:
        return 'Hotel 5 estrellas (+30%)';
    }
  }

  // Widget para Checkbox de Tours
  Widget _buildCheckboxTours() {
    return CheckboxListTile(
      title: const Text('Incluir Tours (+10% al Subtotal)'),
      value: _incluirTours,
      onChanged: (bool? newValue) {
        setState(() {
          _incluirTours = newValue ?? false;
        });
      },
      controlAffinity: ListTileControlAffinity.leading,
      contentPadding: EdgeInsets.zero,
      activeColor: Colors.indigo,
    );
  }
  
  // Widget para Checkbox de Seguro
  Widget _buildCheckboxSeguro() {
    return CheckboxListTile(
      title: const Text('Incluir Seguro de Viaje (+5% al Subtotal)'),
      value: _incluirSeguro,
      onChanged: (bool? newValue) {
        setState(() {
          _incluirSeguro = newValue ?? false;
        });
      },
      controlAffinity: ListTileControlAffinity.leading,
      contentPadding: EdgeInsets.zero,
      activeColor: Colors.indigo,
    );
  }

  // Widget para mostrar el resultado
  Widget _buildResultadoCard() {
    if (_mensajeError.isNotEmpty) {
      return Card(
        elevation: 4,
        color: Colors.red.shade50,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Text(_mensajeError, style: TextStyle(color: Colors.red.shade800, fontWeight: FontWeight.bold)),
        ),
      );
    }
    
    // Solo mostrar el resultado detallado si el cálculo fue exitoso y el precio total > 0
    if (_precioTotal <= 0.0 && _diasController.text.isEmpty && _personasController.text.isEmpty && _precioBaseController.text.isEmpty) {
       return const SizedBox.shrink(); // No mostrar nada si aún no se ha intentado calcular
    }

    return Card(
      elevation: 8,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
      color: Colors.indigo.shade50,
      child: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text('Resumen de Costos', style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.indigo)),
            const Divider(color: Colors.indigo),
            
            _buildResultRow('Subtotal (Precio Base + Recargos Fijos):', _subtotal),
            _buildResultRow('Recargos Adicionales (Tours/Seguro):', _recargosAdicionales, isRecargo: true),
            
            const Divider(height: 20, thickness: 2),

            _buildResultRow('Precio Total del Viaje:', _precioTotal, isTotal: true),
            _buildResultRow('Precio por Persona:', _precioPorPersona, isTotal: true),
          ],
        ),
      ),
    );
  }
  
  // Helper para construir las filas de resultados
  Widget _buildResultRow(String label, double value, {bool isRecargo = false, bool isTotal = false}) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 5.0),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text(
            label,
            style: TextStyle(
              fontSize: isTotal ? 18 : 14,
              fontWeight: isTotal ? FontWeight.bold : FontWeight.normal,
              color: isTotal ? Colors.indigo.shade800 : Colors.black87,
            ),
          ),
          Text(
            '\$${max(0.0, value).toStringAsFixed(2)}', // Asegura que no sea negativo
            style: TextStyle(
              fontSize: isTotal ? 20 : 16,
              fontWeight: isTotal ? FontWeight.w900 : FontWeight.bold,
              color: isTotal ? Colors.indigo.shade900 : (isRecargo ? Colors.red.shade700 : Colors.green.shade700),
            ),
          ),
        ],
      ),
    );
  }
}