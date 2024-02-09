package com.example.systech_coffeemiau.ui.components.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import kotlinx.coroutines.delay

private const val LOADING_VALUE = "."
private const val LOADING_MAX_VALUE = 3
private const val LOADING_VALUE_GROUP = 1

@Composable
fun LoadingText(message: String) {
    var valueCount by rememberSaveable { mutableIntStateOf(1) }

    // Mientras dure la pantalla de carga, ira apareciendo y despareciendo para dar sensacion de carga
    LaunchedEffect(Unit) {
        while (true) {
            // Frecuencia en la que el texto va cargando
            delay(300)
            valueCount = (valueCount % LOADING_MAX_VALUE) + LOADING_VALUE_GROUP
        }
    }

    val loadingText = buildAnnotatedString {
        // Texto estatico
        append(message)

        // Texto animado
        repeat(valueCount) {
            append(LOADING_VALUE)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = loadingText)
    }
}