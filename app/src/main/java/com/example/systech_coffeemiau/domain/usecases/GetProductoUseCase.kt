package com.example.systech_coffeemiau.domain.usecases

import com.example.systech_coffeemiau.domain.models.ProductoModel
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import javax.inject.Inject

class GetProductoUseCase @Inject constructor(
    private val systechSolutionsRepository: ISystechSolutionsRepository
) {
    suspend fun getProducto(id: Long): ProductoModel {
        return systechSolutionsRepository.getProducto(id)
    }
}