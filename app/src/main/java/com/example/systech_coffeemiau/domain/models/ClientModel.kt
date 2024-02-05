package com.example.systech_coffeemiau.domain.models

data class ClientModel(
    val name: String,
    val age: Int,
    val sign: String,
    val phone: String,
    val email: String,
    val picture: String,
    val adoptedCats: List<GatoModel>
)