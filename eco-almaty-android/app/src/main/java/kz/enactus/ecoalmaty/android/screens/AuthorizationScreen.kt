package kz.enactus.ecoalmaty.android.screens
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import kz.enactus.ecoalmaty.android.ui.theme.montserratFontFamily

@Composable
fun AuthorizationScreen(navController: NavController) {
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
            AHeader(
                value = stringResource(id = R.string.text_email_or_login),
                fontSz = 12.sp,
                colorText = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            ACustomTextField(
                leadingIcon = Icons.Default.Person,
                leadingIconContentDesc = "emailOrLoginIcon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            AHeader(
                value = stringResource(id = R.string.text_password),
                fontSz = 12.sp,
                colorText = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            APasswordTextField(
                leadingIcon = Icons.Default.Lock,
                leadingIconContentDesc = "passwordLock",
                )
            Spacer(modifier = Modifier.height(16.dp))
            ClickableText(
                text = AnnotatedString(stringResource(id = R.string.text_restore_password)),
                onClick = { navController.navigate(Destination.RestorePasswordScreen.route) },
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    color = colorResource(id = R.color.colorLightGreen),
                    fontFamily = montserratFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            AButton(
                onClick = { },
                labelValue = stringResource(id = R.string.text_signin),
                colorResource(id = R.color.colorGreen),
                Color.White
            )
            Spacer(modifier = Modifier.height(24.dp))
            AGoogleButton(
                onClick = { },
            )
            Spacer(modifier = Modifier.height(39.dp))
            AClickableText(
                valueText = stringResource(id = R.string.text_link_signup),
                onClick = { navController.navigate(Destination.SignUpScreen.route) },
                colorText = colorResource(id = R.color.colorGreen),
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