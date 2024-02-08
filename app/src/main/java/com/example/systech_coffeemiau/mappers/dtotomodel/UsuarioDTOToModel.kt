package com.example.systech_coffeemiau.mappers.dtotomodel

import com.example.systech_coffeemiau.data.sources.dto.UsuarioDTO
import com.example.systech_coffeemiau.domain.models.Usuario
import retrofit2.Response

fun mapUsuarioDTOToModel(usuarioDTO: Response<UsuarioDTO>): Usuario {
    return Usuario(
        id = usuarioDTO.body()!!.id,
        username = usuarioDTO.body()!!.username,
        email = usuarioDTO.body()!!.email,
        telefono = usuarioDTO.body()!!.telefono,
        rol = usuarioDTO.body()!!.rol
    )
}
