package com.example.systech_coffeemiau.auth

import com.google.gson.annotations.SerializedName

data class LoginDTO(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)
