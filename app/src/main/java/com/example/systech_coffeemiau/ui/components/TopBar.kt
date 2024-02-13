package com.example.systech_coffeemiau.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.R
import com.example.systech_coffeemiau.ui.theme.PeachyPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        TopAppBar(
            navigationIcon = {
                AppLogo(size = 115)
            },
            title = {
                Text(
                    text = "Coffee&Miau",
                    color = PeachyPink,
                    fontFamily = FontFamily(Font(R.font.shrikhand_regular)),
                    modifier = Modifier
                        .padding(start = 20.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TopAppBarDefaults.smallTopAppBarColors(Color.Transparent)
        )
    }
}