package net.paulbogdan.contactslist.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.paulbogdan.contactslist.R
import net.paulbogdan.contactslist.model.Post
import net.paulbogdan.contactslist.model.Profile
import net.paulbogdan.contactslist.ui.components.PostCard
import net.paulbogdan.contactslist.ui.components.ProfileInfoCluster
import net.paulbogdan.contactslist.ui.navigation.ContactsTopBar

val mockProfile = Profile("Testmail@test.com", "male", 32, "John Doe", "Online")
val mockPost = Post(
    "This post contains lots of words and such bla bla bla it should overflow in 2 lines and it should go off now",
    1,
    "This is the post title",
    2
)

@Composable
fun ProfileScreen(
    onBackButtonClick: () -> Unit,
    profile: Profile
) {

    Scaffold(
        topBar = {
            ContactsTopBar(
                title = stringResource(id = R.string.contact_details),
                onBackButtonClick = onBackButtonClick
            )
        }
    ) {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                ProfileInfoCluster(profile = mockProfile)
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }

            item { 
                PostCard(post = mockPost)
            }
            item {
                PostCard(post = mockPost)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {

    ProfileScreen({}, mockProfile)
}