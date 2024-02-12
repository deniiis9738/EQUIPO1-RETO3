package com.example.systech_coffeemiau.mappers.dtotomodel

import com.example.systech_coffeemiau.data.sources.remote.dto.GatoDTO
import com.example.systech_coffeemiau.domain.models.GatoModel

fun mapGatoDTOToModel(gato: GatoDTO): GatoModel{
    return GatoModel(
        idGato = gato.idGato,
        name = gato.nombre,
        picture = gato.foto,
        color = gato.color,
        race = gato.raza,
        personality = gato.caracter,
        medicalInfo = gato.informacionMedica,
        conditions = gato.enfermedades,
        castrated = gato.castrado
    )
}