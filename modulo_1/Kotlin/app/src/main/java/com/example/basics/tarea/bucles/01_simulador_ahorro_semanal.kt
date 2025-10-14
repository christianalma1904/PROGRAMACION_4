package com.example.ahorro

fun main() {

    // 1. Pedir la meta de ahorro
    println("Ingrese la meta total de ahorro:")
    val meta = readLine()?.toDoubleOrNull() ?: 0.0

    // 2. Pedir el ahorro inicial
    println("Ingrese el ahorro inicial (depósito en la semana 0):")
    val ahorroInicial = readLine()?.toDoubleOrNull() ?: 0.0

    // Verificar que la meta sea positiva
    if (meta <= 0) {
        println("La meta debe ser un valor positivo.")
        return
    }

    simularAhorroSemanal(meta, ahorroInicial)
}

fun simularAhorroSemanal(meta: Double, ahorroInicial: Double) {

    var ahorroTotal = ahorroInicial
    var semana = 1

    // El depósito inicial es 5.0
    var depositoSemanal = 5.0

    println("\nINICIO DE SIMULACIÓN")
    println("Meta: ${String.format("%.2f", meta)} €")
    println("Ahorro Inicial (Semana 0): ${String.format("%.2f", ahorroTotal)} €")

    // El bucle se ejecuta mientras el ahorro total sea menor que la meta.
    while (ahorroTotal < meta) {

        ahorroTotal += depositoSemanal

        println("Semana $semana: Depósito = ${String.format("%.2f", depositoSemanal)} € | Total Acumulado = ${String.format("%.2f", ahorroTotal)} €")

        semana++
        depositoSemanal += 10.0
    }

    println("\n¡META ALCANZADA en la Semana ${semana - 1}!")
}

/*
 * Ejemplo de secuencia de depósitos:
 * Semana 1: Deposita 5.0
 * Semana 2: Deposita 15.0 (5 + 10)
 * Semana 3: Deposita 25.0 (15 + 10)
 * Semana 4: Deposita 35.0 (25 + 10)
 * ...
 */