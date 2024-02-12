package com.example.systech_coffeemiau.data.repositories

import android.app.Application
import com.example.systech_coffeemiau.data.sources.dto.TokenDTO
import com.example.systech_coffeemiau.domain.models.GatoModel
import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.domain.models.Usuario
import com.example.systech_coffeemiau.domain.repositories.ISystechGatoRepository
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import com.google.gson.Gson
import javax.inject.Inject

class JsonRepositoryImpl @Inject constructor(
    private val application: Application
): ISystechSolutionsRepository, ISystechGatoRepository {

    private val gson = Gson()
    override suspend fun getProductList(): List<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun getProducto(id: Long): Product {
        val jsonInputStream = application.assets.open("producto$id.json")
        return gson.fromJson(jsonInputStream.reader(), Product::class.java)
    }

    override suspend fun login(username: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getUserDates(username: String): Usuario {
        val jsonInputStream = application.assets.open("usuario$username.json")
        return gson.fromJson(jsonInputStream.reader(), Usuario::class.java)
    }

    override suspend fun getActualUserDates(tokenDTO: TokenDTO): Usuario {
        TODO("Not yet implemented")
    }

    override suspend fun getGato(idGato: Long): GatoModel {
        val gatoLocalData = application.assets.open("gato$idGato.json")
        return gson.fromJson(gatoLocalData.reader(), GatoModel::class.java)
    }

    override suspend fun getGatoList(): List<GatoModel> {
        TODO("Not yet implemented")
    }
}