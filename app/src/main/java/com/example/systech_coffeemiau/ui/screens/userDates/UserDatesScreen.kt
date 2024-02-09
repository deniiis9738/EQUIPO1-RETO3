package com.example.systech_coffeemiau.ui.screens.userDates

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.systech_coffeemiau.ui.theme.PastelOrangeComplementario
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun UserDatesScreen(loginViewModel: LoginViewModel, navController: NavHostController) {

    val userDates by loginViewModel.usuario.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start

    ) {
        if (userDates != null) {

            Text(
                text = "Bienvenid@ ${userDates?.rol}",
                fontSize = 28.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "User Photo",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))

            Text("ID: ${userDates?.id.toString()}", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Nombre: ${userDates?.username.toString()}", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Teléfono: ${userDates?.telefono.toString()}", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Email: ${userDates?.email.toString()}", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate("LoginView")
                        loginViewModel.clearToken()
                        loginViewModel.setPassword("")
                    },
                    modifier = Modifier.padding(bottom = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PastelOrangeComplementario,
                        contentColor = Color.White
                    )
                ) {
                    Text("Desconectar / Cerrar cuenta", fontSize = 22.sp)
                }
            }

        } else {
            Text(
                text = "No estas logueado",
                fontSize = 28.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        loginViewModel.clearToken()
                        loginViewModel.setPassword("")
                        navController.navigate("LoginView")
                    },
                    modifier = Modifier.padding(bottom = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PastelOrangeComplementario,
                        contentColor = Color.White
                    )
                ) {
                    Text("Loguear", fontSize = 22.sp)
                }
            }
        }
    }
}