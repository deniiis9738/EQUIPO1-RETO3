package com.example.systech_coffeemiau.domain.repositories

import com.example.systech_coffeemiau.domain.models.Product

interface ISystechSolutionsRepository {
    suspend fun getProductList(): List<Product>
    suspend fun getProducto(id: Long): Product
}