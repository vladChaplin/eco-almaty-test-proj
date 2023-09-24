package kz.enactus.ecoalmaty.android.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.enactus.ecoalmaty.android.ui.theme.montserratFontFamily

@Composable
fun ABtnDefault(
    onClick: () -> Unit,
    labelValue: String,
    backgroundColor: Color,
    textColor: Color,
    fontSz: TextUnit = 20.sp,
    heightBtn: Dp = 51.dp,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .heightIn(heightBtn),
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(size = 8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor, contentColor = textColor)
    ) {
        Text(
            text = labelValue,
            fontFamily = montserratFontFamily,
            fontSize = fontSz,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )

    }
}