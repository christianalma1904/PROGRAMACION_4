package com.example.atm

fun main() {
    println("ATM Simplificado - Inicie su sesión")
    println("Ingrese su saldo inicial:")
    var saldo = readLine()?.toDoubleOrNull() ?: 0.0

    // Bucle principal del menú
    while (true) {

        println("\n")
        println("Saldo actual: ${String.format("%.2f", saldo)} €")
        println("Seleccione una opción:")
        println("1) Depositar")
        println("2) Retirar")
        println("3) Salir")

        val opcion = readLine().orEmpty().trim()

        when (opcion) {
            "1" -> {
                println("Ingrese la cantidad a depositar:")
                val deposito = readLine()?.toDoubleOrNull()

                if (deposito != null && deposito > 0) {
                    saldo += deposito
                    println("Depósito exitoso. Nuevo saldo: ${String.format("%.2f", saldo)} €")
                } else {
                    println("Error: Cantidad de depósito inválida.")
                }
            }

            "2" -> {
                println("Ingrese la cantidad a retirar:")
                val retiro = readLine()?.toDoubleOrNull()

                if (retiro != null && retiro > 0) {
                    if (saldo - retiro >= 0) {
                        saldo -= retiro
                        println("Retiro exitoso. Nuevo saldo: ${String.format("%.2f", saldo)} €")
                    } else {
                        println("Error: Fondos insuficientes. Intento de retiro: ${String.format("%.2f", retiro)} €")
                    }
                } else {
                    println("Error: Cantidad de retiro inválida.")
                }
            }

            "3" -> {
                // Opción para salir del bucle
                println("\nSesión terminada. Gracias por usar nuestro ATM.")
                return // Salir de la función main() y terminar el programa
            }

            else -> {
                println("Opción no válida. Intente de nuevo.")
            }
        }
    }
}