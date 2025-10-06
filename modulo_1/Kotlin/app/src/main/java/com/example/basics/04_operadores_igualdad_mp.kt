package com.example.basics

fun main() {
    println("OPERADORES DE IGUALDAD EN MI CEMENTERIO")

    val lapida1: String = "María de los Ángeles"
    val lapida2: String = "María de los Ángeles"
    val lapida3: String = String("María de los Ángeles".toCharArray())

    println("Igualdad Estructural (Comparación de contenido):")
    println(lapida1 == lapida2) // true: tienen el mismo texto en la lápida.
    println(lapida1 == lapida3) // true: aunque es otro objeto, el contenido es igual

    println("\nIgualdad Referencial (Misma instancia en memoria):")
    println(lapida1 === lapida2) // true o false según la optimización del compilador
    println(lapida1 === lapida3) // false: aunque el texto sea igual, son diferentes objetos

    println("\nContexto:")
    println("En el registro del cementerio, dos lápidas pueden tener el mismo nombre inscrito,")
    println("pero eso no significa que sean la misma piedra o la misma persona.")
    println("'==' compara el texto grabado en la lápida (contenido).")
    println("'===' verifica si es la misma lápida física (referencia).")
}
