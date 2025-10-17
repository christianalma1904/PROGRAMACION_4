package com.example.basics.practica

fun main() {
    var continuar = true

    println("Calculadora Mínima (+ / -)")

    while (continuar) {

        println("\nSeleccione una opción:")
        println("1) Sumar (+)")
        println("2) Restar (-)")
        println("3) Salir")

        val opcionInput = readln()
        val opcion = opcionInput.toIntOrNull() ?: 0

        when (opcion) {
            1, 2 -> {
                println("Introduce el primer número:")
                val num1 = readln().toDoubleOrNull()

                println("Introduce el segundo número:")
                val num2 = readln().toDoubleOrNull()

                if (num1 != null && num2 != null) {
                    val resultado: Double
                    val operacion: String

                    if (opcion == 1) {
                        resultado = num1 + num2
                        operacion = "+"
                    } else {
                        resultado = num1 - num2
                        operacion = "-"
                    }

                    println("\nResultado de $num1 $operacion $num2 es: $resultado")
                } else {
                    println("\nERROR: Por favor, introduce números válidos.")
                }
            }

            3 -> {
                println("\nSaliendo de la calculadora. ¡Hasta pronto!")
                continuar = false
            }

            else -> {
                println("\nOpción no válida. Por favor, introduce 1, 2 o 3.")
            }
        }
    }
}