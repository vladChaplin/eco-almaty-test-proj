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
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.components.buttons.ABtnDefault
import kz.enactus.ecoalmaty.android.components.containers.AContainerDefault
import kz.enactus.ecoalmaty.android.components.text.AHeaderTextComponent
import kz.enactus.ecoalmaty.android.components.text.AIconAndTextComponent
import kz.enactus.ecoalmaty.android.components.text.ANormalTextComponent
import kz.enactus.ecoalmaty.android.components.text.ATextWithStatus
import kz.enactus.ecoalmaty.android.components.ui.AUserAvatarWithStatus
import kz.enactus.ecoalmaty.android.enums.UserStatus

@Composable
fun ProfileScreen(navController: NavController) {

    Surface (
        color = colorResource(id = R.color.colorWhiteBackground),
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorWhiteBackground))
            .padding(
                start = 10.dp,
                top = 60.dp,
                end = 10.dp,
                bottom = 24.dp
            )
    ) {
        Column {
            AContainerDefault(
                modifier = Modifier.height(126.dp)
            ) {
                Row(
                    modifier = Modifier.padding(
                        start = 12.dp,
                        top = 24.dp,
                        end = 12.dp,
                        bottom = 24.dp
                    )
                ) {
                    AUserAvatarWithStatus(
                        id = "0",
                        firstName = stringResource(id = R.string.text_first_name),
                        lastName = stringResource(id = R.string.text_last_name),
                        status = UserStatus.Online)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column (
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        ANormalTextComponent(
                            value = stringResource(id = R.string.text_first_name) + " " +
                                    stringResource(id = R.string.text_last_name)
                        )
                        ATextWithStatus(
                            text = stringResource(id = R.string.text_status_online),
                            status = UserStatus.Online)
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            AContainerDefault() {
                Column(
                    modifier = Modifier.padding(
                        start = 12.dp,
                        top = 24.dp,
                        end = 12.dp,
                        bottom = 24.dp
                    )
                ) {
                    AHeaderTextComponent(
                        value = stringResource(id = R.string.text_my_contacts),
                        fontSz = 28.sp,
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    AIconAndTextComponent(
                        icon = Icons.Outlined.Phone,
                        text = stringResource(id = R.string.text_profile_phone),
                        )
                    Spacer(modifier = Modifier.height(19.dp))
                    AIconAndTextComponent(
                        icon = Icons.Outlined.Email,
                        text = stringResource(id = R.string.text_profile_email),
                        colorText = colorResource(id = R.color.colorBlue)
                    )
                    Spacer(modifier = Modifier.height(19.dp))
                    AIconAndTextComponent(
                        icon = Icons.Outlined.Home,
                        text = stringResource(id = R.string.text_profile_address),
                    )
                    Spacer(modifier = Modifier.height(19.dp))
                    ABtnDefault(
                        onClick = { /*

                        */ },
                        labelValue = stringResource(id = R.string.text_edit),
                        backgroundColor = colorResource(id = R.color.colorGreen),
                        textColor = colorResource(id = R.color.white),
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

@Preview
@Composable
fun DefaultPreviewOfProfileScreen() {
    val navControllerFake = rememberNavController()
    ProfileScreen(navController = navControllerFake)
}