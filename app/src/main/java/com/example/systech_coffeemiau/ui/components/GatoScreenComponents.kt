package com.example.systech_coffeemiau.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.R

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

@Preview(showSystemUi = true)
@Composable
fun GatoHeader(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ){

        Text(
            text = "NOMBRE_GATO",
            fontFamily = FontFamily( Font(R.font.shrikhand_regular) ),
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
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
        }
    }


}

@Composable
fun GatoMedicalInfo(){

}