package com.example.systech_coffeemiau.data.repositories

import com.example.systech_coffeemiau.data.sources.dto.LoginDTO
import com.example.systech_coffeemiau.data.sources.dto.TokenDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginService {
    @POST("login")
    suspend fun login(@Body loginDTO: LoginDTO): Response<TokenDTO>
}