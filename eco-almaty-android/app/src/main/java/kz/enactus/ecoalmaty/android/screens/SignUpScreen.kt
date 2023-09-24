package kz.enactus.ecoalmaty.android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
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
import kz.enactus.ecoalmaty.android.components.text.ACustomClickableText
import kz.enactus.ecoalmaty.android.components.buttons.AGoogleButtonComponent
import kz.enactus.ecoalmaty.android.components.buttons.ABtnDefault
import kz.enactus.ecoalmaty.android.components.inputs.ACustomTextField
import kz.enactus.ecoalmaty.android.components.inputs.APasswordCustomTextField
import kz.enactus.ecoalmaty.android.components.text.AHeaderTextComponent
import kz.enactus.ecoalmaty.android.components.text.ANormalTextComponent

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
            
            AHeaderTextComponent(
                value = stringResource(id = R.string.text_welcome_signup),
                fontSz = 24.sp,
            )
            Spacer(modifier = Modifier.height(6.dp))
            ANormalTextComponent(
                value = stringResource(id = R.string.text_signup_and_continue),
                colorText = colorResource(id = R.color.colorLightGreen),
            )
            Spacer(modifier = Modifier.height(9.dp))
            AHeaderTextComponent(
                value = stringResource(id = R.string.text_name),
                fontSz = 12.sp,
                colorText = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            ACustomTextField(
                leadingIcon = Icons.Default.Person,
                leadingIconContentDesc = "emailOrLoginIcon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            AHeaderTextComponent(
                value = stringResource(id = R.string.text_email_or_login),
                fontSz = 12.sp,
                colorText = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            ACustomTextField(
                leadingIcon = Icons.Default.Email,
                leadingIconContentDesc = "emailOrLoginIcon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            AHeaderTextComponent(
                value = stringResource(id = R.string.text_phone_num),
                fontSz = 12.sp,
                colorText = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            ACustomTextField(
                leadingIcon = Icons.Default.Phone,
                leadingIconContentDesc = "emailOrLoginIcon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            AHeaderTextComponent(
                value = stringResource(id = R.string.text_password),
                fontSz = 12.sp,
                colorText = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            APasswordCustomTextField(
                leadingIcon = Icons.Default.Lock,
                leadingIconContentDesc = "passwordLock",
            )
            Spacer(modifier = Modifier.height(25.dp))
            ABtnDefault(
                onClick = {
                          navController.navigate(Destination.ConfirmationOfRegScreen.route)
                },
                labelValue = stringResource(id = R.string.text_signup),
                colorResource(id = R.color.colorGreen),
                Color.White
            )
            Spacer(modifier = Modifier.height(25.dp))
            AGoogleButtonComponent(
                onClick = { /*
                    Реализация авторизации через гугл аккаунт
                */ },
            )
            Spacer(modifier = Modifier.height(25.dp))
            ACustomClickableText(
                startText = stringResource(id = R.string.text_already_have_account),
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