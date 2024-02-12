package com.example.systech_coffeemiau.ui.components.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.systech_coffeemiau.ui.theme.PastelOrangeComplementario
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel

@Composable
fun LoginButton(
    loginViewModel: LoginViewModel,
    navController: NavController,
    message: String
) {
    val autenticado by loginViewModel.autenticado.observeAsState(initial = false)

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { loginViewModel.login() },
        colors = ButtonDefaults.buttonColors(
            containerColor = loginViewModel.changeColor(
                firstColor = Color.Green,
                secondColor = PastelOrangeComplementario
            )
        ),
        content = {
            Text(
                text = message,
                color = Color.White
            )
        }
    )

    if (autenticado) LaunchedEffect(navController) {
        navController.navigate("ProductosView")
    }
}