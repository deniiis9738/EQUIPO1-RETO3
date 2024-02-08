package com.example.systech_coffeemiau.ui.screens.product.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.systech_coffeemiau.ui.components.text.BoldText

@Composable
fun ProductComponents(
    // De esta forma podemos elegir los elementos que se muestran y reciclar codigo
    imageUrl: String? = null,
    name: String? = null,
    description: String? = null,
    price: Double? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        imageUrl?.let {
            AsyncImage(
                model = it,
                contentDescription = "Product Image",
                modifier = Modifier.size(150.dp)
            )
        }

        name?.let {
            BoldText(text = it)
        }

        description?.let {
            BoldText(text = it)
        }

        price?.let {
            BoldText(text = "$it€")
        }
    }
}