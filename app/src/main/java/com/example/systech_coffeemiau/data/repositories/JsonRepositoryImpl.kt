package com.example.systech_coffeemiau.data.repositories

import android.app.Application
import com.example.systech_coffeemiau.domain.models.ProductoModel
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import com.google.gson.Gson
import javax.inject.Inject

class JsonRepositoryImpl @Inject constructor(
    private val application: Application
): ISystechSolutionsRepository {
    private val gson = Gson()
    override suspend fun getProducto(id: Long): ProductoModel {
        val jsonInputStream = application.assets.open("producto$id.json")
        return gson.fromJson(jsonInputStream.reader(), ProductoModel::class.java)
    }
}