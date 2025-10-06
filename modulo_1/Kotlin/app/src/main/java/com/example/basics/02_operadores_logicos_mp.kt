package com.example.basics

fun main() {
    println("OPERADORES LÓGICOS EN MI CEMENTERIO")

    val hora: Int = 22
    val tieneLinterna: Boolean = false
    val permisoEspecial: Boolean = true

    // Un visitante solo puede entrar si es después de las 6 p.m., tiene linterna y permiso de ingresar al cenmenterio
    val puedeEntrar = hora >= 18 && tieneLinterna && permisoEspecial

    // Necesita ayuda si no tiene linterna o si no tiene permiso de ingresar al cementerio
    val necesitaAyuda = !tieneLinterna || !permisoEspecial

    println("¿Puede entrar al cementerio?: $puedeEntrar")
    println("¿Necesita ayuda del guardia?: $necesitaAyuda")

    println("\nEvaluación Detallada:")
    println("Hora actual: $hora h")
    println("Tiene linterna: $tieneLinterna")
    println("Permiso especial: $permisoEspecial")
}
