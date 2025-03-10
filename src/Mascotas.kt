open class Mascotas (

    var nombre: String,
    var especie: String,
    var edad: Int,
    var peso: Double
) {
    fun actualizarPeso(nuevoPeso: Double) {
        peso = nuevoPeso
    }

    fun incrementarEdad() {
        edad++
    }

    fun describirMascota(): String {
        return "Mascota (nombre='$nombre', especie='$especie', edad=$edad, peso=$peso)"
    }
}