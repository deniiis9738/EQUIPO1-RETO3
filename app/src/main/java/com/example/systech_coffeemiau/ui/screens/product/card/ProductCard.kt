package com.example.systech_coffeemiau.ui.screens.product.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.ui.components.text.BoldText

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
        shape = RoundedCornerShape(16.dp),
    ) {
        ProductComponents(
            imageUrl = product.picture,
            name = product.name
        )

        if (detailsView) {
            AlertDialog(
                onDismissRequest = { detailsView = false },
                title = {
                    BoldText(
                        text = product.name,
                        size = 40
                    )
                },
                text = {
                    ProductComponents(
                        imageUrl = product.picture,
                        description = product.description,
                        price = product.price
                    )
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