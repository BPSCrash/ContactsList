package net.paulbogdan.contactslist.ui.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import net.paulbogdan.contactslist.ui.screens.ContactsScreen
import net.paulbogdan.contactslist.ui.screens.ProfileScreen
import net.paulbogdan.contactslist.ui.theme.enterTransition
import net.paulbogdan.contactslist.ui.theme.exitTransition
import net.paulbogdan.contactslist.viewModel.UserViewModel

@ExperimentalGlideComposeApi
@ExperimentalAnimationApi
@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestinationScreen: NavigationItem,
    userViewModel: UserViewModel
) {

    val slideDirectionLeft = AnimatedContentScope.SlideDirection.Left
    val slideDirectionRight = AnimatedContentScope.SlideDirection.Right

    AnimatedNavHost(
        navController = navController,
        startDestination = startDestinationScreen.route
    ) {

        composable(
            route = NavigationItem.ContactScreen.route
        ) {
            ContactsScreen(userViewModel = userViewModel,
            onContactClick = {
                navController.navigate(NavigationItem.ProfileScreen.route)
            })
        }

        composable(
            route = NavigationItem.ProfileScreen.route,
            enterTransition = enterTransition(slideDirectionLeft),
            exitTransition = exitTransition(slideDirectionRight),
        ) {
            ProfileScreen(
                onBackButtonClick = { navController.navigateUp() },
                userViewModel = userViewModel,
                user = userViewModel.selectedUser
            )
        }
    }
}