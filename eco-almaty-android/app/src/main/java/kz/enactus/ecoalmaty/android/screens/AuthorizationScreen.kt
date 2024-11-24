package kz.enactus.ecoalmaty.android.screens
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
import kz.enactus.ecoalmaty.android.services.AuthRequest
import kz.enactus.ecoalmaty.android.services.authUser
import kz.enactus.ecoalmaty.android.ui.theme.montserratFontFamily

import androidx.lifecycle.viewmodel.compose.viewModel
import kz.enactus.ecoalmaty.android.models.AuthViewModel

@Composable
fun AuthorizationScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    var emailOrLogin by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current

    Surface(
        color = colorResource(id = R.color.colorWhiteBackground),
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorWhiteBackground))
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(90.dp))
            AHeader(value = stringResource(id = R.string.text_hello), fontSz = 36.sp)
            ALabel(value = stringResource(id = R.string.text_input_data),
                colorText = colorResource(id = R.color.colorLightGreen))
            Spacer(modifier = Modifier.height(22.dp))
            ACustomTextField(
                value = emailOrLogin,
                onValueChange = { emailOrLogin = it },
                leadingIcon = Icons.Default.Person,
                leadingIconContentDesc = "emailOrLoginIcon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            APasswordTextField(
                value = password,
                onValueChange = { password = it },
                leadingIcon = Icons.Default.Lock,
                leadingIconContentDesc = "passwordLock",
            )
            Spacer(modifier = Modifier.height(24.dp))
            AButton(
                onClick = {
                    val authRequest = AuthRequest(username = emailOrLogin, password = password)
                    authUser(context, authRequest) { success, authResponse ->
                        if (success && authResponse != null) {
                            // Save token to ViewModel
                            authViewModel.saveToken(authResponse.token)

                            navController.navigate(
                                "profile_screen/${authResponse.username}/${authResponse.email}/${authResponse.roles.joinToString(",")}"
                            )
                        }
                    }
                },
                labelValue = stringResource(id = R.string.text_signin),
                colorResource(id = R.color.colorGreen),
                Color.White
            )
        }
    }
}


@Preview
@Composable
fun DefaultPreviewOfAuthorizationScreen() {
    val navControllerFake = rememberNavController()
    AuthorizationScreen(navControllerFake)
}