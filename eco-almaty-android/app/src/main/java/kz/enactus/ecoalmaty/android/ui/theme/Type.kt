package kz.enactus.ecoalmaty.android.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kz.enactus.ecoalmaty.android.R

val montserratFontFamily = FontFamily(
        Font(R.font.montserrat_bold, weight = FontWeight.Bold),
        Font(R.font.montserrat_semi_bold, weight = FontWeight.SemiBold),
        Font(R.font.montserrat_medium, weight = FontWeight.Medium),
        Font(R.font.montserrat_regular, weight = FontWeight.Normal),
        Font(R.font.montserrat_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
        Font(R.font.montserrat_semi_bold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
        Font(R.font.montserrat_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
)

val MontserratTypography = Typography(
        bodyLarge = TextStyle(
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        ),

)

// Set of Material typography styles to start with
/*
val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        )
        */
/* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    *//*

)*/
