package kz.enactus.ecoalmaty.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.enactus.ecoalmaty.android.app.MainEcoAlmatyApp
import kz.enactus.ecoalmaty.android.screens.AuthorizationScreen
import kz.enactus.ecoalmaty.android.screens.SignUpScreen
import kz.enactus.ecoalmaty.android.screens.WelcomeScreen
import kz.enactus.ecoalmaty.android.ui.theme.EcoAlmatyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainEcoAlmatyApp()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EcoAlmatyAppTheme {
        Greeting("Android")
    }
}