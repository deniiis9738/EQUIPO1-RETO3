package com.example.systech_coffeemiau.domain.models

data class Product(
    val id: Long,
    val picture: String,
    val name: String,
    val description: String,
    val price: Double
)
