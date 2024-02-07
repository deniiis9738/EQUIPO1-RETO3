package com.example.systech_coffeemiau.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.ui.viewsmodels.ProductoViewModel

@Composable
fun ProductosView(
    productoViewModel: ProductoViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val products by productoViewModel.productList.observeAsState(initial = emptyList())

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

@Composable
fun ProductCard(product: Product) {
    var detailsView by rememberSaveable { mutableStateOf(false) }

    Card (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable {
                detailsView = !detailsView
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = product.foto_producto,
                contentDescription = "Product Image",
                modifier = Modifier.size(150.dp)
            )
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp),
            )

            if (detailsView) {
                AlertDialog(
                    onDismissRequest = { detailsView = false },
                    title = {
                        Text(
                            text = product.name,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    },
                    text = {
                        Column (
                            modifier = Modifier
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AsyncImage(
                                model = product.foto_producto,
                                contentDescription = "Product Image",
                                modifier = Modifier.size(150.dp)
                            )
                            Text(
                                text = product.description,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = "${product.price}€",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = { detailsView = false },
                        ) {
                            Text("Cerrar")
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp)
                )
            }
        }
    }
}