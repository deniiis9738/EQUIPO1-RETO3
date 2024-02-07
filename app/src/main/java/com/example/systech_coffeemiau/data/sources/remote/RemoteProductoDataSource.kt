package com.example.systech_coffeemiau.data.sources.remote

import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.mappers.dtotomodel.mapProductoDTOToModel
import javax.inject.Inject

class RemoteProductoDataSource @Inject constructor(
    private val apiService: ISystechApiService
) {
    suspend fun getProductListFromApi(): List<Product> {
        val products = apiService.getProducts()
        return products.map { mapProductoDTOToModel(it) }
    }

    suspend fun getProductFromApi(id: Long): Product {
        val productoDTO = apiService.getProducto(id)
        return mapProductoDTOToModel(productoDTO)
    }
}