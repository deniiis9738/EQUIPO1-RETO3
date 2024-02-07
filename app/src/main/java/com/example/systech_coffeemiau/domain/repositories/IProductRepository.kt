package com.example.systech_coffeemiau.domain.repositories

import com.example.systech_coffeemiau.domain.models.Product

interface IProductRepository {
    suspend fun getProductList(): List<Product>
    suspend fun getProduct(id: Long): Product
}