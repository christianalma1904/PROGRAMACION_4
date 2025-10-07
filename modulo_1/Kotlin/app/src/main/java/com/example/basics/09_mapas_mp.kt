package com.example.cementerio

fun main(){
    println("MAPAS EN MI CEMENTERIO: Tumbas y Años de Fallecimiento")

    val añosFallecimiento = mapOf(
        "Tumba-001" to 1985,
        "Tumba-002" to 2010,
        "Tumba-003" to 1950,
        "Tumba-004" to 2022
    )
    println("Años de Fallecimiento: ${añosFallecimiento}")

    println("\nMAPA MUTABLE: Mantenimiento de Tumbas")

    val diasSinMantenimiento = mutableMapOf<String, Int>()
    diasSinMantenimiento["Tumba-001"] = 30
    diasSinMantenimiento["Tumba-002"] = 15
    diasSinMantenimiento.put("Tumba-005", 45) // Agregamos una nueva tumba

    println("Días sin Mantenimiento: ${diasSinMantenimiento}")

    for ((tumba, anio) in añosFallecimiento){
        println("$tumba data del año $anio")
    }

    println("\nTipos de Flores y Materiales")

    // Flores comunes en el cementerio
    val floresComunes = setOf("Rosas", "Lirios", "Crisantemos", "Margaritas")
    println("Flores Comunes: ${floresComunes}")

    // Materiales de lápidas en el sector antiguo
    val materialesAntiguos = setOf("Mármol", "Granito", "Lirios", "Piedra")
    println("Materiales Antiguos: ${materialesAntiguos}")

    println("\nOperaciones de Conjuntos")

    // Intersección: Elementos en ambos conjuntos (Flores que también son materiales por error/otro)
    val interseccion = floresComunes intersect materialesAntiguos
    // Unión: Todos los elementos, sin duplicados
    val union = floresComunes union materialesAntiguos
    // Diferencia: Elementos en el primer conjunto que NO están en el segundo
    val diferenciaFloresUnicas = floresComunes - materialesAntiguos

    println("Flores que Coinciden en Ambos (error/similitud): ${interseccion}")
    println("Inventario Completo (Flores + Materiales): ${union}")
    println("Flores Únicas del Inventario (No Material): ${diferenciaFloresUnicas}")
}