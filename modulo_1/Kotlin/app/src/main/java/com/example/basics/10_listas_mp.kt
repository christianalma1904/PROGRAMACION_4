package com.example.cementerio

fun main(){
    println("LISTAS EN MI CEMENTERIO: Tipos de Entierros")

    // Lista Inmutable
    // Registro de los tipos de servicios funerarios ofrecidos
    val tiposEntierros: List<String> = listOf("Sepultura", "Cremación")
    println("Servicios Funerarios (Inmutable): ${tiposEntierros}")

    // Lista Mutable
    // Registro de las parcelas disponibles en el sector A
    val parcelasDisponibles: MutableList<Int> = mutableListOf(101, 102, 103)
    println("\nParcelas Iniciales (Mutable): ${parcelasDisponibles}")

    // Agregar una nueva parcela
    parcelasDisponibles.add(104)
    println("Parcela 104 añadida: ${parcelasDisponibles}")

    // Eliminar la primera parcela (vendida)
    parcelasDisponibles.removeAt(0)
    println("Parcela 101 eliminada (vendida): ${parcelasDisponibles}")

    println("\nRecorrido de Parcelas Disponibles:")
    for(parcela in parcelasDisponibles) println("Disponible: P-$parcela")

    println("\nOperaciones con Lista Mutable de Visitantes")

    // Lista mutable para registrar a los visitantes
    val visitantes = mutableListOf("Elena", "Ramón")

    // Agregar un visitante
    visitantes.add("Sofía")

    // Agregar otro visitante con el operador +=
    visitantes += "Javier"

    // Insertar un visitante en una posición específica (índice 1)
    visitantes.add(1, "Ana")
    println("Visitantes al Mediodía: ${visitantes}")

    // Eliminar el primer visitante (ya se fue)
    visitantes.removeAt(0)
    println("Visitantes después de irse 'Elena': ${visitantes}")

    // Reemplazar un nombre por error de tipeo
    visitantes[0] = "Lucas"
    println("Visitantes (cambio 'Ana' por 'Lucas'): ${visitantes}")

    // Limpiar el registro al final del día
    visitantes.clear()
    println("Registro del día limpio: ${visitantes.isEmpty()}") // Verifica si está vacía (true)

    println("\nBúsqueda en Lista Mutable de Nombres de Difuntos")
    val nombresDifuntos = mutableListOf("Juana", "Luis", "Pablo", "Alberto")

    // Encuentra el primer nombre que empieza con 'L'
    println("Primer difunto con 'L': ${nombresDifuntos.find{it.startsWith("L")}}")

    // Encuentra el primer nombre con más de 5 letras
    println("Primer nombre de más de 5 letras: ${nombresDifuntos.firstOrNull{it.length>5}}")

    // ¿Hay algún nombre que contenga la letra 'J'?
    println("¿Hay difuntos con 'J'?: ${nombresDifuntos.any{it.contains('J')}}")

    // ¿No hay nombres que sean 'X'?
    println("¿No hay difuntos llamados 'X'?: ${nombresDifuntos.none{it == "X"}}")


    println("\nOrdenamiento en Lista Mutable de Profundidades en cm")
    val profundidadesEntierros = mutableListOf(180, 100, 250, 100, 200, 180)

    // Ordena de forma ascendente
    println("Profundidades Ordenadas (Ascendente): ${profundidadesEntierros.sorted()}")

    // Ordena de forma descendente
    println("Profundidades Ordenadas (Descendente): ${profundidadesEntierros.sortedDescending()}")

    // Elimina duplicados, manteniendo el orden de aparición
    println("Profundidades Únicas: ${profundidadesEntierros.distinct()}")
}