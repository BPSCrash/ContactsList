package net.paulbogdan.contactslist.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.paulbogdan.contactslist.model.User
import net.paulbogdan.contactslist.ui.screens.mockProfile
import net.paulbogdan.contactslist.ui.theme.AlmostBlack
import net.paulbogdan.contactslist.ui.theme.DarkGray

@Composable
fun ProfileInfoCluster(user: User) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(vertical = 10.dp)

    ) {

        Box(Modifier.size(46.dp)) {
            ImagePlaceholder()
        }
        Text(
            text = user.name,
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = AlmostBlack
        )
        Text(
            text = user.email.lowercase(),
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp,
            color = DarkGray
        )
    }
}

@Preview
@Composable
fun ProfileStackPreview() {
    ProfileInfoCluster(mockProfile)
}