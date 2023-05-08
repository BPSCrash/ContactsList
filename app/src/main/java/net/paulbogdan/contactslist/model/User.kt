package net.paulbogdan.contactslist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String
): Parcelable {

    fun getInitials(): String {
        return name
            .split(" ")
            .mapNotNull { it.firstOrNull()?.toString() }
            .reduce { acc, s -> acc + s }
    }
}