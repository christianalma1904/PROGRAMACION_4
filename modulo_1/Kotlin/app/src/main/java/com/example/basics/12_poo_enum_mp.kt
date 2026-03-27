// Defino los diferentes tipos de Ataúd con sus propiedades.
enum class TipoAtaud(val material: String, val precioBase: Int) {

    MADERA(material = "Roble", precioBase = 1500) {
        override fun describir() = "Ataúd clásico de roble, sencillo y robusto."
    },
    METALICO(material = "Acero", precioBase = 3000) {
        override fun describir() = "Ataúd metálico sellado, ideal para mausoleos."
    },
    LUJO(material = "Caoba", precioBase = 8000) {
        override fun describir() = "Ataúd de caoba con acabados en bronce, de la más alta gama."
    };

    abstract fun describir(): String
        companion object {
        fun porMaterial(material: String) = values().find { it.material.equals(material, ignoreCase = true) }
    }
}

// Clase Difunto que contiene una referencia al TipoAtaud.
class Difunto(val nombreCompleto: String, val tipoAtaud: TipoAtaud) {

    fun preparacion() = "El cuerpo de ${nombreCompleto} será dispuesto en un ataúd de ${tipoAtaud.material}."

    fun infoAtaud() = "Ataúd: ${tipoAtaud.describir()} - Precio base: ${tipoAtaud.precioBase}€"
}

fun main() {
    // 1. Creación de un difunto con un ataúd de lujo
    val difuntoRico = Difunto(
        nombreCompleto = "Elsa P. Ulcro",
        tipoAtaud = TipoAtaud.LUJO
    )
    println("Difunto Lujo")
    println(difuntoRico.preparacion())
    println(difuntoRico.infoAtaud())

    println("\n" + "Difunto Sencillo")
    // 2. Creación de otro difunto con un ataúd estándar (Madera)
    val difuntoStandard = Difunto(
        nombreCompleto = "Pepe Gotera",
        tipoAtaud = TipoAtaud.MADERA
    )
    println(difuntoStandard.preparacion())
    println(difuntoStandard.infoAtaud())

    println("\n" + "Búsqueda")
    val ataúdBuscado = TipoAtaud.porMaterial("Acero")
    if (ataúdBuscado != null) {
        println("Se encontró el tipo de ataúd: ${ataúdBuscado.name} - ${ataúdBuscado.describir()}")
    }
}