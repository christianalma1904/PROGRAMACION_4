package com.example.cementerio

class AsignacionTumbaException(mensaje: String) : Exception(mensaje)

data class Tumba(val numero: Int, var ocupada: Boolean = false)

class ServicioCementerio(private val totalTumbas: Int) {

    private val tumbas = mutableListOf<Tumba>()

    init {
        for (i in 1..totalTumbas) {
            tumbas.add(Tumba(i))
        }
        // Marcamos una tumba como ocupada para provocar un error de prueba.
        tumbas.find { it.numero == 5 }?.ocupada = true
        // Mensaje de estado inicial.
        println("ServicioCementerio inicializado. Tumba 5 ocupada.")
    }

    fun asignarTumba(nombreDifunto: String, numeroTumba: Int) {
        if (numeroTumba <= 0 || numeroTumba > totalTumbas) {
            throw AsignacionTumbaException("Número de tumba fuera de rango ($numeroTumba).")
        }

        val tumba = tumbas.find { it.numero == numeroTumba }

        if (tumba?.ocupada == true) {
            throw AsignacionTumbaException("La Tumba N° $numeroTumba ya está OCUPADA.")
        }

        // Si llega hasta aquí, es éxito y se realiza la asignación.
        tumba?.ocupada = true
        // NOTA: Se eliminó el 'println' de éxito de esta función.
    }
}

fun main() {
    val cementerio = ServicioCementerio(totalTumbas = 10)

    println("\nIntentos de Asignación")

    // Intento 1: Asignación exitosa
    try {
        cementerio.asignarTumba("María Pérez", 3)
        println("Éxito (1): María Pérez asignada a la Tumba N° 3.")
    } catch (e: AsignacionTumbaException) {
        println("ERROR: ${e.message}")
    }

    // Intento 2: Causa el error de "Tumba Ocupada"
    try {
        cementerio.asignarTumba("Juan Gómez", 5)
        println("Éxito (2): Juan Gómez asignado.")
    } catch (e: AsignacionTumbaException) {
        println("ERROR DE NEGOCIO (2): ${e.message}")
    } catch (e: Exception) {
        // Captura cualquier otra excepción general
        println("ERROR INESPERADO (2): ${e.message}")
    }

    // Intento 3: Causa el error de "Tumba Inválida"
    try {
        cementerio.asignarTumba("Pedro López", 15)
        println("Éxito (3): Pedro López asignado.")
    } catch (e: AsignacionTumbaException) {
        println("ERROR DE RANGO (3): ${e.message}")
    }
}