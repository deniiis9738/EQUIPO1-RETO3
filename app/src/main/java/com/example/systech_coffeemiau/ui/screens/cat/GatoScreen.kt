package com.example.systech_coffeemiau.ui.screens.cat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.systech_coffeemiau.ui.components.cat.GatoHeader
import com.example.systech_coffeemiau.ui.components.cat.GatoImageCard
import com.example.systech_coffeemiau.ui.components.cat.GatoMedicalInfo
import com.example.systech_coffeemiau.ui.viewsmodels.GatoViewModel

@Composable
fun GatoScreen(gatoViewModel: GatoViewModel) {

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