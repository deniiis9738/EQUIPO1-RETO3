package com.example.systech_coffeemiau.ui.components.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.systech_coffeemiau.ui.theme.PastelOrangeComplementario
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
@OptIn(DelicateCoroutinesApi::class)
fun LoginButton(
    loginViewModel: LoginViewModel,
    navController: NavController,
    message: String
) {
    val username by loginViewModel.username.observeAsState(initial = "")

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            GlobalScope.launch {
                loginViewModel.login()
                loginViewModel.getUserDates(username)
            }
            if (loginViewModel.isAuthenticated()) {
                navController.navigate("ProductosView")
            }
        },
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
}