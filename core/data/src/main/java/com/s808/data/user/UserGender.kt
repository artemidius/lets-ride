@file:Suppress("ParcelCreator")
package com.s808.data.user

import android.os.Parcelable
import com.s808.data.user.UserGender.*
import kotlinx.parcelize.Parcelize


@Parcelize
sealed class UserGender(val text: String): Parcelable {
    object Male: UserGender("Gentleman")
    object Female: UserGender("Lady")
    object Other: UserGender("Other")
}

fun String.getUserGender(): UserGender =
    when(this) {
        "Gentleman" -> Male
        "Lady" -> Female
        else -> Other
    }
