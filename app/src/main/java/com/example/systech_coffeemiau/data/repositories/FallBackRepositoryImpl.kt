package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.domain.models.ProductoModel
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import javax.inject.Inject

class FallBackRepositoryImpl @Inject constructor(
    val apiRepositoryImpl: ApiRepositoryImpl,
    val jsonRepositoryImpl: JsonRepositoryImpl
): ISystechSolutionsRepository {
    override suspend fun getProducto(id: Long): ProductoModel {
        return try {
            apiRepositoryImpl.getProducto(id)
        } catch (e: Exception) {
            return apiRepositoryImpl.getProducto(id)
        }
    }
}