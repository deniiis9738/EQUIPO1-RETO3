package com.example.systech_coffeemiau.data.sources.dto

import com.google.gson.annotations.SerializedName

data class ProductoDTO(
    @SerializedName("id_producto")
    val id_producto: Long,

    @SerializedName("nombre")
    val nombre: String,

    @SerializedName("precio")
    val precio: Double
)
