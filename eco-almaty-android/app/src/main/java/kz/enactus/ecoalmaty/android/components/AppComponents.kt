package kz.enactus.ecoalmaty.android.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.app.Destination
import kz.enactus.ecoalmaty.android.ui.theme.montserratFontFamily

@Composable
fun NormalTextComponent(
    value: String,
    fontSz: TextUnit = 14.sp,
    colorCustom: Color = colorResource(id = R.color.black)
) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = fontSz,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorCustom
    )
}

@Composable
fun HeaderTextComponent(
    value: String,
    fontSz: TextUnit = 40.sp,
    colorCustom: Color = colorResource(id = R.color.black),
    ) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = fontSz,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
        , color = colorCustom,
        textAlign = TextAlign.Left
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    leadingIcon: ImageVector?,
    leadingIconContentDesc: String? = null,
    keyboardOptions: KeyboardOptions,
    backgroundColorCust: Color = colorResource(id = R.color.colorGray)
) {
    //Функция запоминания ввода
    val textValue = remember {
        mutableStateOf("")
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
            ),

        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.colorDarkGray),
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            containerColor = backgroundColorCust,
            cursorColor = colorResource(id = R.color.colorLightGreen),

        ),
        keyboardOptions = keyboardOptions,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            leadingIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = leadingIconContentDesc,
                    tint = colorResource(id = R.color.colorIconGray),
                )
            }
        },
        shape = RoundedCornerShape(size = 8.dp),
        textStyle = TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordCustomTextField(
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
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            leadingIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = leadingIconContentDesc,
                    tint = colorResource(id = R.color.colorIconGray),
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
                    tint = colorResource(id = R.color.colorIconGray)
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

@Composable
fun BtnDefault(
    onClick: () -> Unit,
    labelValue: String,
    backgroundColor: Color,
    textColor: Color,
    fontSz: TextUnit = 20.sp,
    heightBtn: Dp = 51.dp
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(heightBtn),
        shape = RoundedCornerShape(size = 8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor, contentColor = textColor)
    ) {
        Text(
            text = labelValue,
            fontFamily = montserratFontFamily,
            fontSize = fontSz,
            fontWeight = FontWeight.Normal,
        )

    }
}

/*
 * Возможность реализовать кликабельную ссылку как отдельный компонент
@Composable
fun ClickableTextComponent(
    text: AnnotatedString,
    onClick: () -> Unit,
    customStyle: TextStyle = TextStyle(
        color = colorResource(id = R.color.colorLightGreen),
        fontFamily = montserratFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.End
    ),
    ) {

    ClickableText(
        text = text,
        onClick = {
            onClick
        },
        modifier = Modifier
            .fillMaxWidth(),
        style = customStyle,
    )
}*/
