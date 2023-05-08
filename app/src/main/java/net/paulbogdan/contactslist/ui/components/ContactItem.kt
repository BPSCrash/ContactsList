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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import net.paulbogdan.contactslist.R
import net.paulbogdan.contactslist.model.User
import net.paulbogdan.contactslist.ui.theme.IconGray
import net.paulbogdan.contactslist.ui.theme.SFPro
import net.paulbogdan.contactslist.viewModel.UserViewModel

@ExperimentalGlideComposeApi
@Composable
fun ContactItem(
    user: User,
    onContactClick: (user: User) -> Unit,
    userViewModel: UserViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                userViewModel.setActiveUser(user)
                onContactClick(user)
            }
            .background(Color.White)
            .padding(24.dp)
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
                if (user.id % 2 == 0) {
                    GlideImage(
                        model = "https://picsum.photos/seed/${user.id}/200/200",
                        contentDescription = null,
                        modifier = Modifier.clip(CircleShape)
                    )
                } else {
                    ImagePlaceholder(user.getInitials())
                }

            }
            Text(
                text = user.name,
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
fun ImagePlaceholder(initials: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = IconGray, CircleShape)
            .clip(CircleShape)
    ) {
        Text(
            text = initials,
            fontFamily = SFPro,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 17.sp
        )
    }
}