package com.example.systech_coffeemiau.auth

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginService {
    @POST("login")
    suspend fun login(@Body loginDTO: LoginDTO): Response<TokenDTO>
}