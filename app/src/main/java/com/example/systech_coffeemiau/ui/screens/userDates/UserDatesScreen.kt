package com.example.systech_coffeemiau.ui.screens.userDates

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun UserDatesScreen(loginViewModel: LoginViewModel) {

    val userDates by loginViewModel.usuario.observeAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            if(userDates != null) {
                Text(text = userDates?.id.toString())

                Text(text = userDates?.username.toString())

                Text(text = userDates?.email.toString())

                Text(text = userDates?.telefono.toString())

                Text(text = userDates?.rol.toString())

            } else {
                Text(text = "Error")
            }


        }

}