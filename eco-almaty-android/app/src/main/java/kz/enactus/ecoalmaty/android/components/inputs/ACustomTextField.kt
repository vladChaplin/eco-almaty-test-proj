package kz.enactus.ecoalmaty.android.components.inputs
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.ui.theme.montserratFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ACustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: ImageVector? = null,
    leadingIconContentDesc: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    backgroundColorCust: Color = colorResource(id = R.color.colorGray),
    label: String? = null,
    readOnly: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    Column {
        label?.let {
            androidx.compose.material3.Text(
                text = it,
                style = TextStyle(
                    fontFamily = montserratFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.colorDarkGray)
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(44.dp, 48.dp)
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.colorMediumGray),
                    shape = RoundedCornerShape(size = 8.dp),
                )
                .background(
                    color = backgroundColorCust,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier),
            colors = TextFieldDefaults.textFieldColors(
                textColor = colorResource(id = R.color.colorDarkGray),
                disabledTextColor = Color.Transparent,
                containerColor = backgroundColorCust,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = colorResource(id = R.color.colorLightGreen)
            ),
            keyboardOptions = keyboardOptions,
            value = value,
            onValueChange = onValueChange,
            leadingIcon = {
                leadingIcon?.let { icon ->
                    Icon(
                        imageVector = icon,
                        contentDescription = leadingIconContentDesc,
                        tint = colorResource(id = R.color.colorMediumGray),
                    )
                }
            },
            shape = RoundedCornerShape(size = 8.dp),
            textStyle = TextStyle(
                fontFamily = montserratFontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            ),
            enabled = !readOnly
        )
    }
}
