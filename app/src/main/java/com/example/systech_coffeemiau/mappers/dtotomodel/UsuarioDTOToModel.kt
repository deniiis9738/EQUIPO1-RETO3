package com.example.systech_coffeemiau.mappers.dtotomodel

import com.example.systech_coffeemiau.data.sources.dto.UsuarioDTO
import com.example.systech_coffeemiau.domain.models.Usuario

fun mapUsuarioDTOToModel(usuarioDTO: UsuarioDTO): Usuario {
    return Usuario(
        id = usuarioDTO.id,
        username = usuarioDTO.username,
        email = usuarioDTO.email,
        telefono = usuarioDTO.telefono,
        rol = usuarioDTO.rol
    )
}
