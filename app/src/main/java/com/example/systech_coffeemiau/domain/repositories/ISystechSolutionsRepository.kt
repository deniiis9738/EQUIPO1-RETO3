package com.example.systech_coffeemiau.domain.repositories

import com.example.systech_coffeemiau.data.sources.dto.TokenDTO
import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.domain.models.Usuario

interface ISystechSolutionsRepository {
    suspend fun getProductList(): List<Product>
    suspend fun getProducto(id: Long): Product
    suspend fun login(username: String, password: String)
    suspend fun getUserDates(username: String):Usuario
    suspend fun getActualUserDates(tokenDTO: TokenDTO): Usuario
}