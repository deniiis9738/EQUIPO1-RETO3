package com.example.systech_coffeemiau.domain.usecases

import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import javax.inject.Inject

class ProductoUseCase @Inject constructor(
    private val systechSolutionsRepository: ISystechSolutionsRepository
) {
    suspend fun getProductList(): List<Product> {
        return systechSolutionsRepository.getProductList()
    }
    suspend fun getProducto(id: Long): Product {
        return systechSolutionsRepository.getProducto(id)
    }
}