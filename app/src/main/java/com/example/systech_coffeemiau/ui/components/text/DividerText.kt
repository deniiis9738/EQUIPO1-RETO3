package com.example.systech_coffeemiau.ui.components.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.ui.theme.PastelOrangeComplementario

@Composable
fun DividerText(
    text: String,
    color: Color = PastelOrangeComplementario
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        MyDivider()

        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, color = color)
        Spacer(modifier = Modifier.width(8.dp))

        MyDivider()
    }
}

@Composable
private fun MyDivider(
    color: Color = Color.Gray,
    width: Int = 90
) {
    Divider(
        color = color,
        modifier = Modifier.width(width.dp)
    )
}