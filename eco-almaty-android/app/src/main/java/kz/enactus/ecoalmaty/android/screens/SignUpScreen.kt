package kz.enactus.ecoalmaty.android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.components.CustomTextField
import kz.enactus.ecoalmaty.android.components.HeaderTextComponent
import kz.enactus.ecoalmaty.android.components.NormalTextComponent

@Composable
fun SignUpScreen(navController: NavController) {

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()) {
            HeaderTextComponent(value = stringResource(id = R.string.textHello))
            NormalTextComponent(value = stringResource(id = R.string.textInputData))
            CustomTextField(labelValue = stringResource(id = R.string.textField))
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    val navControllerFake = rememberNavController()
    SignUpScreen(navControllerFake)
}