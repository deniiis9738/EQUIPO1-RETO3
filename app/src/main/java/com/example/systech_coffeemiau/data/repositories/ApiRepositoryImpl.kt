package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.data.sources.remote.ISystechApiService
import com.example.systech_coffeemiau.domain.models.ProductoModel
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import com.example.systech_coffeemiau.mappers.dtotomodel.mapProductoDTOToModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    val iSystechApiService: ISystechApiService
): ISystechSolutionsRepository {
    override suspend fun getProducto(id: Long): ProductoModel {
        val productoDTO = iSystechApiService.getProducto(id)
        return mapProductoDTOToModel(productoDTO)
    }
}