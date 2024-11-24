package kz.enactus.ecoalmaty.android.app
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kz.enactus.ecoalmaty.android.models.AuthViewModel
import kz.enactus.ecoalmaty.android.screens.AddEmployeeScreen
import kz.enactus.ecoalmaty.android.screens.AuthorizationScreen
import kz.enactus.ecoalmaty.android.screens.ConfirmationOfRegScreen
import kz.enactus.ecoalmaty.android.screens.EmployeeDetailScreen
import kz.enactus.ecoalmaty.android.screens.EmployeeListScreen
import kz.enactus.ecoalmaty.android.screens.ProfileScreen
import kz.enactus.ecoalmaty.android.screens.RestorePasswordScreen
import kz.enactus.ecoalmaty.android.screens.SignUpScreen
import kz.enactus.ecoalmaty.android.screens.WelcomeScreen
import kz.enactus.ecoalmaty.android.services.getToken

sealed class Destination(val route: String) {
    object WelcomeScreen : Destination("WelcomeScreen")
    object SignUpScreen : Destination("SignUpScreen")
    object AuthorizationScreen : Destination("AuthorizationScreen")
    object RestorePasswordScreen : Destination("RestorePasswordScreen")
    object ConfirmationOfRegScreen : Destination("ConfirmationOfRegScreen")
    object ProfileScreen : Destination("ProfileScreen")
    object AddEmployeeScreen : Destination("AddEmployeeScreen")
    object EmployeeDetailScreen : Destination("EmployeeDetailScreen")
    object EmployeeListScreen : Destination("EmployeeListScreen")
}

@Composable
fun MainEcoAlmatyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Destination.WelcomeScreen.route) {
            composable(Destination.WelcomeScreen.route) { WelcomeScreen(navController) }
            composable(Destination.SignUpScreen.route) { SignUpScreen(navController) }
            composable(Destination.AuthorizationScreen.route) { AuthorizationScreen(navController) }
            composable(Destination.RestorePasswordScreen.route) { RestorePasswordScreen(navController) }
            composable(Destination.ConfirmationOfRegScreen.route) { ConfirmationOfRegScreen(navController) }
            composable(
                "profile_screen/{username}/{email}/{roles}",
                arguments = listOf(
                    navArgument("username") { type = NavType.StringType },
                    navArgument("email") { type = NavType.StringType },
                    navArgument("roles") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val username = backStackEntry.arguments?.getString("username") ?: ""
                val email = backStackEntry.arguments?.getString("email") ?: ""
                val roles = backStackEntry.arguments?.getString("roles") ?: ""
                ProfileScreen(navController, username, email, roles)
            }
            composable("add_employee_screen/{userRole}") { backStackEntry ->
                val context = LocalContext.current
                val token = getToken(context)
                val userRole = backStackEntry.arguments?.getString("userRole") ?: ""

                if (token != null) {
                    AddEmployeeScreen(
                        navController = navController,
                        token = token,
                        role = userRole // Pass the role
                    )
                } else {
                    Toast.makeText(context, "Токен не найден. Авторизуйтесь снова.", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
            }
            composable("employee_list_screen/{userRole}") { backStackEntry ->
                val context = LocalContext.current
                val token = getToken(context)
                val userRole = backStackEntry.arguments?.getString("userRole") ?: ""

                if (token != null) {
                    EmployeeListScreen(
                        navController = navController,
                        token = token,
                        userRole = userRole // Pass the role to the screen
                    )
                } else {
                    Toast.makeText(context, "Токен не найден. Авторизуйтесь снова.", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
            }
            composable(
                "employee_detail_screen/{employeeId}",
                arguments = listOf(navArgument("employeeId") { type = NavType.StringType })
            ) { backStackEntry ->
                val context = LocalContext.current
                val token = getToken(context)
                val employeeId = backStackEntry.arguments?.getString("employeeId") ?: ""
                if (token != null) {
                    EmployeeDetailScreen(navController, employeeId, token)
                }else {
                    Toast.makeText(context, "Токен не найден. Авторизуйтесь снова.", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
            }
        }
    }
}