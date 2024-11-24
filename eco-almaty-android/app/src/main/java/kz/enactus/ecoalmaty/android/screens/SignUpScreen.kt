package kz.enactus.ecoalmaty.android.screens

import android.widget.Toast
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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import kz.enactus.ecoalmaty.android.components.text.AClickableText
import kz.enactus.ecoalmaty.android.components.buttons.AGoogleButton
import kz.enactus.ecoalmaty.android.components.buttons.AButton
import kz.enactus.ecoalmaty.android.components.inputs.ACustomTextField
import kz.enactus.ecoalmaty.android.components.inputs.APasswordTextField
import kz.enactus.ecoalmaty.android.components.text.AHeader
import kz.enactus.ecoalmaty.android.components.text.ALabel
import kz.enactus.ecoalmaty.android.services.SignUpRequest
import kz.enactus.ecoalmaty.android.services.registerUser

@Composable
fun SignUpScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current

    Surface(
        color = colorResource(id = R.color.colorWhiteBackground),
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorWhiteBackground))
            .padding(32.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(50.dp))
            AHeader(
                value = stringResource(id = R.string.text_welcome_signup),
                fontSz = 24.sp,
            )
            Spacer(modifier = Modifier.height(6.dp))
            ALabel(
                value = stringResource(id = R.string.text_signup_and_continue),
                colorText = colorResource(id = R.color.colorLightGreen),
            )
            Spacer(modifier = Modifier.height(9.dp))
            AHeader(
                value = stringResource(id = R.string.text_name),
                fontSz = 12.sp,
                colorText = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            ACustomTextField(
                value = username,
                onValueChange = { username = it },
                leadingIcon = Icons.Default.Person,
                leadingIconContentDesc = "usernameIcon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            AHeader(
                value = stringResource(id = R.string.text_email_or_login),
                fontSz = 12.sp,
                colorText = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            ACustomTextField(
                value = email,
                onValueChange = { email = it },
                leadingIcon = Icons.Default.Email,
                leadingIconContentDesc = "emailIcon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            AHeader(
                value = stringResource(id = R.string.text_password),
                fontSz = 12.sp,
                colorText = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))

            APasswordTextField(
                value = password,
                onValueChange = { password = it },
                leadingIcon = Icons.Default.Lock,
                leadingIconContentDesc = "passwordLock",
            )

            Spacer(modifier = Modifier.height(25.dp))
            AButton(
                onClick = {
                    // Создаем объект запроса регистрации
                    val signUpRequest = SignUpRequest(username, email, password, listOf("admin"))

                    // Вызываем функцию регистрации
                    registerUser(context, signUpRequest) { success, message ->
                        if (success) {
                            navController.navigate(Destination.ConfirmationOfRegScreen.route)
                        }
                        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                    }
                },
                labelValue = stringResource(id = R.string.text_signup),
                colorResource(id = R.color.colorGreen),
                Color.White
            )
            Spacer(modifier = Modifier.height(25.dp))
            AGoogleButton(
                onClick = { /* Реализация авторизации через Google */ },
            )
            Spacer(modifier = Modifier.height(25.dp))
            AClickableText(
                startText = stringResource(id = R.string.text_already_have_account),
                valueText = stringResource(id = R.string.text_signin_2),
                onClick = { navController.navigate(Destination.AuthorizationScreen.route) },
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

