package com.example.systech_coffeemiau.auth

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val iLocalStorage: ILocalStorage): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val token = iLocalStorage.getToken()
        if (token.isNotEmpty()) {
            request.addHeader("Authorization", "Bearer $token")
        }
        return chain.proceed(request.build())
    }

}