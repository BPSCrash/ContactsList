package net.paulbogdan.contactslist.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.paulbogdan.contactslist.R
import net.paulbogdan.contactslist.ui.theme.AlmostBlack
import net.paulbogdan.contactslist.ui.theme.SFPro

@Composable
fun ContactsTopBar(
    title: String,
    onBackButtonClick: (() -> Unit)? = null
) {
    Column {
        TopAppBar(
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
            contentColor = AlmostBlack,
            backgroundColor = Color.White,
            elevation = 0.dp
        ) {

            if(onBackButtonClick != null){
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        painterResource(id = R.drawable.arrow_icon),
                        contentDescription = stringResource(id = R.string.see_profile),
                        tint = AlmostBlack,
                        modifier = Modifier
                            .rotate(180f)
                            .size(25.dp)
                    )
                }
            }
            Text(
                text = title,
                fontFamily = SFPro,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = AlmostBlack
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    ContactsTopBar("Contacte")
}

@Preview(showBackground = true)
@Composable
fun TopBarWithBackPreview() {
    ContactsTopBar("Detalii contact") {}
}