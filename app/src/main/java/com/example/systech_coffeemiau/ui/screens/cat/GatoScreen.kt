package com.example.systech_coffeemiau.ui.screens.cat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.systech_coffeemiau.ui.components.cat.GatoHeader
import com.example.systech_coffeemiau.ui.components.cat.GatoImageCard
import com.example.systech_coffeemiau.ui.components.cat.GatoMedicalInfo

@Preview(showSystemUi = true)
@Composable
fun GatoScreen(/*navController: NavController*/){

    Surface (
        modifier = Modifier.fillMaxSize(),

    ){
        Column {
            GatoImageCard()

            GatoHeader()

            GatoMedicalInfo()
        }
    }
}