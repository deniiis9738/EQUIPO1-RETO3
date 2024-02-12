package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.data.sources.dto.LoginDTO
import com.example.systech_coffeemiau.data.sources.dto.ProductoDTO
import com.example.systech_coffeemiau.data.sources.dto.TokenDTO
import com.example.systech_coffeemiau.data.sources.dto.UsuarioDTO
import com.example.systech_coffeemiau.data.sources.remote.dto.GatoDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ISystechApiService {

    @POST("login")
    suspend fun login(@Body loginDTO: LoginDTO): Response<TokenDTO>

    @GET("/api/usuarios/username/{username}")
    suspend fun getUserDates(@Path("username")username:String): Response<UsuarioDTO>

    @POST("/api/usuarios/me")
    suspend fun getActualUserDates(@Body tokenDTO: TokenDTO): Response<UsuarioDTO>

    @GET("/api/productos")
    suspend fun getProducts(): List<ProductoDTO>

    @GET("/api/productos/{id}")
    suspend fun getProducto(@Path("id") id: Long): ProductoDTO

    @GET("/api/gatos")
    suspend fun getGatoList(): List<GatoDTO>

    @GET("/api/gatos/noAdoptados/{idGato}")
    suspend fun getGato(@Path("idGato") idGato: Long): GatoDTO
}