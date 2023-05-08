package net.paulbogdan.contactslist.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import net.paulbogdan.contactslist.R
import net.paulbogdan.contactslist.model.User
import net.paulbogdan.contactslist.ui.components.PostCard
import net.paulbogdan.contactslist.ui.components.ProfileInfoCluster
import net.paulbogdan.contactslist.ui.navigation.ContactsTopBar
import net.paulbogdan.contactslist.ui.theme.AlmostBlack
import net.paulbogdan.contactslist.viewModel.UserViewModel

@ExperimentalGlideComposeApi
@Composable
fun ProfileScreen(
    onBackButtonClick: () -> Unit,
    userViewModel: UserViewModel,
    user: User,
) {

    val isLoading = userViewModel.loadingStatus

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
            userViewModel.userPostsList.forEach { post ->
                item {
                    PostCard(post = post)
                }
            }
        }
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    )
                    {/*Blocks all interactions*/ }
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = AlmostBlack
                )
            }
        }
    }
}