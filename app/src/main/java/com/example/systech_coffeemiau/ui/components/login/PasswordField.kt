package com.example.systech_coffeemiau.ui.components.login

import android.view.KeyEvent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel

@Composable
fun PasswordField(
    passwordValue: String,
    placeholder: String = "Password",
    viewModel: LoginViewModel,
    passwordVisibility: Boolean
) {
    OutlinedTextField(
        value = passwordValue,
        onValueChange = { viewModel.onPasswordChanged(it) },
        enabled = true,
        singleLine = true,
        placeholder = { Text(text = placeholder, color = Color.Gray) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val icon = viewModel.viewIcon()
            Icon(
                imageVector = icon,
                contentDescription = "Visible",
                tint = Color.Gray,
                modifier = Modifier.clickable { viewModel.togglePasswordVisibility() }
            )
        },
        keyboardActions = KeyboardActions(
            onSend = {

            }
        )
    )
}