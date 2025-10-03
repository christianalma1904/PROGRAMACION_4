package com.example.basics

fun main(){
    println("VARIABLES")
    val planeta = "Tatooine"
    val jedi = "Anakin"

    println("Tipos de Variables")
    println("Tipos Numericos")
    println("Entero")
    val edad: Int = 25
    println(edad)
    println("Tipos Double")
    val altura: Double = 25.5
    println(altura)
    println("Tipos Float")
    val peso: Float = 25.5f
    println(peso)
    println("Tipos Long")
    val poblacion: Long = 2_000_000_000L
    println(poblacion)

    println("Tipos Texto")
    val nombre: String = "Obi-Wan Kenobi"
    println(nombre)

    println("Tipos Char")
    val inicial: Char = '0'
    println(inicial)

    println("Tipos Logico")
    val esJedi: Boolean = true
    println(esJedi)

    println("Tipos Nulo")
    val apellido: String? = null
    println(apellido)

    println("Tipos Nulo")
    val ciudad: String? = ""
    println(ciudad?.length)

    println("Operacion de Asercion no Null")
    val longitudSegura = apellido?.length
    println(longitudSegura)

    println("Interpolacion de Strings")
    val nombrePrincesa: String = "Leia"
    val edadPrincesa: Int = 19
    val planetaPrincesa: String = "Alderan"
    println("${nombre.uppercase()} nacio en ${planeta}")
    println("En 10 años tendra: ${edadPrincesa+10} años")

    println("String Multitarea")
    val mensaje = """
        Querido $nombre
        Tu mision en $planeta
        ha sido completada exitosamente
        Que la Fuerza te Acompañe
    """
    println(mensaje)

    println("Conversiones")
    val textoEdad: String = "25"
    val edadConvertida: Int = textoEdad.toInt()
    println(edadConvertida)

    val numero: Double = 50.8
    val numeroConvertido: String = numero.toString()
    println(numeroConvertido)
}