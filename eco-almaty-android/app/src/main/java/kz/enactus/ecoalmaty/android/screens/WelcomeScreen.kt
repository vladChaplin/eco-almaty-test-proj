package kz.enactus.ecoalmaty.android.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kz.enactus.ecoalmaty.android.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.enactus.ecoalmaty.android.app.Destination
import kz.enactus.ecoalmaty.android.components.buttons.AButton
import kz.enactus.ecoalmaty.android.components.text.AHeader

@Composable
fun WelcomeScreen(navController: NavController) {
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
            Spacer(modifier = Modifier.height(300.dp))
            AHeader(value = stringResource(id = R.string.text_clear_city))
            Spacer(modifier = Modifier.height(40.dp))
            AButton(
                onClick = { navController.navigate(Destination.AuthorizationScreen.route) },
                labelValue = stringResource(id = R.string.text_signin),
                colorResource(id = R.color.colorGreen),
                Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            AButton(
                onClick = { navController.navigate(Destination.SignUpScreen.route) },
                labelValue = stringResource(id = R.string.text_signup),
                colorResource(id = R.color.colorGray),
                colorResource(id = R.color.colorDarkGray)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfWelcomeScreen() {
    val navControlFake = rememberNavController()
    WelcomeScreen(navControlFake)
}