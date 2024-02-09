package com.example.systech_coffeemiau.ui.screens.product.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.domain.models.Product

@Composable
fun ProductCard(product: Product) {
    var setDetailsView by rememberSaveable { mutableStateOf(false) }

    Card (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable {
                setDetailsView = !setDetailsView
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(16.dp),
    ) {
        ProductComponents(
            imageUrl = product.imageUrl,
            name = product.name
        )

        if (setDetailsView) {
            ProductDetailDialog(
                detailsView = { setDetailsView = false },
                product
            )
        }
    }
}