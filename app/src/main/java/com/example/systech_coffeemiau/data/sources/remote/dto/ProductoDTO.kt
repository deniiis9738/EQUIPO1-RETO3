package com.example.systech_coffeemiau.data.sources.remote.dto

import com.google.gson.annotations.SerializedName

data class ProductoDTO(
    val id_producto: Long,
    val nombre: String,
    val precio: Double
)
