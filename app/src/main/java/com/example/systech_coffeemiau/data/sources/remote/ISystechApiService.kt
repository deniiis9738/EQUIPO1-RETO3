package com.example.systech_coffeemiau.data.sources.remote

import com.example.systech_coffeemiau.data.sources.remote.dto.GatoDTO
import com.example.systech_coffeemiau.data.sources.remote.dto.ProductoDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ISystechApiService {
    @GET("/api/productos/{id}")
    suspend fun getProducto(@Path("id") id: Long): ProductoDTO

    @GET("/api/gatos/{id}")
    suspend fun getGato(@Path("id") id: Long): GatoDTO
}