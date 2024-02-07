package com.example.systech_coffeemiau.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.systech_coffeemiau.ui.components.GatoCardItem
import com.example.systech_coffeemiau.ui.components.GatoTopBar
import com.example.systech_coffeemiau.ui.viewsmodels.GatoViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GatoListScreen(
    navController: NavController,
    gatoViewModel: GatoViewModel
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        stickyHeader { GatoTopBar(navController) }

        item {
            LazyVerticalGrid(columns = GridCells.Fixed(2)){
                items(gatoViewModel.gatoList.size){
                    GatoCardItem()
                }
            }
        }
    }
}

