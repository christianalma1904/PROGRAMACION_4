package com.example.detectorvocales

fun main() {

    // 1. Pedir el texto
    println("Ingrese un texto para contar las vocales consecutivas:")
    val texto = readLine().orEmpty()

    // 2. Contar y mostrar el resultado
    val totalConsecutivas = contarVocalesConsecutivas(texto)

    println("\nRESULTADO")
    println("Texto ingresado: \"$texto\"")
    println("Total de pares de vocales consecutivas: $totalConsecutivas")
}

fun contarVocalesConsecutivas(texto: String): Int {

    var contador = 0
    val textoNormalizado = texto.lowercase()

    // Definimos el conjunto de vocales para verificación rápida
    val vocales = setOf('a', 'e', 'i', 'o', 'u')

    // Recorremos el texto hasta el penúltimo carácter
    // ya que necesitamos verificar el carácter actual (i) y el siguiente (i + 1).
    for (i in 0 until textoNormalizado.length - 1) {

        val caracterActual = textoNormalizado[i]
        val caracterSiguiente = textoNormalizado[i + 1]

        // Verificamos si ambos caracteres (el actual y el siguiente) son vocales.
        if (caracterActual in vocales && caracterSiguiente in vocales) {
            contador++
        }
    }

    return contador
}