package com.example.systech_coffeemiau.auth

import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val iLoginService: ILoginService,
    private val iLocalStorage: ILocalStorage
): ILoginRepository {
    @OptIn(DelicateCoroutinesApi::class)
    override suspend fun login(username: String, password: String) {
        GlobalScope.launch {
            val loginDTO = LoginDTO(
                username,
                password
            )
            val response = iLoginService.login(loginDTO)
            if(response.isSuccessful) {
                val token = response.body()
                Log.d("Token", "token: ${token!!.token}")
                iLocalStorage.saveToken(token.token)
                Log.d("TokenAlmacenamiento", "token desde el almacenamiento: ${iLocalStorage.getToken()}")
            } else {
                Log.d("Fallo Token", "No ha podido coger token")
            }
        }
    }
}