package com.example.systech_coffeemiau.auth

import android.content.SharedPreferences

const val TOKEN_KEY = "token"

class SharedPreferencesILocalStorage(val sharedPreferences: SharedPreferences): ILocalStorage {
    override fun saveToken(token: String) {
        sharedPreferences.edit()
            .putString(TOKEN_KEY, token)
            .apply()
    }

    override fun getToken(): String {
        return sharedPreferences
            .getString(TOKEN_KEY, "")!!
    }

    override fun isAuthenticated(): Boolean {
        return getToken().isNotEmpty()
    }

    override fun clearToken() {
        sharedPreferences.edit()
            .remove(TOKEN_KEY)
            .apply()
    }

}