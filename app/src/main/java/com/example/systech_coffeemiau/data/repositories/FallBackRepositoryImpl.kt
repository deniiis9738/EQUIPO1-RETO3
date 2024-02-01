package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.domain.models.ProductoModel
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsReposiotory
import javax.inject.Inject

class FallBackRepositoryImpl @Inject constructor(
    val apiRepositoryImpl: ApiRepositoryImpl
): ISystechSolutionsReposiotory {
    override suspend fun getProducto(id: Int): ProductoModel {
        return try {
            apiRepositoryImpl.getProducto(id)
        } catch (e: Exception) {
            return apiRepositoryImpl.getProducto(id)
        }
    }
}