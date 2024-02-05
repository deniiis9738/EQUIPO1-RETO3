package com.example.systech_coffeemiau.data.sources.remote.dto

import java.time.LocalDate

data class GatoAdoptadoDTO(
    val idGato: Long,
    val foto: String,
    val color: String,
    val raza: String,
    val caracter: String,
    val informacionMedica: String,
    val enfermedades: String,
    val castrado: Boolean,
    val idPropietario: Long,
    val nombre_propietario: String,
    val fechaAdopcion: LocalDate
)