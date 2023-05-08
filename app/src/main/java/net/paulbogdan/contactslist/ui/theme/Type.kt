package net.paulbogdan.contactslist.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import net.paulbogdan.contactslist.R

// Set of Material typography styles to start with
val SFPro = FontFamily(
    Font(R.font.sf_pro_text_regular, weight = FontWeight.Normal),
    Font(R.font.sf_pro_text_semibold, weight = FontWeight.SemiBold),
    Font(R.font.sf_pro_text_bold, weight = FontWeight.Bold)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = SFPro,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        color = AlmostBlack
    ),

    h1 = TextStyle(
        fontFamily = SFPro,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = AlmostBlack,
    ),

    h2 = TextStyle(
        fontFamily = SFPro,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        color = AlmostBlack
    ),

    caption = TextStyle(
        fontFamily = SFPro,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        color = CaptionGray
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)