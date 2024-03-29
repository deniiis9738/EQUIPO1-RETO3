package com.example.systech_coffeemiau.ui.components.cat

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.systech_coffeemiau.domain.models.GatoModel
import com.example.systech_coffeemiau.ui.screens.cat.GatoScreen
import com.example.systech_coffeemiau.ui.viewsmodels.GatoViewModel

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
fun GatoCardItem(navController: NavController, gato: GatoModel, gatoViewModel: GatoViewModel) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
            .clickable {
                gatoViewModel.setGato(gato)
                navController.navigate("GatoDetail_View")
            },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AsyncImage(
                model = gato.picture,
                contentDescription = "Imagen Gato",
                modifier = Modifier.size(200.dp)
            )

            Text(
                text = gato.name,
                fontWeight = FontWeight.Bold
            )
        }
    }
}