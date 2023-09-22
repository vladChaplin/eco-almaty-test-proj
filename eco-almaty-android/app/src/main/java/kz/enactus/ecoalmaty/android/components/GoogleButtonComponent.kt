package kz.enactus.ecoalmaty.android.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.ui.theme.montserratFontFamily

@Composable
fun GoogleButtonComponent(
    onClick: () -> Unit,
    labelValue: String = stringResource(id = R.string.text_sign_in_google),
    backgroundColor: Color = Color.Transparent,
    textColor: Color = colorResource(id = R.color.black),
    fontSz: TextUnit = 16.sp,
    iconCustom: ImageVector = ImageVector.vectorResource(R.drawable.google_sign_up_button),

) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(51.dp),
        shape = RoundedCornerShape(size = 8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor, contentColor = textColor),
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(id = R.color.colorMediumGray),
        )
    ) {

        Image(
            imageVector = iconCustom,
            contentDescription = "google sign up",
        )
        Text(
            text = labelValue,
            fontFamily = montserratFontFamily,
            fontSize = fontSz,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 24.dp)
        )

    }
}