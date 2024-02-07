package com.example.systech_coffeemiau.data.sources.dto

import com.google.gson.annotations.SerializedName

data class LinPedidoDTO(
    @SerializedName("id_lin_pedido")
    val id_lin_pedido: Long,

    @SerializedName("id_pedido")
    val id_pedido: Long,

    @SerializedName("id_producto")
    val id_producto: Long,

    @SerializedName("cantidad")
    val cantidad: Int
)