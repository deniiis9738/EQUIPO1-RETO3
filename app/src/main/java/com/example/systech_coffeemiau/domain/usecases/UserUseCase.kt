package com.example.systech_coffeemiau.domain.usecases

import com.example.systech_coffeemiau.data.sources.dto.TokenDTO
import com.example.systech_coffeemiau.domain.models.Usuario
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val systechSolutionsRepository: ISystechSolutionsRepository
) {
    suspend fun getUserDates(username:String):Usuario {
        return systechSolutionsRepository.getUserDates(username)
    }

    suspend fun getActualUserDates(tokenDTO: TokenDTO): Usuario {
        return systechSolutionsRepository.getActualUserDates(tokenDTO)
    }
}