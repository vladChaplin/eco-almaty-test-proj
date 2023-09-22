package kz.enactus.ecoalmaty.android.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomClickableText(
    startText: String = "Ещё нет аккаунта?",
    valueText: String,
    onClick: (Int) -> Unit,
    colorText: Color,
    fontSz: TextUnit = 14.sp,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = startText,
            fontSize = fontSz,
        )
        Spacer(
            modifier = Modifier.width(3.dp)
        )
        LinkClickableText(
            valueText = valueText,
            onClick = onClick,
            colorText = colorText,
            fontSz = fontSz,
        )
    }
}