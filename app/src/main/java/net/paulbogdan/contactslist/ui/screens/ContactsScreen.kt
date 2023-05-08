package net.paulbogdan.contactslist.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import net.paulbogdan.contactslist.R
import net.paulbogdan.contactslist.ui.components.ContactItem
import net.paulbogdan.contactslist.ui.navigation.ContactsTopBar
import net.paulbogdan.contactslist.ui.theme.BackgroundGray
import net.paulbogdan.contactslist.ui.theme.CaptionGray
import net.paulbogdan.contactslist.ui.theme.SFPro
import net.paulbogdan.contactslist.viewModel.UserViewModel

@ExperimentalGlideComposeApi
@Composable
fun ContactsScreen(userViewModel: UserViewModel) {

    LaunchedEffect(key1 = true) {
        userViewModel.getUsers()

    }
    val userList = userViewModel.userList

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
                    ContactItem(user) {}
                }
            }
        }
    }
}