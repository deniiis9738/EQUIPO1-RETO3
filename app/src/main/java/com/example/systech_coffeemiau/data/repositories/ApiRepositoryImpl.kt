package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import com.example.systech_coffeemiau.mappers.dtotomodel.mapProductoDTOToModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val iSystechApiService: ISystechApiService
): ISystechSolutionsRepository {
    override suspend fun getProductList(): List<Product> {
        val products = iSystechApiService.getProducts()
        return products.map { mapProductoDTOToModel(it) }
    }

    override suspend fun getProducto(id: Long): Product {
        val productoDTO = iSystechApiService.getProducto(id)
        return mapProductoDTOToModel(productoDTO)
    }
}