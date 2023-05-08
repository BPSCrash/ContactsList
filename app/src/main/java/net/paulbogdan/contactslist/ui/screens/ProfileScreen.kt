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
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import net.paulbogdan.contactslist.R
import net.paulbogdan.contactslist.model.User
import net.paulbogdan.contactslist.model.mockPost
import net.paulbogdan.contactslist.model.mockProfile
import net.paulbogdan.contactslist.ui.components.PostCard
import net.paulbogdan.contactslist.ui.components.ProfileInfoCluster
import net.paulbogdan.contactslist.ui.navigation.ContactsTopBar

@ExperimentalGlideComposeApi
@Composable
fun ProfileScreen(
    onBackButtonClick: () -> Unit,
    user: User
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
                ProfileInfoCluster(user = user)
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

@ExperimentalGlideComposeApi
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen({}, mockProfile)
}