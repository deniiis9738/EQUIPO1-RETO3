package com.example.systech_coffeemiau.auth

import com.google.gson.annotations.SerializedName

data class TokenDTO(
    @SerializedName("token")
    val token: String
)
