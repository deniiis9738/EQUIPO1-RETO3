package com.example.systech_coffeemiau.data.sources.local

import android.app.Application
import com.example.systech_coffeemiau.domain.models.Product
import com.google.gson.Gson
import javax.inject.Inject

class LocalProductoDataSource @Inject constructor(
    private val application: Application
) {
    private val gson = Gson()

    fun getProduct(id: Long): Product {
        val jsonInputStream = application.assets.open("producto$id.json")
        return gson.fromJson(jsonInputStream.reader(), Product::class.java)
    }
}