package com.example.generadorusuario

fun main() {

    // 1. Pedir nombre y apellido
    println("Ingrese su nombre:")
    val nombre = readLine().orEmpty().trim()

    println("Ingrese su apellido:")
    val apellido = readLine().orEmpty().trim()

    // 2. Generar el username
    val username = generarUsername(nombre, apellido)

    println("\nRESULTADO")
    println("Nombre: $nombre, Apellido: $apellido")
    println("Username generado: $username")
}

fun generarUsername(nombre: String, apellido: String): String {

    val constructor = StringBuilder()
    var indiceNombre = 0
    var indiceApellido = 0

    val longitudNombre = nombre.length
    val longitudApellido = apellido.length

    // Bucle principal: se ejecuta mientras haya letras disponibles en el nombre O en el apellido.
    while (indiceNombre < longitudNombre || indiceApellido < longitudApellido) {

        // 1. Tomar 2 letras del NOMBRE
        if (indiceNombre < longitudNombre) {
            val fin = minOf(indiceNombre + 2, longitudNombre)
            constructor.append(nombre.substring(indiceNombre, fin))
            indiceNombre = fin // Avanzar el índice
        }

        // 2. Tomar 2 letras del APELLIDO
        if (indiceApellido < longitudApellido) {
            val fin = minOf(indiceApellido + 2, longitudApellido)
            constructor.append(apellido.substring(indiceApellido, fin))
            indiceApellido = fin // Avanzar el índice
        }
    }

    var usernameFinal = constructor.toString()

    // 3. Rellenar con números si la longitud es menor a 6
    if (usernameFinal.length < 6) {
        var numeroRelleno = 1
        while (usernameFinal.length < 6) {
            usernameFinal += numeroRelleno.toString()
            numeroRelleno++
        }
    }

    return usernameFinal
}