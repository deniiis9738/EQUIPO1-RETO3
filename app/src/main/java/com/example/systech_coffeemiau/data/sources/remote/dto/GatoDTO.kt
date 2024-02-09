package com.example.systech_coffeemiau.data.sources.remote.dto

import com.google.gson.annotations.SerializedName

data class GatoDTO(
    @SerializedName("idGato")
    val idGato: Long,

    @SerializedName("nombre")
    val nombre: String,

    @SerializedName("foto")
    val foto: String,

    @SerializedName("color")
    val color: String,

    @SerializedName("raza")
    val raza: String,

    @SerializedName("caracter")
    val caracter: String,

    @SerializedName("informacionMedica")
    val informacionMedica: String,

    @SerializedName("enfermedades")
    val enfermedades: String,

    @SerializedName("castrado")
    val castrado: Boolean
)