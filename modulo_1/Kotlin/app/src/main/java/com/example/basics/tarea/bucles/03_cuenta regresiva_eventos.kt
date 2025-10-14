package com.example.cuentaregresiva

fun main() {

    println("INICIO DE LA CUENTA REGRESIVA")

    // El bucle va desde 30 hasta 0
    for (contador in 30 downTo 0) {

        // Evalúa el valor del contador
        val mensaje = when (contador) {
            20 -> "Chequeo de sistemas"
            10 -> "Últimos ajustes"
            0 -> "Despegue"
            else -> "$contador"
        }

        // Imprimir el resultado
        println(mensaje)
    }

    println("FIN DE LA CUENTA REGRESIVA")
}