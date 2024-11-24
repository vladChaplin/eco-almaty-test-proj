package kz.enactus.ecoalmaty.android.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
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
import kz.enactus.ecoalmaty.android.components.buttons.AButton
import kz.enactus.ecoalmaty.android.components.containers.AContainer
import kz.enactus.ecoalmaty.android.components.text.AHeader
import kz.enactus.ecoalmaty.android.components.text.AIconAndText
import kz.enactus.ecoalmaty.android.components.text.ALabel
import kz.enactus.ecoalmaty.android.components.text.ATextWithStatus
import kz.enactus.ecoalmaty.android.components.ui.AUserAvatarWithStatus
import kz.enactus.ecoalmaty.android.enums.UserStatus
import kz.enactus.ecoalmaty.android.services.AuthRequest
import kz.enactus.ecoalmaty.android.services.authUser


fun getRoleInRussian(role: String): String {
    return when (role) {
        "ROLE_ADMIN" -> "Админ"
        "ROLE_SENIOR_TEACHER" -> "Старший преподаватель"
        "ROLE_TEACHER" -> "Преподаватель"
        "ROLE_OPERATOR" -> "Оператор"
        else -> role // Возвращаем оригинал, если роль неизвестна
    }
}

@Composable
fun ProfileScreen(navController: NavController, username: String, email: String, roles: String) {
    Surface(
        color = colorResource(id = R.color.colorWhiteBackground),
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorWhiteBackground))
            .padding(start = 10.dp, top = 60.dp, end = 10.dp, bottom = 24.dp)
    ) {
        Column {
            // User Avatar and Basic Info Container
            AContainer(modifier = Modifier.height(126.dp)) {
                Row(
                    modifier = Modifier.padding(start = 12.dp, top = 24.dp, end = 12.dp, bottom = 24.dp)
                ) {
                    AUserAvatarWithStatus(
                        id = "0",
                        firstName = username,
                        lastName = "",
                        status = UserStatus.ONLINE
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        ALabel(value = username)
                        ATextWithStatus(text = "Статус: Онлайн", status = UserStatus.ONLINE)
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Contact Information Container
            AContainer {
                Column(
                    modifier = Modifier.padding(start = 12.dp, top = 24.dp, end = 12.dp, bottom = 24.dp)
                ) {
                    AHeader(value = "Обо мне", fontSz = 28.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                    AIconAndText(
                        icon = Icons.Outlined.Email,
                        text = email,
                        colorText = colorResource(id = R.color.colorBlue)
                    )
                    Spacer(modifier = Modifier.height(19.dp))

                    val translatedRole = getRoleInRussian(roles)

                    AIconAndText(
                        icon = Icons.Outlined.Person,
                        text = translatedRole,  // Display the translated role
                        colorText = colorResource(id = R.color.colorMediumGray)
                    )

                    Spacer(modifier = Modifier.height(19.dp))
                    AButton(
                        onClick = {
                            navController.navigate("employee_list_screen/${roles}")
                        },
                        labelValue = "Сотрудники",
                        backgroundColor = colorResource(id = R.color.colorGreen),
                        textColor = colorResource(id = R.color.white),
                        fontSz = 17.sp,
                        heightBtn = 27.dp,
                        modifier = Modifier
                            .wrapContentSize()
                            .width(200.dp)
                    )

                    // Show "Добавить сотрудника" button only for admin users
                    if (roles == "ROLE_ADMIN") {
                        Spacer(modifier = Modifier.height(19.dp))
                        AButton(
                            onClick = { navController.navigate("add_employee_screen/${roles}") },
                            labelValue = "Добавить сотрудника",
                            backgroundColor = colorResource(id = R.color.colorGreen),
                            textColor = Color.White,
                            fontSz = 17.sp,
                            heightBtn = 27.dp,
                            modifier = Modifier
                                .wrapContentSize()
                                .width(200.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfProfileScreen() {
    val navControllerFake = rememberNavController()
    ProfileScreen(navController = navControllerFake, "Petya", "petr@gmail.com", "admin")
}