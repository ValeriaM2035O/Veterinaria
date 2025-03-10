
class ConsultaMedica (
    val mascota: Mascotas,
    val diagnostico: String,
    val costoConsulta: Double,
    val medicacion: Boolean
) {


    fun calcularCosto (costoConsulta: Double): Double {
        return if (medicacion)
            costoConsulta * 1.15
                    else costoConsulta
    }
}
