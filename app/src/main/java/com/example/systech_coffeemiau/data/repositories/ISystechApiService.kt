package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.data.sources.dto.ProductoDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ISystechApiService {
    @GET("producto/{id}/")
    suspend fun getProducto(@Path("id") id: Int): ProductoDTO
}