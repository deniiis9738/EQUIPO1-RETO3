package com.example.systech_coffeemiau.mappers.dtotomodel

import com.example.systech_coffeemiau.data.sources.dto.ProductoDTO
import com.example.systech_coffeemiau.domain.models.ProductoModel

fun mapProductoDTOToModel(productoDTO: ProductoDTO): ProductoModel {
    return ProductoModel(
        id_producto = productoDTO.id_producto,
        nombre = productoDTO.nombre,
        precio = productoDTO.precio
    )
}