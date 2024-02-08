package com.example.systech_coffeemiau.data.sources.dto

import com.google.gson.annotations.SerializedName

data class UsuarioDTO(

    @SerializedName("id")
    val id: Long,

    @SerializedName("username")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("telefono")
    val telefono: String,

    @SerializedName("rol")
    val rol: String
)