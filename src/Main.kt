fun main() {

    val lstMascotas = mutableListOf<Mascotas>()
    val lstHistorialConsultas = mutableListOf<ConsultaMedica>()


    do {
        println(
            """
              MENU DE OPCIONES
               1. Agregar nueva mascota
               2. Registrar consulta médica
               3. Mostrar historial de consultas
               4. Modificar datos de una mascota
               5. Describir mascota
               6. Calcular costo total de consultas de una mascota
               7. Salir
              Seleccione opcion:
          """.trimIndent()
        )

        val opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("Ingrese nombre de la mascota:")
                val nombre = readln()
                println("Ingrese especie de la mascota:")
                val especie = readln()
                println("Ingrese edad de la mascota:")
                val edad = readln().toInt()
                println("Ingrese peso de la mascota:")
                val peso = readln().toDouble()
                lstMascotas.add(Mascotas(nombre, especie, edad, peso))
                println("Mascota registrada con éxito.")
            }
            2 -> {
                println("Ingrese nombre de la mascota:")
                val nombre = readln()
                val mascotaEncontrada = lstMascotas.find { mascota -> mascota.nombre == nombre }

                if (mascotaEncontrada != null) {
                    println("Ingrese diagnóstico:")
                    val diagnostico = readln()
                    println("Ingrese costo de la consulta:")
                    val costoConsultaMedica = readln().toDouble()
                    println("¿Incluye medicación? (si/no):")
                    val incluyeMedicacion = readln().lowercase() == "si"

                    val consulta = ConsultaMedica(mascotaEncontrada, diagnostico, costoConsultaMedica, incluyeMedicacion)
                    lstHistorialConsultas.add(consulta)

                    val costoTotal = consulta.calcularCosto(consulta.costoConsulta)
                    println("Consulta registrada. Costo total: \$${costoTotal}")
                } else {
                    println("Mascota no encontrada.")
                }
            }
            3 -> {
                println("Historial de consultas:")
                if (lstHistorialConsultas.isEmpty()) {
                    println("No hay consultas registradas.")
                } else {
                    lstHistorialConsultas.forEach { consulta ->
                        println("Mascota: ${consulta.mascota.nombre}, Diagnóstico: ${consulta.diagnostico}, Costo: \$${consulta.costoConsulta}")
                    }
                }
            }
            4 -> {
                println("Ingrese el nombre de la mascota a modificar:")
                val nombre = readln()
                val mascotaEncontrada = lstMascotas.find { mascota -> mascota.nombre == nombre }
                if (mascotaEncontrada != null) {
                    println(
                        """
                      MENU DE MODIFICACION
                       1. Actualizar peso
                       2. Incrementar edad
                      Seleccione opción:
                  """.trimIndent()
                    )
                    val opcion2 = readln().toInt()
                    when (opcion2) {
                        1 -> {
                            println("Ingrese nuevo peso:")
                            val nuevoPeso = readln().toDouble()
                            mascotaEncontrada.actualizarPeso(nuevoPeso)
                            println("Peso actualizado.")
                        }
                        2 -> {
                            mascotaEncontrada.incrementarEdad()
                            println("Edad incrementada.")
                        }
                        else -> println("Opción no válida")
                    }
                } else {
                    println("Mascota no encontrada")
                }
            }
            5 -> {
                println("Ingrese el nombre de la mascota de la que desea informacion:")
                val nombre = readln()
                val mascotaEncontrada = lstMascotas.find { mascota -> mascota.nombre == nombre }
                if (mascotaEncontrada != null) {
                    println(mascotaEncontrada.describirMascota())
                } else {
                    println("Mascota no encontrada.")
                }
            }
            6 -> {
                println("Ingrese nombre de la mascota para calcular el costo total de consultas:")
                val nombre = readln()
                val consultasMascota = lstHistorialConsultas.filter { consulta -> consulta.mascota.nombre == nombre }
                if (consultasMascota.isNotEmpty()) {
                    val total = consultasMascota.sumOf { consulta -> consulta.calcularCosto(consulta.costoConsulta) }
                    println("Costo total de consultas para $nombre: \$${total}")
                } else {
                    println("No hay consultas registradas para esta mascota")
                }
            }
            7 -> println("Saliendo del programa")
            else -> println("Opción no válida, intente de nuevo")
        }

    } while (opcion != 7)
}