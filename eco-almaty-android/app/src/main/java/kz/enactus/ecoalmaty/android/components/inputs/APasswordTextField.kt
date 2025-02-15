package kz.enactus.ecoalmaty.android.components.inputs
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.ui.theme.montserratFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun APasswordTextField(
    leadingIcon: ImageVector?,
    leadingIconContentDesc: String? = null,
) {
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
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
                colorResource(id = R.color.colorGray),
                shape = RoundedCornerShape(size = 8.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.colorDarkGray),
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            containerColor = colorResource(id = R.color.colorGray),
            cursorColor = colorResource(id = R.color.colorLightGreen),
            ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
        ),
        value = password.value,
        onValueChange = { password.value = it },
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
        trailingIcon = {
            val iconImage = if(passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            var description = if(passwordVisible.value) {
                stringResource(id = R.string.text_hide_password)
            } else {
                stringResource(id = R.string.text_show_password)
            }
            IconButton(onClick = {
                passwordVisible.value = !passwordVisible.value
            }) {
                Icon(
                    imageVector = iconImage,
                    contentDescription = description,
                    tint = colorResource(id = R.color.colorMediumGray)
                )
            }
        },
        visualTransformation = if(passwordVisible.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}