package com.example.systech_coffeemiau.domain.models

data class LinPedido(
    val id: Long,
    val pedido: Pedido,
    val product: Product,
    val cantidad: Int
)
