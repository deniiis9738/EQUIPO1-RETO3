package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import javax.inject.Inject

class FallBackRepositoryImpl @Inject constructor(
    private val apiRepositoryImpl: ApiRepositoryImpl,
    private val jsonRepositoryImpl: JsonRepositoryImpl
): ISystechSolutionsRepository {
    override suspend fun getProductList(): List<Product> {
        return try {
            apiRepositoryImpl.getProductList()
        } catch (e: Exception) {
            apiRepositoryImpl.getProductList()
        }
    }

    override suspend fun getProducto(id: Long): Product {
        return try {
            apiRepositoryImpl.getProducto(id)
        } catch (e: Exception) {
            apiRepositoryImpl.getProducto(id)
        }
    }
}