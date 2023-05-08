package net.paulbogdan.contactslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import net.paulbogdan.contactslist.ui.navigation.AppNavGraph
import net.paulbogdan.contactslist.ui.navigation.NavigationItem
import net.paulbogdan.contactslist.ui.theme.ContactsListTheme
import net.paulbogdan.contactslist.viewModel.UserViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val userViewModel: UserViewModel by viewModels()
    private lateinit var navController: NavHostController

    @OptIn(ExperimentalGlideComposeApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberAnimatedNavController()
            val startDestination = NavigationItem.ContactScreen
            ContactsListTheme {
                LaunchedEffect(key1 = true) {
                    userViewModel.getUsers()
                }
                AppNavGraph(
                    navController = navController,
                    userViewModel = userViewModel,
                    startDestinationScreen = startDestination
                )
            }
        }
    }
}