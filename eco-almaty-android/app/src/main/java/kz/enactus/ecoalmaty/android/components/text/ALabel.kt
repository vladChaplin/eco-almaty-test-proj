package kz.enactus.ecoalmaty.android.components.text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.ui.theme.montserratFontFamily

@Composable
fun ALabel(
    value: String,
    fontSz: TextUnit = 14.sp,
    colorText: Color = colorResource(id = R.color.black),
    modifier: Modifier = Modifier
) {
    Text(
        text = value,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = fontSz,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorText
    )
}