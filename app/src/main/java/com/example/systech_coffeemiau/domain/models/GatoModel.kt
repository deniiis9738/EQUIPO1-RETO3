package com.example.systech_coffeemiau.domain.models

data class GatoModel (
    val idGato: Long,
    val name: String,
    val picture: String,
    val color: String,
    val race: String,
    val personality: String,
    val medicalInfo: String,
    val conditions: String,
    val castrated: Boolean
)