package kz.enactus.ecoalmaty.android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.app.Destination
import kz.enactus.ecoalmaty.android.components.BtnDefault
import kz.enactus.ecoalmaty.android.components.CustomClickableText
import kz.enactus.ecoalmaty.android.components.CustomTextField
import kz.enactus.ecoalmaty.android.components.GoogleButtonComponent
import kz.enactus.ecoalmaty.android.components.HeaderTextComponent
import kz.enactus.ecoalmaty.android.components.NormalTextComponent
import kz.enactus.ecoalmaty.android.components.PasswordCustomTextField

@Composable
fun SignUpScreen(navController: NavController) {

    Surface(
        color = colorResource(id = R.color.colorWhiteBackground),
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorWhiteBackground))
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize())
        {
            Spacer(modifier = Modifier.height(50.dp))
            
            HeaderTextComponent(
                value = stringResource(id = R.string.text_welcome_signup),
                fontSz = 24.sp,
            )
            Spacer(modifier = Modifier.height(6.dp))
            NormalTextComponent(
                value = stringResource(id = R.string.text_signup_and_continue),
                colorCustom = colorResource(id = R.color.colorLightGreen),
            )
            Spacer(modifier = Modifier.height(9.dp))
            HeaderTextComponent(
                value = stringResource(id = R.string.text_name),
                fontSz = 12.sp,
                colorCustom = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                leadingIcon = Icons.Default.Person,
                leadingIconContentDesc = "emailOrLoginIcon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            HeaderTextComponent(
                value = stringResource(id = R.string.text_email_or_login),
                fontSz = 12.sp,
                colorCustom = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                leadingIcon = Icons.Default.Person,
                leadingIconContentDesc = "emailOrLoginIcon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            HeaderTextComponent(
                value = stringResource(id = R.string.text_phone_num),
                fontSz = 12.sp,
                colorCustom = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                leadingIcon = Icons.Default.Person,
                leadingIconContentDesc = "emailOrLoginIcon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            HeaderTextComponent(
                value = stringResource(id = R.string.text_password),
                fontSz = 12.sp,
                colorCustom = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            PasswordCustomTextField(
                leadingIcon = Icons.Default.Lock,
                leadingIconContentDesc = "passwordLock",
            )
            Spacer(modifier = Modifier.height(25.dp))
            BtnDefault(
                onClick = {

                },
                labelValue = stringResource(id = R.string.text_signup),
                colorResource(id = R.color.colorGreen),
                Color.White
            )
            Spacer(modifier = Modifier.height(25.dp))
            GoogleButtonComponent(
                onClick = { /*
                    Реализация авторизации через гугл аккаунт
                */ },
            )
            Spacer(modifier = Modifier.height(25.dp))
            CustomClickableText(
                valueText = stringResource(id = R.string.text_signin_2),
                onClick = {
                    navController.navigate(Destination.AuthorizationScreen.route)
                },
                colorText = colorResource(id = R.color.colorGreen),
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    val navControllerFake = rememberNavController()
    SignUpScreen(navControllerFake)
}