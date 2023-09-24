package kz.enactus.ecoalmaty.android.components.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.enums.UserStatus

@Composable
fun ATextWithStatus(
    text: String,
    status: UserStatus,
    modifier: Modifier = Modifier
) {
    val textColor = when (status) {
        UserStatus.Online -> colorResource(id = R.color.colorGreen)
        UserStatus.Offline -> colorResource(id = R.color.colorMediumGray)
        else -> Color.Unspecified
    }

    ANormalTextComponent(
        value = text,
        colorText = textColor,
        fontSz = 12.sp,
        modifier = modifier
        )
}