package com.example.systech_coffeemiau.data.repositories

import android.app.Application
import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.domain.repositories.IProductRepository
import com.google.gson.Gson
import javax.inject.Inject

class JsonRepositoryImpl(
    private val application: Application
): IProductRepository {
    private val gson = Gson()
    override suspend fun getProductList(): List<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun getProduct(id: Long): Product {
        val jsonInputStream = application.assets.open("producto$id.json")
        return gson.fromJson(jsonInputStream.reader(), Product::class.java)
    }
}