package com.example.systech_coffeemiau.ui.components.cat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                Text("Quienes somos:\n" +
                        "\n" +
                        "ASPAC, Amigos de los Animales de Castellón, es una Asociación sin ánimo de lucro," +
                        " legalmente constituida e independiente de cualquier grupo político, religioso o social," +
                        " fundada en el año 2000, dedicada a la protección y defensa de los animales.\n" +
                        "\n" +
                        "ASPAC no tiene refugio de acogida de animales, pero desde la seguridad de que la " +
                        "protección y la defensa de estos puede realizarse desde otros muchos campos, " +
                        "desde su fundación ha basado su labor en la difusión de los derechos de los animales, " +
                        "en la tramitación de denuncias por abusos y malos tratos, en la concienciación tanto de " +
                        "los organismos oficiales como de forma directa sobre la población de la necesidad de un " +
                        "cambio en el trato que se da a los animales y en la lucha por una aplicación efectiva de " +
                        "las leyes de protección de los animales.\n" +
                        "\n" +
                        "Nuestra Asociación está formada por socios y voluntarios.",
                    color = Color.Black
                )

                Image(
                    painter = painterResource(id = R.drawable.aspac_logo),
                    contentDescription = "Shelter Logo",
                    modifier = Modifier.size(120.dp).padding(start = 60.dp).clip(CircleShape)
                )

                Text(
                    text = "Avenida Almazora 40A\n" +
                            "12005 Castellón, España\n" +
                            "E-mail: info@aspac.org.es",
                    color = Color.Black
                )
            }
        }

        item{

            Button(
                onClick = { showOthers = !showOthers }
            ) {
                Text(text = "OTROS")
            }
        }

        if (showOthers){
            item {

            }
        }
    }
}