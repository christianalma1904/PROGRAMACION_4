package com.example.rally

fun main() {
    val generadorAleatorio = java.util.Random()

    var energia = 100
    var etapa = 1

    println("INICIO DEL RALLY DE RESISTENCIA")
    println("Energía inicial: $energia")

    // Bucle principal: se ejecuta mientras haya energía suficiente
    while (energia > 0) {

        // 1. Generar Terreno aleatorio (número entre 1 y 3)
        val terreno = generadorAleatorio.nextInt(3) + 1
        var costeEnergia = 0
        var nombreTerreno = ""

        // 2. Determinar el coste de energía y el nombre del terreno
        when (terreno) {
            1 -> {
                costeEnergia = 5
                nombreTerreno = "Asfalto"
            }
            2 -> {
                costeEnergia = 10
                nombreTerreno = "Tierra"
            }
            3 -> {
                costeEnergia = 15
                nombreTerreno = "Barro"
            }
        }

        // 3. Aplicar el coste
        energia -= costeEnergia

        // 4. Imprimir el estado de la etapa
        println("\nETAPA $etapa:")
        println("  Terreno: $nombreTerreno (-$costeEnergia)")

        // 5. Verificar si la energía se ha agotado o caído por debajo de cero
        if (energia <= 0) {
            println("¡ENERGÍA AGOTADA! Abandona en etapa $etapa.")
            break
        }

        // Imprimir la energía restante antes de la siguiente etapa
        println("  Energía restante: $energia")

        // 6. Pasar a la siguiente etapa
        etapa++
    }

    println("FIN DEL RALLY")
}