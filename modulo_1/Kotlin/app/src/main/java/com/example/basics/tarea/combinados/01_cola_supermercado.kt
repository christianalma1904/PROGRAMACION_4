package com.example.supermercado

fun main() {
    var ventaTotalDelDia = 0.0
    var cantidadClientes = 0
    var entrada: String

    println("SIMULADOR DE COLA DE SUPERMERCADO")

    while (true) {
        println("\nNuevo Cliente")
        println("Ingrese el TOTAL de la compra (ej: 125.50) o escriba 'fin' para cerrar la caja:")
        entrada = readLine().orEmpty().trim().lowercase()

        if (entrada == "fin") {
            break
        }

        // Intentar convertir la entrada a un número decimal
        val totalCompra = entrada.toDoubleOrNull()

        // 1. Validar la entrada y continuar si es un valor válido
        if (totalCompra == null || totalCompra <= 0) {
            println("Error: Total inválido o cero. Intente de nuevo.")
            continue
        }

        // 2. Pedir la cantidad de ítems
        println("Ingrese la cantidad de ítems del cliente:")
        val cantidadItems = readLine()?.toIntOrNull() ?: 0

        var totalConDescuento = totalCompra

        // 3. Aplicar 5% de descuento si total > 100
        if (totalCompra > 100.0) {
            val descuento = totalCompra * 0.05
            totalConDescuento = totalCompra - descuento
            println("Descuento aplicado: 5% (${String.format("%.2f", descuento)} €). Nuevo total: ${String.format("%.2f", totalConDescuento)} €")
        }

        // 4. Mensaje de Caja Rápida
        if (cantidadItems > 10) {
            println("Mensaje: Caja rápida no disponible (ítems > 10).")
        } else {
            println("Caja rápida disponible.")
        }

        // 5. Acumular estadísticas
        ventaTotalDelDia += totalConDescuento
        cantidadClientes++

        println("Cliente atendido con éxito.")
    }

    println("\n")
    println("REPORTE DE VENTA DEL DÍA")
    println("Cantidad de clientes atendidos: $cantidadClientes")
    println("Venta total acumulada del día: ${String.format("%.2f", ventaTotalDelDia)} €")
}