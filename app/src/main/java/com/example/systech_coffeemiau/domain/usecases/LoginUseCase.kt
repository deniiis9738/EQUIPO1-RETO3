package com.example.systech_coffeemiau.domain.usecases

import com.example.systech_coffeemiau.auth.ILocalStorage
import com.example.systech_coffeemiau.domain.repositories.ILoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val iLocalStorage: ILocalStorage,
    private val iLoginRepository: ILoginRepository
) {
    suspend fun login(username: String, password: String) {
        return iLoginRepository.login(username, password)
    }

    fun isAtuhenticated(): Boolean {
        return iLocalStorage.isAuthenticated()
    }

    fun clearToken() {
        iLocalStorage.clearToken()
    }

    fun getToken(): String {
        return iLocalStorage.getToken()
    }
}