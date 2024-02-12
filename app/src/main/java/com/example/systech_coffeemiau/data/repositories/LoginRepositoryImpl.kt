package com.example.systech_coffeemiau.data.repositories

import android.util.Log
import com.example.systech_coffeemiau.auth.ILocalStorage
import com.example.systech_coffeemiau.data.sources.dto.LoginDTO
import com.example.systech_coffeemiau.domain.repositories.ILoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val iLoginService: ILoginService,
    private val iLocalStorage: ILocalStorage
): ILoginRepository {
    override suspend fun login(username: String, password: String) {
        val loginDTO = LoginDTO(
            username,
            password
        )
        try {
            val response = iLoginService.login(loginDTO)
            if(response.isSuccessful) {
                val token = response.body()
                Log.d("Token", "token: ${token!!.token}")
                iLocalStorage.saveToken(token.token)
                Log.d("TokenAlmacenamiento", "token desde el almacenamiento: ${iLocalStorage.getToken()}")
            } else {
                Log.d("Fallo Token", "No ha podido coger token")
            }
        } catch (e: Exception) {
            Log.d("Fallo Response", "No hay response")
        }
    }
}