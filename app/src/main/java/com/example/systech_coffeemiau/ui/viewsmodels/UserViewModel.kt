package com.example.systech_coffeemiau.ui.viewsmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.systech_coffeemiau.domain.usecases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class UserViewModel @Inject constructor(private val userUseCase: UserUseCase): ViewModel() {
    private var _idUsuario = MutableLiveData<Long>()
    val idUsuario: LiveData<Long> = _idUsuario

    private var _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private var _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private var _telefono = MutableLiveData<String>()
    val telefono: LiveData<String> = _telefono

    private var _rol = MutableLiveData<String>()
    val rol: LiveData<String> = _rol

    fun getId(id: Long) {
        _idUsuario.value = id
    }

    fun getUsername(username: String) {
        _username.value = username
    }

    fun getEmail(email: String) {
        _email.value = email
    }

    fun getTelefono(telefono: String) {
        _telefono.value = telefono
    }

    fun getRol(rol: String) {
        _rol.value = rol
    }

}