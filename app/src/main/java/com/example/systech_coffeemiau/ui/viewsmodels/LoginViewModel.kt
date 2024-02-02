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
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): ViewModel() {
    private var _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private var _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private var _passwordVisibility = MutableLiveData(false)
    val passwordVisibility: LiveData<Boolean> = _passwordVisibility

    private var _visual = MutableLiveData(VisualTransformation.None)
    val visual: LiveData<VisualTransformation> = _visual

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
        validateFields()
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
}
