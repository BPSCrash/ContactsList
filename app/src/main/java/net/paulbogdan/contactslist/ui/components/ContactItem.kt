package net.paulbogdan.contactslist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.paulbogdan.contactslist.R
import net.paulbogdan.contactslist.ui.theme.IconGray
import net.paulbogdan.contactslist.ui.theme.SFPro

@Composable
fun ContactItem(onContactClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(24.dp)
            .clickable { onContactClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                Modifier
                    .size(46.dp),
                contentAlignment = Alignment.Center,
            ) {
                ImagePlaceholder()
            }
            Text(
                text = "Alina Manolache", //GET NAME FROM ENDPOINT
                style = MaterialTheme.typography.body1,
                modifier = Modifier.weight(1f)

            )
            Icon(
                painterResource(id = R.drawable.arrow_icon),
                contentDescription = stringResource(id = R.string.see_profile),
            )
        }
    }
}

@Composable
fun ImagePlaceholder() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = IconGray, CircleShape)
            .clip(CircleShape)
    ) {
        Text(
            text = "AT",
            fontFamily = SFPro,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 17.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactPreview() {
    ContactItem() {}
}