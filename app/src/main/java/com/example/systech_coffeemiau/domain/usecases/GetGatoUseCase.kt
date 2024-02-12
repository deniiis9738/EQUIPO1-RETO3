package com.example.systech_coffeemiau.domain.usecases

import com.example.systech_coffeemiau.data.repositories.FallBackRepositoryImpl
import com.example.systech_coffeemiau.domain.models.GatoModel
import javax.inject.Inject

class GetGatoUseCase @Inject constructor(
    private val fallBackRepositoryImpl: FallBackRepositoryImpl
){
    suspend fun getGatoList(): List<GatoModel> {
        return fallBackRepositoryImpl.getGatoList()
    }

    suspend fun getGato(gato: GatoModel): GatoModel {
        return fallBackRepositoryImpl.getGato(gato.idGato)
    }
}