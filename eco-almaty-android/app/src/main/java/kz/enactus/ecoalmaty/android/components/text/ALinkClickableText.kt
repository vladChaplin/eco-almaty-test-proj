package kz.enactus.ecoalmaty.android.components.text

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.ui.theme.montserratFontFamily

@Composable
fun ALinkClickableText(
    valueText: String,
    onClick: (Int) -> Unit,
    colorText: Color = colorResource(id = R.color.colorLightGreen),
    fontSz: TextUnit = 12.sp,
) {
    val annotatedStr = AnnotatedString(valueText)

    ClickableText(
        text = annotatedStr,
        onClick = onClick,
        style = TextStyle(
            color = colorText,
            fontFamily = montserratFontFamily,
            fontSize = fontSz,
            fontWeight = FontWeight.SemiBold,
        ),
    )
}
