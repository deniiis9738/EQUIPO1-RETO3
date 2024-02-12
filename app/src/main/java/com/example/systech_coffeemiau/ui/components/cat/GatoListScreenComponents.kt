package com.example.systech_coffeemiau.ui.components.cat

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.systech_coffeemiau.domain.models.GatoModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GatoTopBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "Back",
                modifier = Modifier.clickable { navController.popBackStack() }
            )
        },
        title = { Text("Los mininos de la casa") }
    )
}

@Composable
fun GatoCardItem(navController: NavController, gato: GatoModel) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable { navController.navigate("GatoDetail_View") },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column {
            AsyncImage(
                model = gato.picture,
                contentDescription = "Imagen Gato",
                modifier = Modifier.size(150.dp)
            )

            Text(
                text = gato.name,
                fontWeight = FontWeight.Bold
            )
        }
    }
}