package kz.enactus.ecoalmaty.android.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.enactus.ecoalmaty.android.screens.AuthorizationScreen
import kz.enactus.ecoalmaty.android.screens.RestorePasswordScreen
import kz.enactus.ecoalmaty.android.screens.SignUpScreen
import kz.enactus.ecoalmaty.android.screens.WelcomeScreen

sealed class Destination(val route: String) {
    object WelcomeScreen: Destination("WelcomeScreen")
    object SignUpScreen: Destination("SignUpScreen")
    object AuthorizationScreen: Destination("AuthorizationScreen")
    object RestorePasswordScreen: Destination("RestorePasswordScreen")
}

@Composable
fun MainEcoAlmatyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = Destination.WelcomeScreen.route) {
            composable(Destination.WelcomeScreen.route) {
                WelcomeScreen(navController)
            }
            composable(Destination.SignUpScreen.route) {
                SignUpScreen(navController)
            }
            composable(Destination.AuthorizationScreen.route) {
                AuthorizationScreen(navController)
            }
            composable(Destination.RestorePasswordScreen.route) {
                RestorePasswordScreen(navController)
            }
        }

    }
}