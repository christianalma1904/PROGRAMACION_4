import java.util.Scanner

fun sumar(a: Double, b: Double): Double {
    return a + b
}

fun restar(a: Double, b: Double): Double {
    return a - b
}

fun multiplicar(a: Double, b: Double): Double {
    return a * b
}

fun dividir(a: Double, b: Double): Double {
    if (b == 0.0) {
        return Double.NaN
    }
    return a / b
}

fun main() {
    val scanner = Scanner(System.`in`)
    var resultado: Double? = null

    println("----- Calculadora Simple en Kotlin -----")

    print("Ingresa el primer número (a): ")
    val num1 = scanner.nextDouble()

    print("Ingresa el segundo número (b): ")
    val num2 = scanner.nextDouble()

    print("Ingresa la operación (+, -, *, /): ")
    val operacion = scanner.next()

    when (operacion) {
        "+" -> resultado = sumar(num1, num2)
        "-" -> resultado = restar(num1, num2)
        "*" -> resultado = multiplicar(num1, num2)
        "/" -> resultado = dividir(num1, num2)
        else -> println("Operación no válida.")
    }

    if (resultado != null) {
        if (resultado.isNaN()) {
            println("Error: ¡No se puede dividir por cero!")
        } else {
            println("El resultado de $num1 $operacion $num2 es: $resultado")
        }
    }
}