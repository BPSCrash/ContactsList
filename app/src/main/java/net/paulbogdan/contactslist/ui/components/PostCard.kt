package net.paulbogdan.contactslist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.paulbogdan.contactslist.model.Post
import net.paulbogdan.contactslist.model.mockPost
import net.paulbogdan.contactslist.ui.theme.AlmostBlack
import net.paulbogdan.contactslist.ui.theme.DarkGray
import net.paulbogdan.contactslist.ui.theme.InfoBoxGray
import net.paulbogdan.contactslist.ui.theme.SFPro

@Composable
fun PostCard(post: Post) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .background(color = InfoBoxGray)
            .padding(24.dp)

    ) {

        Text(
            text = post.title,
            fontFamily = SFPro,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = AlmostBlack,
            textAlign = TextAlign.Start
        )
        Text(
            text = post.body,
            fontFamily = SFPro,
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp,
            color = DarkGray,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun PostCardPreview() {
    PostCard(post = mockPost)
}
