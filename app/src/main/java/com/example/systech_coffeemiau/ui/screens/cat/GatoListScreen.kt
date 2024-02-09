package com.example.systech_coffeemiau.ui.screens.cat

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.systech_coffeemiau.ui.components.cat.GatoCardItem
import com.example.systech_coffeemiau.ui.components.cat.GatoTopBar
import com.example.systech_coffeemiau.ui.viewsmodels.GatoViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GatoListScreen( navController: NavController, gatoViewModel: GatoViewModel ){

    val gatos by gatoViewModel.gatoList.observeAsState()

    if (gatos!!.isEmpty()){

        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Loading...")
            CircularProgressIndicator()
        }

    } else {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            stickyHeader { GatoTopBar(navController) }

            item {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(gatos!!.size) {
                        GatoCardItem()
                    }
                }
            }
        }
    }
}

