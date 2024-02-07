package com.example.systech_coffeemiau.domain.usecases

import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.domain.repositories.IProductRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val systechSolutionsRepository: IProductRepository
) {
    suspend fun getProductList(): List<Product> {
        return systechSolutionsRepository.getProductList()
    }
    suspend fun getProducto(id: Long): Product {
        return systechSolutionsRepository.getProduct(id)
    }
}