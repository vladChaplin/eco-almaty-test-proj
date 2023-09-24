package kz.enactus.ecoalmaty.android.components.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.enactus.ecoalmaty.android.R

@Composable
fun AIconAndTextComponent(
    icon: ImageVector,
    text: String,
    fontSz: TextUnit = 17.sp,
    colorText: Color = colorResource(id = R.color.black),
    iconColor: Color = colorResource(id = R.color.colorMediumGray),
    spacer: Dp = 6.dp,
    modifierIcon: Modifier = Modifier,
) {
    Row(

    ) {

        Icon(
          imageVector = icon,
          contentDescription = null,
          tint = iconColor,
          modifier = modifierIcon
        )

        Spacer(modifier = Modifier.width(spacer))
        
        ANormalTextComponent(
            value = text,
            fontSz = fontSz,
            colorText = colorText
        )
    }
}