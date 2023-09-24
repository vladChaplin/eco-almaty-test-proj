package kz.enactus.ecoalmaty.android.components.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kz.enactus.ecoalmaty.android.R

@Composable
fun AVerificationEmailTextField() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        ACustomTextField(
            leadingIcon = Icons.Filled.Email,
            leadingIconContentDesc = "emailIcon",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            backgroundColorCust = colorResource(id = R.color.colorWhiteBackground)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()

                .background(
                    color = colorResource(id = R.color.colorLightTransGreen),
                    shape = RoundedCornerShape(size = 8.dp)
                )
        ) {
            Icon(
                imageVector = Icons.Filled.PriorityHigh,
                contentDescription = "message",
                tint = colorResource(id = R.color.colorDarkGray),
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = stringResource(id = R.string.text_message_mail_not_reg) ,
                color = colorResource(id = R.color.colorDarkGray),
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 16.dp)
            )
        }
    }
}