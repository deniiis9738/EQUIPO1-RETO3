package com.example.systech_coffeemiau.auth

import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val systechSolutionsRepository: ISystechSolutionsRepository
) {
    suspend fun login(username: String, password: String) {
        return systechSolutionsRepository.login(username, password)
    }
}