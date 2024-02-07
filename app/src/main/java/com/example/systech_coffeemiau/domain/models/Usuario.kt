package com.example.systech_coffeemiau.domain.models

data class Usuario (
    val id: Long,
    val username: String,
    val email: String,
    val telefono: String,
    val rol: String
)