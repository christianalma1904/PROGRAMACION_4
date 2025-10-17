package com.example.basics

fun main(){
    for (n in 1..20){
        val clasificar = when {
            n % 2 == 0 && n < 10 -> "Par pequeño"

            n % 2 == 0 && n > 10 -> "Par grande"

            n % 2 != 0 && n < 10 -> "Impar pequeño"

            else -> "Impar Grande"
        }
        println("Numero $n: $clasificar");
    }

    var i = 1;
    while (i <= 20){
        if (i % 2 == 0 && i < 10){
            println("Numero $i es Par Pequeño")
        } else if (i % 2 == 0 && i > 10){
            println("Numero $i es Par Grande")
        } else if (i % 2 != 0 && i < 10){
            println("Numero $i es Impar Pequeño")
        } else {
            println("Numero $i es Impar Grande")
        }
        i++
    }

    //CONTADOR DE VOCALES
    val palabra = "ProgramacionEnKotlin"

    var contadorVocales = 0

    println("--- Contando vocales en: \"$palabra\" ---")

    for (caracter in palabra) {

        when (caracter) {
            'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' -> {
                contadorVocales++
                println("Vocal encontrada: $caracter")
            }
            // El 'else' es opcional aquí, ya que si no es vocal, no hacemos nada.
        }
    }

    println("\nEl número total de vocales en \"$palabra\" es: $contadorVocales")

// Si quieres usar 'if/else' en lugar de 'when', sería así:
    /*
    for (caracter in palabra) {
        if (caracter == 'a' || caracter == 'A' ||
            caracter == 'e' || caracter == 'E' ||
            caracter == 'i' || caracter == 'I' ||
            caracter == 'o' || caracter == 'O' ||
            caracter == 'u' || caracter == 'U') {
            contadorVocales++
        }
    }
    */
}