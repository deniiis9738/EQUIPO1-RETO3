package com.example.systech_coffeemiau.domain.repositories

import com.example.systech_coffeemiau.domain.models.ProductoModel

interface ISystechSolutionsReposiotory {
    suspend fun getProducto(id: Int): ProductoModel
}