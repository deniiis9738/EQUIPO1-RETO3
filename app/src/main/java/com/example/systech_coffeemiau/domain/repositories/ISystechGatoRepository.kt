package com.example.systech_coffeemiau.domain.repositories

import com.example.systech_coffeemiau.domain.models.GatoModel

interface ISystechGatoRepository {

    suspend fun getGato(idGato: Long): GatoModel

    suspend fun getGatoList(): List<GatoModel>
}