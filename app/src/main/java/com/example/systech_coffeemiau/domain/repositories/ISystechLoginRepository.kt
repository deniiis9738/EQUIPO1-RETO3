package com.example.systech_coffeemiau.domain.repositories

interface ISystechLoginRepository {
    suspend fun login(username: String, password: String)

}