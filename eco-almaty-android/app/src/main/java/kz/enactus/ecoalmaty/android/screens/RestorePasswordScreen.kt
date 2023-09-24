package kz.enactus.ecoalmaty.android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
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
import kz.enactus.ecoalmaty.android.components.inputs.AVerificationEmailTextField
import kz.enactus.ecoalmaty.android.components.text.AHeaderTextComponent
import kz.enactus.ecoalmaty.android.components.text.ANormalTextComponent

@Composable
fun RestorePasswordScreen(navController: NavController) {
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
            Spacer(modifier = Modifier.height(50.dp))
            AHeaderTextComponent(
                value = stringResource(id = R.string.text_restore_password),
                fontSz = 24.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            ANormalTextComponent(
                value = stringResource(id = R.string.text_send_message_pass_reset),
                colorText = colorResource(id = R.color.colorLightGreen),
            )
            Spacer(modifier = Modifier.height(30.dp))
            AHeaderTextComponent(
                value = stringResource(id = R.string.text_email),
                fontSz = 12.sp,
                colorText = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            AVerificationEmailTextField()
            Spacer(modifier = Modifier.height(40.dp))
            ABtnDefault(
                onClick = {

                },
                labelValue = stringResource(id = R.string.text_restore_password_btn),
                colorResource(id = R.color.colorGreen),
                Color.White,
            )
            Spacer(modifier = Modifier.height(18.dp))
            AGoogleButtonComponent(
                onClick = {
                    navController.navigate(Destination.AuthorizationScreen.route)
                },
                iconCustom = Icons.Filled.ArrowBack,
                labelValue = stringResource(id = R.string.text_return_to_login),
                fontSz = 16.sp
            )
            Spacer(modifier = Modifier.height(48.dp))
            ACustomClickableText(
                valueText = stringResource(id = R.string.text_link_signup),
                onClick = {
                    navController.navigate(Destination.SignUpScreen.route)
                },
                colorText = colorResource(id = R.color.colorGreen),
            )
        }
    }
}


@Preview
@Composable
fun DefaultPreviewOfRestorePasswordScreen() {
    val navControllerFake = rememberNavController()
    RestorePasswordScreen(navController = navControllerFake)
}