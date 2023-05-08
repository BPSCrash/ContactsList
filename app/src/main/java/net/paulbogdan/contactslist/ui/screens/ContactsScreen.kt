package net.paulbogdan.contactslist.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import net.paulbogdan.contactslist.R
import net.paulbogdan.contactslist.ui.components.ContactItem
import net.paulbogdan.contactslist.ui.navigation.ContactsTopBar
import net.paulbogdan.contactslist.ui.theme.AlmostBlack
import net.paulbogdan.contactslist.ui.theme.BackgroundGray
import net.paulbogdan.contactslist.ui.theme.CaptionGray
import net.paulbogdan.contactslist.ui.theme.SFPro
import net.paulbogdan.contactslist.viewModel.UserViewModel

@ExperimentalGlideComposeApi
@Composable
fun ContactsScreen(
    userViewModel: UserViewModel,
    onContactClick: () -> Unit
) {
    val userList = userViewModel.userList
    val isLoading = userViewModel.loadingStatus

    Scaffold(
        topBar = {
            ContactsTopBar(title = stringResource(id = R.string.contacts), null)
        }
    ) {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .background(BackgroundGray),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.my_contacts).uppercase(),
                    fontFamily = SFPro,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = CaptionGray,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp)
                )
            }
            userList.filter { it.status == "active" }.forEach { user ->
                item {
                    ContactItem(user, { onContactClick() }, userViewModel)
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