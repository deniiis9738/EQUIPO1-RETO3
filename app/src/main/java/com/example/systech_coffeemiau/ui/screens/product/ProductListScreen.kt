package com.example.systech_coffeemiau.ui.screens.product

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.ui.screens.product.card.ProductCard
import com.example.systech_coffeemiau.ui.viewsmodels.ProductoViewModel

@Composable
fun ProductListScreen(
    productoViewModel: ProductoViewModel
) {
    val products = listOf(
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
        Product(1,"https://png.pngtree.com/png-clipart/20210530/original/pngtree-coffee-cup-aroma-container-png-image_6373241.jpg","Café","Café solo con cuchara de regalo",5.5),
    )

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