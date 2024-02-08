package com.example.systech_coffeemiau.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.R

@Composable
fun AppLogo(
    size: Int = 200
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        modifier = Modifier
            .size(size.dp)
            .padding(16.dp),
        contentScale = ContentScale.Crop
    )
}