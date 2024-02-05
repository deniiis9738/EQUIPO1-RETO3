package com.example.systech_coffeemiau.domain.models

data class GatoModel (
    val name: String,
    val picture: String,
    val age: Int,
    val race: String,
    val shelter: String,
    val personality: String,
    val medicalInfo: String,
    val adoptionInfo: String,
    val adopter: ClientModel
)