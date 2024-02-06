package com.example.systech_coffeemiau.data.sources.dto

import com.google.gson.annotations.SerializedName

data class ProductoDTO(
    @SerializedName("id_producto")
    val id: Long,

    @SerializedName("foto_producto")
    val picture: String,

    @SerializedName("nombre")
    val nombre: String,

    @SerializedName("descripcion")
    val description: String,

    @SerializedName("precio")
    val precio: Double,
)
