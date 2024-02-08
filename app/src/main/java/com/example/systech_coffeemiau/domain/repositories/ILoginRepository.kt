package com.example.systech_coffeemiau.domain.repositories

interface ILoginRepository {
    suspend fun login(username: String, password: String)
}