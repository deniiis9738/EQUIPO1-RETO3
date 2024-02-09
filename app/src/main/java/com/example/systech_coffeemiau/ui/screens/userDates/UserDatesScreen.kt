package com.example.systech_coffeemiau.ui.screens.userDates

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
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
            if(userDates != null) {

                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "User Photo", modifier = Modifier.size(120.dp))
                    Spacer(modifier = Modifier.height(32.dp))

                    Text("ID: ${userDates?.id.toString()}", fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Nombre: ${userDates?.username.toString()}", fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Rol: ${userDates?.rol.toString()}", fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Teléfono: ${userDates?.telefono.toString()}", fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Email: ${userDates?.email.toString()}", fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = {
                            loginViewModel.clearToken()
                            navController.navigate("LoginView")
                        }
                    ) {
                        Text("Desconectar / Cerrar cuenta", fontSize = 18.sp)

                    }


            } else {
                Text(text = "Error")
                Button(
                    onClick = {
                        loginViewModel.clearToken()
                        navController.navigate("LoginView")
                    }
                ) {
                    Text("Desconectar / Cerrar cuenta", fontSize = 18.sp)

                }
            }

        }

}