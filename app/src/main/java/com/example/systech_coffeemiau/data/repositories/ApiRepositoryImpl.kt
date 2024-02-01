package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.domain.models.ProductoModel
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsReposiotory
import com.example.systech_coffeemiau.mappers.dtotomodel.mapProductoDTOToModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    val iSystechApiService: ISystechApiService
): ISystechSolutionsReposiotory {
    override suspend fun getProducto(id: Int): ProductoModel {
        val productoDTO = iSystechApiService.getProducto(id)
        return mapProductoDTOToModel(productoDTO)
    }


}