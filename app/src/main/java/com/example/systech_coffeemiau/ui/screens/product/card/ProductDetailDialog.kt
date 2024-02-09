package com.example.systech_coffeemiau.ui.screens.product.card

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.domain.models.Product
import com.example.systech_coffeemiau.ui.components.text.BoldText

@Composable
fun ProductDetailDialog(
    detailsView: () -> Unit,
    product: Product
) {
    AlertDialog(
        onDismissRequest = detailsView,
        title = {
            BoldText(
                text = product.name,
                size = 40
            )
        },
        text = {
            ProductComponents(
                imageUrl = product.imageUrl,
                description = product.description,
                price = product.price
            )
        },
        confirmButton = {
            Button(
                onClick = detailsView,
            ) {
                Text("Cerrar")
            }
        },
        modifier = Modifier
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp)
    )
}