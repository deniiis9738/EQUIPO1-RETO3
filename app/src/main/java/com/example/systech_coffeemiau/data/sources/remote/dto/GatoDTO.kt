package com.example.systech_coffeemiau.data.sources.remote.dto

data class GatoDTO(
    val idGato: Long,
    val nombre: String,
    val foto: String,
    val color: String,
    val raza: String,
    val caracter: String,
    val informacionMedica: String,
    val enfermedades: String,
    val castrado: Boolean
)