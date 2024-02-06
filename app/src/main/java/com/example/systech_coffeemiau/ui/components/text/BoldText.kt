package com.example.systech_coffeemiau.ui.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.systech_coffeemiau.ui.theme.MyTypography

@Composable
fun BoldText(
    text: String,
    size: Int = 20
) {
    ProvideTextStyle(value = MyTypography.bodyLarge) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = size.sp,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}