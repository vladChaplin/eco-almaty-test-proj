package kz.enactus.ecoalmaty.android.components.utils
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.delay
import kz.enactus.ecoalmaty.android.R
import java.util.concurrent.TimeUnit

@Composable
fun ACountdownTimer() {
    var timeLeft by remember { mutableStateOf(59L)}
    LaunchedEffect(key1 = timeLeft) {
        while (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }
    fun resetTimer() {
        timeLeft = 60
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        val minutes = TimeUnit.SECONDS.toMinutes(timeLeft)
        val seconds = TimeUnit.SECONDS.toSeconds(timeLeft)
        Text(
            text = String.format("через %02d:%02d", minutes, seconds),
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.colorMediumGray)
        )
    }

}