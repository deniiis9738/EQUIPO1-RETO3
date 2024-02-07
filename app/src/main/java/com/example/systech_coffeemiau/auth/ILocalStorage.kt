package com.example.systech_coffeemiau.auth

interface ILocalStorage {
    fun saveToken(token: String)
    fun getToken(): String
    fun isAuthenticated(): Boolean
    fun clearToken()
}