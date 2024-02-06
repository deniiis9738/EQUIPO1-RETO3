package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.data.sources.dto.ProductoDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ISystechApiService {
    @GET("/api/productos")
    suspend fun getProducts(): ArrayList<ProductoDTO>

    @GET("/api/productos/{id}")
    suspend fun getProducto(@Path("id") id: Long): ProductoDTO
}