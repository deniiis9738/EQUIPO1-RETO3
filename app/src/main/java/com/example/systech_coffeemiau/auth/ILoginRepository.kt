package com.example.systech_coffeemiau.auth

interface ILoginRepository {
    suspend fun login(username: String, password: String)
}