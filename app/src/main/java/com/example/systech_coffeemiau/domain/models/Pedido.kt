package com.example.systech_coffeemiau.domain.models

import java.util.Date

data class Pedido(
    val id: Long,
    val fecha: Date,
    val usuario: Usuario,
    val linPedidos: List<LinPedido>
)
