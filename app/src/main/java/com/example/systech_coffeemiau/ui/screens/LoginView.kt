package com.example.systech_coffeemiau.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.systech_coffeemiau.ui.components.AppLogo
import com.example.systech_coffeemiau.ui.components.login.LoginButton
import com.example.systech_coffeemiau.ui.components.login.PasswordField
import com.example.systech_coffeemiau.ui.components.login.UserField
import com.example.systech_coffeemiau.ui.components.text.DividerText
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel

@Composable
fun LoginView(
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    val username by loginViewModel.username.observeAsState(initial = "")
    val password by loginViewModel.password.observeAsState(initial = "")
    val passwordVisibility by loginViewModel.passwordVisibility.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        AppLogo()

        Spacer(modifier = Modifier.height(16.dp))

        UserField(
            usernameValue = username,
            viewModel = loginViewModel
        )

        Spacer(modifier = Modifier.height(8.dp))

        PasswordField(
            passwordValue = password,
            viewModel = loginViewModel,
            passwordVisibility = passwordVisibility
        )

        Spacer(modifier = Modifier.height(16.dp))

        LoginButton(
            loginViewModel = loginViewModel,
            navController = navController,
            message = "Log In"
        )

        Spacer(modifier = Modifier.height(16.dp))

        DividerText(text = "OR")
    }
}