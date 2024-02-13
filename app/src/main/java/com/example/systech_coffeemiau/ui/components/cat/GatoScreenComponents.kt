package com.example.systech_coffeemiau.ui.components.cat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.systech_coffeemiau.R
import com.example.systech_coffeemiau.domain.models.GatoModel

@Composable
fun GatoImageCard(gatoPicture: String) {
    AsyncImage(
        model = gatoPicture,
        contentDescription = "Imagen de perfil del gato",
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp)
    )
}

@Composable
fun GatoHeader(gato: GatoModel) {

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            Row (
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                Icon(imageVector = Icons.Default.CatchingPokemon, contentDescription = "Info")

                Text(
                    text = "Conoce a ${gato.name}",
                    fontFamily = FontFamily( Font(R.font.shrikhand_regular) ),
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Text(
                text = "${gato.name} es un felino con un carácter ${gato.personality.replaceFirstChar { it.lowercase() }} " +
                        "propio de los de su raza, ${gato.race.replaceFirstChar { it.lowercase() }}. " +
                        "Te enamorarás de este encantador felino nada más vengas a conocerlo. ¿A qué esperas?"
            )
        }
}

@Composable
fun GatoMedicalInfo(gato: GatoModel) {

    var showMedic by rememberSaveable { mutableStateOf(false) }
    var showShelter by rememberSaveable { mutableStateOf(false) }
    var showOthers by rememberSaveable { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        item{

            Button(
                onClick = { showMedic = !showMedic }
            ) {
                Text(text = "HISTORIAL MÉDICO")
            }
        }

        if (showMedic){
            item {
                Text(text = gato.medicalInfo)
            }
        }

        item{

            Button(
                onClick = { showShelter = !showShelter }
            ) {
                Text(text = "PROTECTORA")
            }
        }

        if (showShelter){
            item {
                Text("${gato.name} está a los cuidados de la Protectora Amigos Peludos." +
                        "Cualquier duda para su adopción ponte en contacto con ellos a través de:\n" +
                        "amigospeludos@adoptaunamigo.gmail.com")
            }
        }

        item{

            Button(
                onClick = {

                }
            ) {
                Text(text = "OTROS")
            }
        }
    }
}