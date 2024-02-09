package com.example.systech_coffeemiau.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.R
import com.example.systech_coffeemiau.domain.models.GatoModel

//@Preview(showSystemUi = true)
@Composable
fun GatoImageCard(){
    Image(
        painter = painterResource(id = (R.drawable.gato)),
        contentDescription = "Gato profile photo",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun GatoHeader(){

        Text(
            text = "NOMBRE_GATO",
            fontFamily = FontFamily( Font(R.font.shrikhand_regular) ),
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 50.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ){
            Icon(imageVector = Icons.Default.CatchingPokemon, contentDescription = "Info")

            Text(
                text = "Conoce a [Nombre_Gato]",
                fontFamily = FontFamily( Font(R.font.shrikhand_regular) ),
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = "test prueba"
                        /*"Con tan solo ${gato.age} añitos, ${gato.name} es un felino con un carácter" +
                        "${gato.personality} propio de los de su raza, ${gato.race}. Te enamorarás de" +
                        "este encantador felino nada más vengas a conocerlo. ¿A qué esperas?" +
                        "\nComo siempre, la protectora ${gato.shelter} es la encargada de realizar todo" +
                        "el papeleo pertinente a la adocpión."*/
            )
        }
}

@Composable
fun GatoMedicalInfo(){

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        item{

            Button(
                onClick = {

                }
            ) {
                Text(text = "HISTORIAL MÉDICO")
            }
        }

        item{

            Button(
                onClick = {

                }
            ) {
                Text(text = "PROTECTORA")
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