package com.example.systech_coffeemiau.domain.repositories

import com.example.systech_coffeemiau.domain.models.ProductoModel

interface ISystechSolutionsRepository {
    suspend fun getProducto(id: Long): ProductoModel
}