package com.example.systech_coffeemiau.ui.viewsmodels

import android.util.Patterns
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.systech_coffeemiau.data.sources.dto.TokenDTO
import com.example.systech_coffeemiau.domain.models.Usuario
import com.example.systech_coffeemiau.domain.usecases.LoginUseCase
import com.example.systech_coffeemiau.domain.usecases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val userUseCase: UserUseCase
): ViewModel() {
    private var _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private var _username = MutableLiveData("")
    val username: LiveData<String> = _username

    private var _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private var _passwordVisibility = MutableLiveData(false)
    val passwordVisibility: LiveData<Boolean> = _passwordVisibility

    private var _usuario = MutableLiveData<Usuario>()
    val usuario: MutableLiveData<Usuario> = _usuario

    private var _autenticado = MutableLiveData<Boolean>()
    val autenticado: MutableLiveData<Boolean> = _autenticado


    private var _visual = MutableLiveData(VisualTransformation.None)
    val visual: LiveData<VisualTransformation> = _visual

    fun onUsernameChanged(username: String) {
        _username.value = username
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
        validateFields()
    }

    fun togglePasswordVisibility() {
        _passwordVisibility.value = !_passwordVisibility.value!!
    }

    fun validateFields(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(_email.value).matches() && _password.value!!.length >= 6
    }

    fun viewIcon(): ImageVector  {
        return if (_passwordVisibility.value == true) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
    }

    fun changeColor(firstColor: Color, secondColor: Color): Color {
        return if (validateFields()) firstColor else secondColor
    }

    fun login() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                loginUseCase.login(username.value.toString(), password.value.toString())
                if (isAuthenticated()) {
                    autenticado.postValue(true)
                } else {
                    autenticado.postValue(false)
                }
            }
        }
    }

    fun isAuthenticated(): Boolean {
        return loginUseCase.isAtuhenticated()
    }

    fun clearToken() {
        loginUseCase.clearToken()
    }

    fun getToken(): TokenDTO {
        return TokenDTO(
            loginUseCase.getToken()
        )
    }

    fun changeAutenticado(value: Boolean) {
        autenticado.postValue(value)
    }

//    suspend fun getUserDates(username: String):Usuario{
//        val usuario = userUseCase.getUserDates(username)
//        _usuario.postValue(usuario)
//        return usuario
//    }

    suspend fun getActualUserDates(): Usuario{
        val usuario = userUseCase.getActualUserDates(getToken())
        _usuario.postValue(usuario)
        return usuario
    }

    fun setUsername(newUsername: String) {
        _username.value = newUsername
    }

    fun setPassword(newPassword: String) {
        _password.value = newPassword
    }
}
