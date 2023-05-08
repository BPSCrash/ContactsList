package net.paulbogdan.contactslist.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class NavigationItem(
    val route: String,
    @StringRes val title: Int = 0,
    @DrawableRes val icon: Int = 0
) {
    object ContactScreen : NavigationItem("main/contacts")
    object ProfileScreen : NavigationItem("main/profile")
}