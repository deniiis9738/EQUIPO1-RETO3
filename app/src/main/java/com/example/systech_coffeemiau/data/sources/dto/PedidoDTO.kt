package com.example.systech_coffeemiau.data.sources.dto

import com.google.gson.annotations.SerializedName

data class PedidoDTO(
    @SerializedName("id_pedido")
    val id_pedido: Long,

    @SerializedName("fecha")
    val fecha: String,

    @SerializedName("id_usuario")
    val id_usuario: Long,
)