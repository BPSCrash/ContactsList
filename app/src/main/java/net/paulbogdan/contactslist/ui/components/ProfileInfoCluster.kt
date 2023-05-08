package net.paulbogdan.contactslist.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import net.paulbogdan.contactslist.model.User
import net.paulbogdan.contactslist.ui.theme.AlmostBlack
import net.paulbogdan.contactslist.ui.theme.DarkGray

@ExperimentalGlideComposeApi
@Composable
fun ProfileInfoCluster(user: User) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(vertical = 10.dp)

    ) {

        Box(Modifier.size(46.dp)) {
            GlideImage(
                model = "https://picsum.photos/seed/${user.id}/200/200",
                contentDescription = null,
                modifier = Modifier.clip(CircleShape)
            )
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