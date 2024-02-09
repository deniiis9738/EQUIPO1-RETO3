package com.example.systech_coffeemiau.ui.screens.product

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.ui.components.text.LoadingText
import com.example.systech_coffeemiau.ui.screens.product.card.ProductCard
import com.example.systech_coffeemiau.ui.viewsmodels.ProductoViewModel

@Composable
fun ProductListScreen(
    productViewModel: ProductoViewModel
) {
    val products by productViewModel.productList.observeAsState(initial = emptyList())

    if (products.isEmpty()) {
        LoadingText(message = "Cargando")
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            content = {
                items(products) { product ->
                    ProductCard(product = product)
                }
            }
        )
    }

}