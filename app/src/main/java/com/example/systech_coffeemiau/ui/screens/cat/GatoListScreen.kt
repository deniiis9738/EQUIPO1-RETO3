package com.example.systech_coffeemiau.ui.screens.cat

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.systech_coffeemiau.ui.components.cat.GatoCardItem
import com.example.systech_coffeemiau.ui.components.text.LoadingText
import com.example.systech_coffeemiau.ui.viewsmodels.GatoViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GatoListScreen( navController: NavController, gatoViewModel: GatoViewModel ){

    val gatos by gatoViewModel.gatoList.observeAsState(initial = emptyList())

    if (gatos.isEmpty()){
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            /*CircularProgressIndicator()

            Spacer(modifier = Modifier.height(20.dp))*/

            LoadingText(message = "Cargando...")
        }

    } else {
        /*LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            stickyHeader { GatoTopBar(navController) }

            item {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(gatos.size) {
                        GatoCardItem(navController)
                    }
                }
            }
        }*/

        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(gatos){
                GatoCardItem(navController, it)
            }
        }
    }
}

