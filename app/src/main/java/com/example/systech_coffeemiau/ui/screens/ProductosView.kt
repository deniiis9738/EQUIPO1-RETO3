package com.example.systech_coffeemiau.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.systech_coffeemiau.ui.viewsmodels.ProductoViewModel

@Composable
fun ProductosView(productoViewModel: ProductoViewModel) {
    val producto by productoViewModel.productoModel.observeAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        producto?.nombre?.let {
            Text(
                text = it
            )
        }
    }
}