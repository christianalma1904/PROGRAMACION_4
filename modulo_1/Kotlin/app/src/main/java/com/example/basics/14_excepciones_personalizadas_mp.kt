package com.example.cementerio.exhumacion

class DocumentacionIncompletaException(message: String) : Exception(message)
class PlazoLegalIncumplidoException(message: String) : Exception(message)

fun realizarExhumacion(añosDesdeInhumacion: Int, documentacionCompleta: Boolean): String {

    val PLAZO_MINIMO_LEGAL = 5

    return try {
        when {
            !documentacionCompleta -> throw DocumentacionIncompletaException("Documentación legal incompleta.")

            añosDesdeInhumacion < PLAZO_MINIMO_LEGAL -> throw PlazoLegalIncumplidoException(
                "El plazo mínimo de $PLAZO_MINIMO_LEGAL años no se ha cumplido. Años: ${añosDesdeInhumacion}"
            )

            else -> { "EXHUMACIÓN APROBADA. Proceder con el traslado de restos." }
        }
    } catch (e: DocumentacionIncompletaException) {
        // Manejo de la primera excepción personalizada
        "ERROR: ${e.message}. Se requiere contactar al apoderado legal."
    } catch (e: PlazoLegalIncumplidoException) {
        // Manejo de la segunda excepción personalizada
        "ERROR: ${e.message}. Exhumación denegada. Espere el plazo legal."
    } catch (e: Exception) {
        // Manejo de cualquier otro error inesperado
        "ERROR INESPERADO: ${e.message}"
    } finally {
        println("-> Notificación de estado de solicitud enviada a la oficina.")
    }
}

fun main() {
    println("Caso 1: Documentación Incompleta")
    println(realizarExhumacion(añosDesdeInhumacion = 10, documentacionCompleta = false))

    println("\nCaso 2: Plazo No Cumplido")
    println(realizarExhumacion(añosDesdeInhumacion = 3, documentacionCompleta = true))

    println("\nCaso 3: Aprobación")
    println(realizarExhumacion(añosDesdeInhumacion = 8, documentacionCompleta = true))
}