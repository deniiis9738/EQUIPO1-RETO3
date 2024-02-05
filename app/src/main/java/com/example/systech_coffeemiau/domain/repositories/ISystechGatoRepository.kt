package com.example.systech_coffeemiau.domain.repositories

import com.example.systech_coffeemiau.domain.models.GatoModel

interface ISystechGatoRepository {

    suspend fun getGato(): GatoModel

    suspend fun getGatosAdoptados(): List<GatoModel>
}