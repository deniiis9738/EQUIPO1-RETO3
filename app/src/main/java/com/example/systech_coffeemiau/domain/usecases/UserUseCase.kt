package com.example.systech_coffeemiau.domain.usecases

import com.example.systech_coffeemiau.domain.models.Usuario
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val systechSolutionsRepository: ISystechSolutionsRepository
) {
    suspend fun getUserDates(id:Long):Usuario {
        return systechSolutionsRepository.getUserDates(id)
    }
}