package com.example.systech_coffeemiau.ui.components.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel

@Composable
fun UserField(
    usernameValue: String,
    placeholder: String = "Username",
    viewModel: LoginViewModel
) {
    OutlinedTextField(
        value = usernameValue,
        onValueChange = { viewModel.onUsernameChanged(it) },
        enabled = true,
        singleLine = true,
        placeholder = { Text(text = placeholder, color = Color.Gray) },
        modifier = Modifier.fillMaxWidth(),
    )
}