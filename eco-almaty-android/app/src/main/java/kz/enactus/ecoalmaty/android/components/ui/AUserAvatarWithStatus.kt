package kz.enactus.ecoalmaty.android.components.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.components.text.ANormalTextComponent
import kz.enactus.ecoalmaty.android.components.utils.toHslColor
import kz.enactus.ecoalmaty.android.ui.theme.montserratFontFamily


@Composable
fun AUserAvatarWithStatus(
    id: String,
    firstName: String,
    lastName: String,
    status: UserStatus,
    modifier: Modifier = Modifier,
    size: Dp = 75.dp,
) {
    Box(
        modifier = modifier
            .size(size)
    ) {
        val color = remember(id, firstName, lastName) {
            val name = listOf(firstName, lastName)
                .joinToString(separator = "")
                .uppercase()
            Color("$id / $name".toHslColor())
        }

        Box(modifier.size(size), contentAlignment = Alignment.Center) {
            val initials = (firstName.take(1) + lastName.take(1).uppercase())
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(SolidColor(color))
            }

            Text(
                text = initials,
                color = colorResource(id = R.color.white),
                style = TextStyle(
                    fontFamily = montserratFontFamily,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                )
            )

        }
        if (status != UserStatus.None) {
            Indicator(
                avatarStatus = status,
                size = size / 5,
                modifier = Modifier.align(Alignment.TopEnd),
                colorBorder = color
            )
        }
    }

}

@Composable
private fun Indicator(
    avatarStatus: UserStatus,
    size: Dp,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    colorBorder: Color,
) {
    val color = when (avatarStatus) {
        UserStatus.Online -> colorResource(id = R.color.colorGreen)
        UserStatus.Offline -> colorResource(id = R.color.colorMediumGray)
        else -> Color.Unspecified
    }

    Box(
        modifier = modifier
            .background(color, shape)
            .size(size)
            .border(
                width = 1.dp,
                color = colorBorder,
                shape = shape
            )
    )
}