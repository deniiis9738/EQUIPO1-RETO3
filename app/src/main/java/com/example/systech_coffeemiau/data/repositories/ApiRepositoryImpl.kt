package com.example.systech_coffeemiau.data.repositories

import android.util.Log
import com.example.systech_coffeemiau.auth.ILocalStorage
import com.example.systech_coffeemiau.data.sources.dto.LoginDTO
import com.example.systech_coffeemiau.data.sources.dto.TokenDTO
import com.example.systech_coffeemiau.data.sources.dto.UsuarioDTO
import com.example.systech_coffeemiau.domain.models.GatoModel
import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.domain.models.Usuario
import com.example.systech_coffeemiau.domain.repositories.ISystechGatoRepository
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import com.example.systech_coffeemiau.mappers.dtotomodel.mapGatoDTOToModel
import com.example.systech_coffeemiau.mappers.dtotomodel.mapProductoDTOToModel
import com.example.systech_coffeemiau.mappers.dtotomodel.mapUsuarioDTOToModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val iSystechApiService: ISystechApiService,
    private val iLocalStorage: ILocalStorage
): ISystechSolutionsRepository, ISystechGatoRepository {
    override suspend fun getProductList(): List<Product> {
        val products = iSystechApiService.getProducts()
        return products.map { mapProductoDTOToModel(it) }
    }

    override suspend fun getProducto(id: Long): Product {
        val productoDTO = iSystechApiService.getProducto(id)
        return mapProductoDTOToModel(productoDTO)
    }

    override suspend fun getGatoList(): List<GatoModel> {
        val gatos = iSystechApiService.getGatoList()
        return gatos.map { mapGatoDTOToModel(it) }
    }

    override suspend fun getGato(idGato: Long): GatoModel {
        val gato = iSystechApiService.getGato(idGato)
        return mapGatoDTOToModel(gato)
    }

    @OptIn(DelicateCoroutinesApi::class)
    override suspend fun login(username: String, password: String) {
        GlobalScope.launch {
            val loginDTO = LoginDTO(
                username,
                password
            )
            val response = iSystechApiService.login(loginDTO)
            if(response.isSuccessful) {
                val token = response.body()
                Log.d("Token", "token: ${token!!.token}")
                iLocalStorage.saveToken(token.token)
                Log.d("TokenAlmacenamiento", "token desde el almacenamiento: ${iLocalStorage.getToken()}")
            } else {
                Log.d("Fallo Token", "No ha podido coger token")
            }
        }
    }

    override suspend fun getUserDates(username: String): Usuario {
        try {
            val usuarioDTO = iSystechApiService.getUserDates(username)
            return mapUsuarioDTOToModel(usuarioDTO)
        } catch (e: Exception) {
            return Usuario(0, "", "", "", "")
        }
    }

    override suspend fun getActualUserDates(tokenDTO: TokenDTO): Usuario {
        try {
            val usuarioDTO = iSystechApiService.getActualUserDates(tokenDTO)
            return mapUsuarioDTOToModel(usuarioDTO)
        } catch (e: Exception) {
            return Usuario(0, "", "", "", "")
        }
    }
}