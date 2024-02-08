package com.example.systech_coffeemiau.mappers.dtotomodel

import com.example.systech_coffeemiau.data.sources.dto.ProductoDTO
import com.example.systech_coffeemiau.domain.models.Product

fun mapProductoDTOToModel(productoDTO: ProductoDTO): Product {
    return Product(
        id = productoDTO.id,
        foto_producto = productoDTO.foto_producto,
        name = productoDTO.nombre,
        description = productoDTO.description,
        price = productoDTO.precio,
    )
}