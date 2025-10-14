package com.example.controlacceso

fun main() {

    // 1. Pedir la hora
    println("Ingrese la hora actual (0-23):")
    val hora = readLine()?.toIntOrNull() ?: -1

    // 2. Pedir el rol
    println("Ingrese su rol ('admin', 'empleado', 'invitado'):")
    val rolUsuario = readLine().orEmpty().trim().lowercase()

    // 3. Evaluar y mostrar el resultado
    val estadoAcceso = verificarAcceso(hora, rolUsuario)

    println("\nRESULTADO DE ACCESO")
    println("Rol: $rolUsuario, Hora: $hora")
    println("Acceso: $estadoAcceso")
}

fun verificarAcceso(hora: Int, rol: String): String {

    // Primero, verificamos que la hora sea válida
    if (hora !in 0..23) {
        return "DENIED: Hora inválida."
    }

    return when (rol) {
        "admin" -> "PERMITIDO (Acceso 24h)"

        "empleado" -> {
            // Empleado: 6 a 20 (incluidos)
            if (hora >= 6 && hora <= 20) {
                "PERMITIDO"
            } else {
                "DENIED: Fuera de horario (6h-20h)"
            }
        }

        "invitado" -> {
            // Invitado: 9 a 17 (incluidos)
            if (hora >= 9 && hora <= 17) {
                "PERMITIDO"
            } else {
                "DENIED: Fuera de horario (9h-17h)"
            }
        }

        else -> "DENIED: Rol desconocido"
    }
}