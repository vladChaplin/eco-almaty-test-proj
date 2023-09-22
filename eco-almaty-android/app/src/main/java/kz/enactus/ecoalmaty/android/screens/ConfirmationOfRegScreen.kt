package kz.enactus.ecoalmaty.android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import kz.enactus.ecoalmaty.android.components.VerificationEmailTextField

@Composable
fun ConfirmationOfRegScreen(navController: NavController) {
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
            HeaderTextComponent(
                value = stringResource(id = R.string.text_confirm),
                fontSz = 24.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            NormalTextComponent(
                value = stringResource(id = R.string.text_sent_code_email_address_to_confirm),
                colorCustom = colorResource(id = R.color.colorLightGreen),
            )
            Spacer(modifier = Modifier.height(30.dp))
            HeaderTextComponent(
                value = stringResource(id = R.string.text_code),
                fontSz = 12.sp,
                colorCustom = colorResource(id = R.color.colorMediumGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(leadingIcon = null, keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomClickableText(
                startText = stringResource(id = R.string.text_resend_code),
                valueText = "",
                onClick = {
                    navController.navigate(Destination.SignUpScreen.route)
                },
                colorText = colorResource(id = R.color.colorGreen),
            )
            Spacer(modifier = Modifier.height(40.dp))
            BtnDefault(
                onClick = {

                },
                labelValue = stringResource(id = R.string.text_complete_reg),
                colorResource(id = R.color.colorGreen),
                Color.White,
            )
            Spacer(modifier = Modifier.height(18.dp))

            CustomClickableText(
                startText = stringResource(id = R.string.text_code_doesnt_come),
                valueText = stringResource(id = R.string.text_change_email_address),
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
fun DefaultPreviewOfConfirmationOfRegScreen() {
    val navControllerFake = rememberNavController()
    ConfirmationOfRegScreen(navController = navControllerFake)
}