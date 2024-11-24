package kz.enactus.ecoalmaty.android.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import kz.enactus.ecoalmaty.android.components.utils.ACountdownTimer
import kz.enactus.ecoalmaty.android.components.text.AClickableText
import kz.enactus.ecoalmaty.android.components.buttons.AButton
import kz.enactus.ecoalmaty.android.components.inputs.ASimpleTextField
import kz.enactus.ecoalmaty.android.components.text.AHeader
import kz.enactus.ecoalmaty.android.components.text.ALabel
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

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
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Заголовок "Успешная регистрация!"
            Text(
                text = "Успешная регистрация!",
                color = colorResource(id = R.color.colorLightGreen),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Подсказка ниже заголовка
            Text(
                text = "Для того, чтобы продолжить работу с приложением, необходимо войти, нажав на кнопку \"Войти\" ниже.",
                color = colorResource(id = R.color.colorMediumGray),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(30.dp))
            // Кнопка "Войти"
            AButton(
                onClick = { navController.navigate(Destination.AuthorizationScreen.route) },
                labelValue = stringResource(id = R.string.text_signin),
                colorResource(id = R.color.colorGreen),
                Color.White
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfRegistrationSuccessScreen() {
    val navControllerFake = rememberNavController()
    ConfirmationOfRegScreen(navController = navControllerFake)
}