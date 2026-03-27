package com.example.basics

fun main(){
    println("VARIABLES EN MI CEMENTERIO")

    val cementerio = "Jardines del Silencio"
    val cuidador = "Don Christian Alcocer"

    println("Tipos de Variables")
    println("Tipos Numéricos")
    println("Entero")
    val tumbas: Int = 1250
    println(tumbas)

    println("Tipo Double")
    val area: Double = 3200.75
    println(area)

    println("Tipo Float")
    val temperatura: Float = 18.6f
    println(temperatura)

    println("Tipo Long")
    val visitantesAnuales: Long = 1_200_000L
    println(visitantesAnuales)

    println("Tipos de Texto")
    val epitafio: String = "Aquí descansa un alma en paz"
    println(epitafio)

    println("Tipo Char")
    val bloque: Char = 'B'
    println(bloque)

    println("Tipo Lógico")
    val hayVelasEncendidas: Boolean = true
    println(hayVelasEncendidas)

    println("Tipo Nulo")
    val florOfrecida: String? = null
    println(florOfrecida)

    println("Cadena Vacía")
    val nombreDifunto: String? = ""
    println(nombreDifunto?.length)

    println("Operación de Aserción no Null")
    val longitudNombre = florOfrecida?.length
    println(longitudNombre)

    println("Interpolación de Strings 🕯️")
    val nombreDifunta: String = "María de los Ángeles"
    val edadDifunta: Int = 87
    val fechaEntierro: String = "12 de noviembre de 1985"
    println("${nombreDifunta.uppercase()} fue enterrada en el bloque $bloque del $cementerio")
    println("Hace ${2025 - 1985} años desde su descanso eterno")

    println("String Multilínea")
    val mensaje = """
        Estimado $cuidador,
        El cementerio $cementerio mantiene un registro actualizado.
        Hoy el clima es de $temperatura°C y hay ${visitantesAnuales / 365} visitantes por día.
        Recuerde encender las luces del bloque $bloque al anochecer.
    """
    println(mensaje)

    println("Conversiones")
    val textoTumbas: String = "1250"
    val tumbasConvertidas: Int = textoTumbas.toInt()
    println(tumbasConvertidas)

    val tamaño: Double = 15.8
    val tamañoConvertido: String = tamaño.toString()
    println(tamañoConvertido)
}
