package com.example.systech_coffeemiau.ui.screens.cat

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.systech_coffeemiau.ui.components.cat.GatoCardItem
import com.example.systech_coffeemiau.ui.components.text.LoadingText
import com.example.systech_coffeemiau.ui.viewsmodels.GatoViewModel

@Composable
fun GatoListScreen( navController: NavController, gatoViewModel: GatoViewModel ){

    val gatos by gatoViewModel.gatoList.observeAsState(initial = emptyList())
    val gato by gatoViewModel.gato.observeAsState()

    if (gatos.isEmpty()){
        LoadingText(message = "Cargando...")

    } else {
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(gatos){
                GatoCardItem(navController, it, gatoViewModel)
            }
        }
    }
}

