package com.example.systech_coffeemiau.ui.screens.cat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.ui.components.cat.GatoHeader
import com.example.systech_coffeemiau.ui.components.cat.GatoImageCard
import com.example.systech_coffeemiau.ui.components.cat.GatoMedicalInfo
import com.example.systech_coffeemiau.ui.viewsmodels.GatoViewModel

@Composable
fun GatoScreen(gatoViewModel: GatoViewModel) {

    val gato by gatoViewModel.gato.observeAsState()

    Surface (
        modifier = Modifier.fillMaxSize(),

    ){
        Column (
            modifier = Modifier.fillMaxSize().padding(6.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            GatoImageCard(gato!!.picture)

            GatoHeader(gato!!)

            GatoMedicalInfo(gato!!)
        }
    }
}